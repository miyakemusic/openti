package openti.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import jp.silverbullet.dev.ControlObject;
import jp.silverbullet.dev.MessageObject;
import jp.silverbullet.dev.ScriptManager;
import jp.silverbullet.swing.SwingGui;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import openti.AbstractIndependentMain;

public class SocketServer {
	public static final String FromServer = "FromServer";
	private StandaloneDomainModel domainModel;
	private String filename;
	private String uri;
	private AbstractIndependentMain webServerHandler = new NullAbstractIndependentMain("localhost", "8080", filename, filename, filename, filename, false);
	private String deviceName;
	private String application;
	private SwingGui swingGui;
	private String host;
	private String port;
	private String userid;
	private String password;
	
	private DeviceScriptManager scriptManager = new DeviceScriptManager();
	
	public SocketServer(String configFile,List<UserSequencer> sequencers) {
		Map<String, String> config = parseConfig(configFile);
		
		constructor(config.get("PORT"), config.get("ENTRY"), config.get("URI"), 
				config.get("NAME"), sequencers, config.get("IMAGE"),
				Integer.valueOf(config.get("TOPMARGIN")), 
				Integer.valueOf(config.get("LEFTMARGIN")),
				Integer.valueOf(config.get("WIDTH")),
				Integer.valueOf(config.get("HEIGHT")));
	}
	
	private Map<String, String> parseConfig(String configFile) {
		try {
			Map<String, String> ret = new HashMap<>();
			List<String> lines = Files.readAllLines(Paths.get(configFile));
			for (String line : lines) {
				if (line.isEmpty()) {
					continue;
				}
				String[] tmp = line.split("=");
				ret.put(tmp[0], tmp[1]);
			}
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void constructor(String port, String gui, String filename, 
			String deviceName, List<UserSequencer> sequencers, 
			String imagePath, int topMargin, int leftMargin, int width, int height) {
		String title = gui + "(" + port + ")";
		init(gui, title, filename, deviceName, sequencers, imagePath,
				topMargin, leftMargin, width, height);
		
		ServerSocket sSocket = null;
		
		try{
			sSocket = new ServerSocket(Integer.valueOf(port));
			
			while(true) {
				System.out.println("Waiting for client");
				Socket socket = sSocket.accept();
				new ClientHandler(socket, domainModel);
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (sSocket!=null){
					sSocket.close();
				}
	            System.out.println("Server stop");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void init(String gui, String title, String uri, String deviceName, 
			List<UserSequencer> sequencers, String imagePath, 
			int topMargin, int leftMaring, int width, int height) {
		this.filename = uri.split("/")[uri.split("/").length-1];//new File(filename).getName();
		this.uri = uri;
		
		String[] tmp = this.uri.split("[/:]+");
		this.host = tmp[1];
		this.port = tmp[2];
		this.userid = "Default00";
		this.password = "password";
		this.deviceName = deviceName;
		this.application = extractApplication(uri);
		if (!Files.exists(Paths.get(filename))) {
			try {
				this.requestFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		domainModel = new StandaloneDomainModel(filename, sequencers) {
			@Override
			protected void onChanged(String id, String value) {
				webServerHandler.changeValue(id, value);
			}

			@Override
			protected void onBlobChanged(String id, Object value, String name) {
				webServerHandler.changeBlob(id, value, name);
			}
		};

		BufferedImage  bgImage = null;
		try {
			bgImage = ImageIO.read(new File(imagePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		swingGui = new SwingGui(domainModel.getUiBuilder(), domainModel.getPropertyStore(), 
				domainModel.getBlobStore(), domainModel.getSequencer(), 
				gui, title, bgImage, topMargin, leftMaring, width, height) {

					protected void onReload() {
						try {
							requestFile();
							domainModel.reload();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}

					@Override
					protected void initToolbar(JPanel toolBar) {
						JComboBox<String> automatorList = new JComboBox<>();
						JToggleButton onlineButton = new JToggleButton("Online");
						toolBar.add(onlineButton);
						onlineButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								try {
									goOnline(onlineButton.isSelected());
									webServerHandler.getAutoScripts().forEach(item -> automatorList.addItem(item));
								} catch (IOException e) {
									e.printStackTrace();
								}
							}

						});					
						
						JButton reloadButton = new JButton("Reload");
						toolBar.add(reloadButton);
						reloadButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								onReload();
								updateGUI();
							}
						});
						
						//JPanel autoPanel = new JPanel();
						//autoPanel.setBorder(new TitledBorder("Automator"));
						//toolBar.add(autoPanel);
						
						JButton runAutomator = new JButton("Run");
						toolBar.add(automatorList);
						toolBar.add(runAutomator);
						runAutomator.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								//retreiveScript(automatorList.getSelectedItem().toString());
								runLocalScript();
							}
						});
					}

					@Override
					protected void replyMessage(String id, String string) {
						scriptManager.replyMessage(id, string);
					}
			
		};
		swingGui.setVisible(true);		
	}

	private String extractApplication(String uri2) {
		String[] tmp = uri2.split("[/.]+");
		return tmp[tmp.length-2];
	}

	private void requestFile() throws IOException {
		OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(uri)
                .get()
                .build();
		Response responseOk = client.newCall(request).execute();
		byte[] data = responseOk.body().bytes();
		Files.write(Paths.get(filename), data);
		System.out.println("File downloaded");

	}
	

	private void goOnline(boolean b) throws IOException {
		if (b) {
			requestFile();
			
			boolean headless = true;
			webServerHandler = new AbstractIndependentMain(this.host, this.port, userid, password, this.application, this.deviceName, headless) {
	
				@Override
				protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
					domainModel.handle(changed);
				}
	
				@Override
				protected boolean isTargetIdChanged(Map<String, List<ChangedItemValue>> changed) {
					return true;
				}
				@Override
				protected List<String> getTargetIds() {
					return null;//
				}

				@Override
				protected RegisterAccessor getRegisterAccessor() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				protected void init(SvHandlerModel model) {
					
				}

				@Override
				protected void onMessage(MessageObject message2) {
					swingGui.showMessage(message2);
				}
			};
			
		}
		else {
			webServerHandler.logout();
			webServerHandler = new NullAbstractIndependentMain("localhost", "8080", filename, filename, filename, filename, false);
		}
	}
	
	private void runLocalScript() {
		try {
			List<String> srcipt = Files.readAllLines(Paths.get("tmp.js"));
			runScript(srcipt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void retreiveScript(String name) {
		List<String> srcipt = webServerHandler.retreiveScript(name);
		runScript(srcipt);
	}

	private void runScript(List<String> srcipt) {
		new Thread() {
			@Override
			public void run() {
				scriptManager.start(srcipt);
			}	
		}.start();
		
	}
	
	class DeviceScriptManager extends ScriptManager {
		private Object sync = new Object();
		private String replyId = "";
		private String replyMessage = "";
		
		@Override
		public void write(String addr, String command) {
			System.out.println("write:" + addr + ":" + command);
			if (addr.equals(SocketServer.this.deviceName)) {
				String[] tmp = command.split("=");
				
				try {
					domainModel.getSequencer().requestChange(tmp[0], tmp[1]);
				} catch (RequestRejectedException e) {
					e.printStackTrace();
				}
			}
		}

		public void replyMessage(String id, String string) {
			this.replyId = id;
			this.replyMessage = string;
			synchronized(sync) {
				sync.notify();
			}
		}

		@Override
		public String read(String addr, String query) {
			System.out.println("read:" + addr + ":" + query);
			if (addr.equals(SocketServer.this.deviceName)) {
				//String[] tmp = command.split("=");
				return domainModel.getPropertyStore().get(query).getCurrentValue();
			}
			return null;
		}

//		@Override
//		public String waitEqual(String addr, String id, String value) {
//			System.out.println("waitEqual" + addr + ":" + value);
//			if (addr.equals(SocketServer.this.deviceName)) {
//				synchronized(sync) {
//					try {
//						sync.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			return null;
//		}

		@Override
		public void debug(String arg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String message(String addr, String message, String controls) {
			System.out.println("message" + addr + ":" + controls);
			if (addr.equals(SocketServer.this.deviceName)) {
				try {
					ControlObject controlObject = new ObjectMapper().readValue(controls, ControlObject.class);
					swingGui.showMessage(new MessageObject(message, controlObject, ""));
					waitForUserAction();
					return replyId;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return "";
		}

		private void waitForUserAction() {
			synchronized(sync) {
				try {
					sync.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	};
}
