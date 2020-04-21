package openti;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.property2.LightProperty;
import jp.silverbullet.core.property2.RuntimeProperty;
import jp.silverbullet.core.property2.SvFileException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.EasyAccessInterface;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.SystemAccessor;
import jp.silverbullet.web.WebSocketClientHandler;
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
	private OkHttpClient client = new OkHttpClient();
	private String host;
	private String port;
	
	public AbstractIndependentMain(String host, String port) {
		this.host = host;
		this.port = port;
		init(model);
		try {
			clienteHandler = new WebSocketClientHandler(host, port) {
				@Override
				protected void onMessageReceived(String message2) {
					Map<String, List<ChangedItemValue>> changed;
					try {
						changed = new ObjectMapper().readValue(message2, Map.class);
						if (isTargetIdChanged(changed)) {
							new Thread() {
								@Override
								public void run() {
									try {
										handle(changed);
									} catch (RequestRejectedException e) {
										e.printStackTrace();
									}
								}
							}.start();
						}
					} catch (JsonParseException e) {
						e.printStackTrace();
					} catch (JsonMappingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}

				@Override
				protected void onRecconected() {
					login(WebSocketClientHandler.DomainModel);
				}
			};
			clienteHandler.login(WebSocketClientHandler.DomainModel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private boolean isTargetIdChanged(Map<String, List<ChangedItemValue>> changed) {
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
	protected void sendChangeValue(String id, int index, String value) {
		OkHttpClient client = new OkHttpClient();
		LightProperty prop = new LightProperty();
		prop.id = id;
		prop.currentValue = value;
		
		try {
			String json = new ObjectMapper().writeValueAsString(prop);
	        String url = getServer() + "/rest/" + getApplication() + "/domain/setValueBySystem?code=forDebug";
			//RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), json);
	        RequestBody body = RequestBody.create(MediaType.get("application/json"), json);
			Request request = new Request.Builder()
				.url(url)
				.post(body)
				.build();
			
            Response response = client.newCall(request).execute();
            response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	protected void sendChangeValue(String id, Object blob, String name) {
		int index = 0;

		try {
			String json = new ObjectMapper().writeValueAsString(blob);
	        String url = getServer() + "/rest/"+ getApplication() + "/domain/postValueBySystem?index=" + index + "&code=forDebug&id=" + id
	        		+ "&name=" + name + "&classname=" + blob.getClass().getName();
			//RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), json);
	        RequestBody body = RequestBody.create(MediaType.get("application/json"), json);
			Request request = new Request.Builder()
				.url(url)
				.post(body)
				.build();
			
            Response response = client.newCall(request).execute();
            response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(blob);
	}
	
	protected abstract String getApplication();
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
        String url = getServer() + "/rest/"+ getApplication() + "/domain/getProperty?index=" + index + "&code=forDebug&id=" + id;
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);
        String result = "";

        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body != null) {
                result = body.string();
                
                LightProperty uiProperty = new ObjectMapper().readValue(result, LightProperty.class);
                return uiProperty;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;	
	}
	
	private SvHandlerModel model = new SvHandlerModel() {
		@Override
		public EasyAccessInterface getEasyAccessInterface() {
			return new EasyAccessInterface() {

				@Override
				public void requestChange(String id, String value) throws RequestRejectedException {
					sendChangeValue(id, 0, value);
				}

				@Override
				public void requestChange(String id, int index, String value) throws RequestRejectedException {
					sendChangeValue(id, index, value);
				}

				@Override
				public void requestChange(String id, Object blobData, String name) throws RequestRejectedException {
					//System.out.println("requestChange(String id, Object blobData, String name)");
					sendChangeValue(id, blobData, name);
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
				public void message(String string) {
					// TODO Auto-generated method stub
					
				}
				
			};
		}
		
	};

	public SvHandlerModel getModel() {
		return model;
	}
	
}
