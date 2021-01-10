package openti;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringEscapeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.drive.model.File;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.Id;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.property2.LightProperty;
import jp.silverbullet.core.property2.RuntimeProperty;
import jp.silverbullet.core.property2.SvFileException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.EasyAccessInterface;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.SystemAccessor;
import jp.silverbullet.dev.ControlObject;
import jp.silverbullet.dev.MessageObject;
import jp.silverbullet.web.ChangesJson;
import jp.silverbullet.web.FilePendingResponse;
import jp.silverbullet.web.ListStringClass;
import jp.silverbullet.web.MessageToDevice;
import jp.silverbullet.web.WebSocketClientHandler;
import jp.silverbullet.web.WsLoginMessage;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class AbstractIndependentMain {

	protected abstract void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException;
	protected abstract List<String> getTargetIds();
	protected abstract  RegisterAccessor getRegisterAccessor();
	protected abstract void init(SvHandlerModel model);
	
	private WebSocketClientHandler clienteHandler;
	private String host;
	private String port;
	private String application;
	private OkHttpClient client;// = new OkHttpClient.Builder().build();// new OkHttpClient();
	private String deviceName;
	private String userid;
	private IMainUI mainUI;
//	protected FileUploadMessage fileUploadMessage;
	private FilePendingResponse pendingFiles;
	private boolean headless;
	private String authenticationCode = "forDebug"; // This is tentative. MUST be implemented formally
	private String password;
	private String serialNo;
	
//	private List<FileUploadMessage> pendingFiles = new ArrayList<>();

	public AbstractIndependentMain(String host, String port, String userid, String password, String application, 
			String deviceName, String serialNo, boolean headless) {
		this.host = host;
		this.port = port;
		this.application = application;
		this.deviceName = deviceName;
		this.serialNo = serialNo;
		this.userid = userid;
		this.password = password;
		this.headless = headless;
		
		initialize(deviceName);
	}
	protected void initialize(String deviceName) {
		initAccess();
		if (!this.headless) {
			mainUI = new MainUI() {
				@Override
				protected void onWindowClosed() {
					logout();
				}
	
				@Override
				protected void downloadPendingFiles() {
					for (File file : pendingFiles.list) {
						AbstractIndependentMain.this.download(file.getId(), file.getName(), file.getParents().toString());	
					}
	
					getPendingFiles();
				}
	
				@Override
				protected List<File> getPendingFileList() {
					return AbstractIndependentMain.this.getPendingFiles();
				}
			};
			mainUI.setDeviceName(deviceName);
			mainUI.setVisible(true);
		}
		else {
			mainUI = new DummyUI();
		}
	}
	
	protected List<com.google.api.services.drive.model.File> getPendingFiles() {
        String url = getServer() + "/rest/"+ getPath() + "/pendingFiles?userid=" + userid + "&password=" + this.password + "&code=" + this.authenticationCode;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body != null) {
            	pendingFiles = new ObjectMapper().readValue(body.string(), FilePendingResponse.class);
            	return pendingFiles.list;
            }
            body.close();
            response.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	class ReceiverThread extends Thread {
		private BlockingQueue<Map<String, List<ChangedItemValue>>> queue = new ArrayBlockingQueue<>(20);

		@Override
		public void run() {
			while(true) {
				try {
					Map<String, List<ChangedItemValue>> d = queue.take();
					handle(d);
				} catch (InterruptedException | RequestRejectedException e) {
					e.printStackTrace();
				}
			}
		}
		public void push(Map<String, List<ChangedItemValue>> changes) {
			queue.add(deepCopy(changes));
		}
		
		private Map<String, List<ChangedItemValue>> deepCopy(Map<String, List<ChangedItemValue>> changes) {
			Map<String, List<ChangedItemValue>> ret = new HashMap<String, List<ChangedItemValue>>();
			for (String key : changes.keySet()) {
				List<ChangedItemValue> v = new ArrayList<ChangedItemValue>(changes.get(key));
				ret.put(key, v);
			}
			return ret;
		}
		
	}
	
	private void initAccess() {
		client = new OkHttpClient.Builder().build();// new OkHttpClient();;
        
		init(model);
		
		try {
			login(application, deviceName);
			ReceiverThread sender = new ReceiverThread();
			sender.start();
			createWebSocket(sender);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
	}
	protected void createWebSocket(ReceiverThread receiver) {
		try {
			clienteHandler = new WebSocketClientHandler(host, port) {
				@Override
				protected void onMessageReceived(String message2) {
					try {
						MessageToDevice m = new ObjectMapper().readValue(message2, MessageToDevice.class);
						
						if (m.type.equals(MessageToDevice.PROPERTYUPDATED)) {
							ChangesJson changed = new ObjectMapper().readValue(m.json, ChangesJson.class);
							if (isTargetIdChanged(changed.getChanges())) {
								receiver.push(changed.getChanges());
//								createThread(changed);
							}
						}
						else if (m.type.contentEquals(MessageToDevice.MESSAGE)) {
							MessageObject obj = new ObjectMapper().readValue(m.json, MessageObject.class);
							onMessage(obj);
						}
						else if (m.type.equals(MessageToDevice.FILEREADY)){
							pendingFiles = new ObjectMapper().readValue(m.json, FilePendingResponse.class);
							
							mainUI.onPendingFilesUpdated(pendingFiles.list);
							//download(fm.fileID, fm.path);
						}
						else if (m.type.equals(MessageToDevice.CLOSEMESSAGE)) {
							MessageObject obj = new ObjectMapper().readValue(m.json, MessageObject.class);
							onCloseMessage(obj.messageId);
						}

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

				@Override
				protected void onRecconected() {
					try {
						doWsLogin();
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
				}

				private void doWsLogin() throws JsonProcessingException {
					String str = createMessage();
					login(str);
				}
			};
			clienteHandler.login(createMessage());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract void onMessage(MessageObject obj);
	protected abstract void onCloseMessage(String messageId);
	
	protected void download(String fileID, String filename, String path) {
        String url = getServer() + "/rest/"+ getPath() + "/download?userid=" + userid + "&password=" + password + "&fileid=" + fileID + "&code="+ this.authenticationCode;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body != null) {
            	//this.writeResponseBodyToDisk(body, filename);
            	byte[] b = Base64.decodeBase64(body.string());
            	Files.write(Paths.get(filename), b, StandardOpenOption.CREATE);
            }
            body.close();
            response.close();
            
            confirmDonwloaded(fileID);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void confirmDonwloaded(String fileID) {
        String url = getServer() + "/rest/"+ getPath() + "/downloadCompleted?userid=" + userid + "&password=" + password + "&fileid=" + fileID + "&code=" + this.authenticationCode;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body != null) {

            }
            body.close();
            response.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
	
	private void login(String application2, String deviceName2) throws IOException {
        String url = getServer() + "/rest/"+ getPath() + "/login?userid=" + this.userid + "&password=" + password + "&code=" + this.authenticationCode ;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);

        Response response = call.execute();
        ResponseBody body = response.body();
        if (body != null) {

        }
        body.close();
	}
	
	public void logout() {
		
        String url = getServer() + "/rest/"+ getPath() + "/logout?userid=" + this.userid + "&password=" + password + "&code=" + this.authenticationCode;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body != null) {

            }
            body.close();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        clienteHandler.close();
	}
	
	public List<String> getAutoScripts() {
        String url = getServer() + "/rest/"+ this.application + "/domain/autoScriptListFromDevice?userid=" + this.userid + "&password=" + password + "&code=" + this.authenticationCode ;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);

        try {
	        Response response = call.execute();
	        ResponseBody body = response.body();
	        
	        ListStringClass ret = new ListStringClass();
	        if (body != null) {
	        	
	        	ret = new ObjectMapper().readValue(body.byteStream(), ListStringClass.class);
	        }
	        body.close();
	        return ret.list;
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
	}
	
	
	public List<String> retreiveScript(String name) {
        String url = getServer() + "/rest/"+ this.application + "/domain/autoScriptFromDevice?" + "userid=" + userid + "&password=" + password
        		+ "&code=" + this.authenticationCode + "&name=" + name;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);
        ListStringClass result = new ListStringClass();

        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body != null) {
            	result = new ObjectMapper().readValue(body.byteStream(), ListStringClass.class);
                body.close();
                response.close();
                return result.list;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

	}	
	protected boolean isTargetIdChanged(Map<String, List<ChangedItemValue>> changed) {
		List<String> targets = getTargetIds();
		for (String id : changed.keySet()) {
			if (id.contains(RuntimeProperty.INDEXSIGN)) {
				id = id.split(RuntimeProperty.INDEXSIGN)[0];
			}
			if (targets.contains(id)) {
				return true;
			}
		}
		return false;
	}

	private String getServer() {
		return "http://"+ this.host + ":" + this.port;
	}
	
	protected void sendChangeValue(String id, String value) {
		LightProperty prop = new LightProperty();
		prop.id = id;
		prop.currentValue = value;
		
		try {
			String json = new ObjectMapper().writeValueAsString(prop);
	        String url = getServer() + "/rest/" + getPath() + "/setValueBySystem?userid=" + userid + "&password=" + password + "&code=" + this.authenticationCode;
	        RequestBody body = RequestBody.create(MediaType.get("application/json"), json);
			Request request = new Request.Builder()
				.url(url)
				.post(body)
				.build();
			
            Response response = client.newCall(request).execute();

            response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	protected void sendChangeValue(String id, Object blob, String name) {
		int index = 0;

		try {
			String json = new ObjectMapper().writeValueAsString(blob);
	        String url = getServer() + "/rest/"+ getPath() + "/postValueBySystem?index=" + index + 
	        		"&userid=" + userid + "&password=" + password + "&code=" + this.authenticationCode + "&id=" + id
	        		+ "&name=" + name + "&classname=" + blob.getClass().getName();
			//RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), json);
	        RequestBody body = RequestBody.create(MediaType.get("application/json"), json);
			Request request = new Request.Builder()
				.url(url)
				.post(body)
				.build();
			
            Response response = client.newCall(request).execute();
            response.close();
  //          response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(blob);
	}
	
	private LightProperty retreiveProperty(String id2) {
		String id, index;
		if (id2.contains(RuntimeProperty.INDEXSIGN)) {
			String[] tmp = id2.split(RuntimeProperty.INDEXSIGN);
			id = tmp[0];
			index = tmp[1];
		}
		else {
			id = id2;
			index = "0";
		}
        String url = getServer() + "/rest/"+ getPath() + "/getProperty?index=" + index + 
        		"&userid=" + userid + "&password=" + password + "&code=" + this.authenticationCode + "&id=" + id;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);
        String result = "";

        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body != null) {
                result = body.string();
                body.close();
                response.close();
                LightProperty uiProperty = new ObjectMapper().readValue(result, LightProperty.class);
                return uiProperty;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;	
	}
	
	private String getPath() {
		String ret = application + "/domain/" + deviceName;
		ret = ret.replace("#", "&#035").replace("@", "&#064;");
		return ret;
	}

	private SvHandlerModel model = new SvHandlerModel() {
		@Override
		public EasyAccessInterface getEasyAccessInterface() {
			return new EasyAccessInterface() {
				@Override
				public void requestChange(Id id, String value) throws RequestRejectedException {
					sendChangeValue(id.getId(), value);
				}

				@Override
				public void requestChange(Id id, Object blobData, String name) throws RequestRejectedException {
					sendChangeValue(id.getId(), blobData, name);
				}

				@Override
				public String getCurrentValue(String id) {
					LightProperty prop = retreiveProperty(id);
					return prop.currentValue;
				}

				@Override
				public String getSelectedListTitle(String id) {
					LightProperty prop = retreiveProperty(id);
					return prop.selectedListTitle;
				}
				
			};
		}

		@Override
		public RegisterAccessor getRegisterAccessor() {
			return AbstractIndependentMain.this.getRegisterAccessor();
		}

		@Override
		public SystemAccessor getSystem() {
			return new SystemAccessor() {

				@Override
				public void saveProperties(String fileName) throws SvFileException {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void loadProperties(String fileName) throws SvFileException {
					// TODO Auto-generated method stub
					
				}

				@Override
				public DialogAnswer dialog(String string) {
					return DialogAnswer.OK;
				}

				@Override
				public void message(String string, ControlObject controls, String messageId) {
					// TODO Auto-generated method stub
					
				}
				
			};
		}
		
	};

	public SvHandlerModel getModel() {
		return model;
	}
	private String createMessage() throws JsonProcessingException {
		WsLoginMessage message = new WsLoginMessage();
		message.application = application;
		message.userid = userid;
		message.device = deviceName;
		message.type = WsLoginMessage.DomainModel;
		String str = new ObjectMapper().writeValueAsString(message);
		return str;
	}
	
	public void changeValue(String id, String value) {
		sendChangeValue(id, value);
	}
	public void changeBlob(String id, Object value, String name) {
		sendChangeValue(id, value, name);
	}
	protected void createThread(ChangesJson changed) {
		new Thread() {
			@Override
			public void run() {
				try {
					handle(changed.getChanges());
				} catch (RequestRejectedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}


}
