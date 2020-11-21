package openti.server;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.core.sequncer.UserSequencer;
import jp.silverbullet.swing.SwingGui;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import openti.AbstractIndependentMain;
import openti.OltsSequencer;
import openti.OscilloTestSequencer;
import openti.TestSequencer;
import openti.VipSequencer;

public class SocketServer {
	private StandaloneDomainModel otdrModel;
	private String filename;
	private String uri;
	private AbstractIndependentMain webServerHandler = new NullAbstractIndependentMain("localhost", "8080", filename, filename, filename, false);
	private String deviceName;
	private String application;
	
	public SocketServer(String port, String gui, String filename, String deviceName, List<UserSequencer> sequencers) {
		String title = gui + "(" + port + ")";
		init(gui, title, filename, deviceName, sequencers);
		
		ServerSocket sSocket = null;
		
		try{
			sSocket = new ServerSocket(Integer.valueOf(port));
			
			while(true) {
				System.out.println("Waiting for client");
				Socket socket = sSocket.accept();
				new ClientHandler(socket, otdrModel);
			
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

	private void init(String gui, String title, String uri, String deviceName, List<UserSequencer> sequencers) {
		this.filename = uri.split("/")[uri.split("/").length-1];//new File(filename).getName();
		this.uri = uri;
		this.deviceName = deviceName;
		this.application = extractApplication(uri);
		if (!Files.exists(Paths.get(filename))) {
			try {
				this.requestFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		otdrModel = new StandaloneDomainModel(filename, sequencers) {
			@Override
			protected void onChanged(String id, String value) {
				webServerHandler.changeValue(id, value);
			}

			@Override
			protected void onBlobChanged(String id, Object value, String name) {
				webServerHandler.changeBlob(id, value, name);
			}
		};
		//Image bgImage =  Toolkit.getDefaultToolkit().createImage(this.getClass().getClassLoader().getResource("capture.PNG").toExternalForm());
		Image bgImage = null;
		try {
			bgImage = ImageIO.read(getClass().getClassLoader().getResource("openti/server/capture.PNG"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SwingGui swingGui = new SwingGui(otdrModel.getUiBuilder(), otdrModel.getPropertyStore(), 
				otdrModel.getBlobStore(), otdrModel.getSequencer(), gui, title, bgImage) {

					protected void onReload() {
						try {
							requestFile();
							otdrModel.reload();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}

					@Override
					protected void initToolbar(JPanel toolBar) {
						JToggleButton onlineButton = new JToggleButton("Online");
						toolBar.add(onlineButton);
						onlineButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								try {
									goOnline(onlineButton.isSelected());
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
				
			String[] tmp = uri.split("[/:]+");
			String host = tmp[1];
			String port = tmp[2];
			String userid = "Default00";
			String application = this.application;
			String deviceName = this.deviceName;
			boolean headless = true;
			webServerHandler = new AbstractIndependentMain(host, port, userid, application, deviceName, headless) {
	
				@Override
				protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
					otdrModel.handle(changed);
				}
	
				@Override
				protected boolean isTargetIdChanged(Map<String, List<ChangedItemValue>> changed) {
					return true;
				}
				@Override
				protected List<String> getTargetIds() {
//						List<String> all = new ArrayList<>();
//						
//						for (Field f : Id.class.getFields()) {
//							all.add(f.getName());
//						}
//						return all;//otdrModel.getTargetIds();
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
					
			};
		}
		else {
			webServerHandler.logout();
			webServerHandler = new NullAbstractIndependentMain("localhost", "8080", filename, filename, filename, false);
		}
	}
}
