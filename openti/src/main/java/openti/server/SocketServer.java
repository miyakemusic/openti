package openti.server;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.swing.SwingGui;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import openti.AbstractIndependentMain;

public class SocketServer {
	public static void main(String[] arg) {
		new SocketServer(arg[0], arg[1], arg[2], arg[3]);
	}

	private StandaloneOtdrModel otdrModel;
	private String filename;
	private String uri;
	private AbstractIndependentMain webServerHandler = new NullAbstractIndependentMain("localhost", "8080", filename, filename, filename, false);
	private String deviceName;
	
	public SocketServer(String port, String gui, String filename, String deviceName) {
		String title = gui + "(" + port + ")";
		init(gui, title, filename, deviceName);
		
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

	private void init(String gui, String title, String uri, String deviceName) {
		this.filename = uri.split("/")[uri.split("/").length-1];//new File(filename).getName();
		this.uri = uri;
		this.deviceName = deviceName;
		
		otdrModel = new StandaloneOtdrModel(filename) {
			@Override
			protected void onChanged(String id, String value) {
				webServerHandler.changeValue(id, value);
			}

			@Override
			protected void onBlobChanged(String id, Object value, String name) {
				webServerHandler.changeBlob(id, value, name);
			}
		};
		Image bgImage =  Toolkit.getDefaultToolkit().createImage("C:\\Users\\miyak\\Desktop\\capture.PNG");
		
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
								goOnline(onlineButton.isSelected());
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
	

	private void goOnline(boolean b) {
		if (b) {
	        try {
				requestFile();
				
				String[] tmp = uri.split("[/:]+");
				String host = tmp[1];
				String port = tmp[2];
				String project = "Default00";
				String username = "silverbullet";
				String deviceName = this.deviceName;
				boolean headless = true;
				webServerHandler = new AbstractIndependentMain(host, port, project, username, deviceName, headless) {
	
					@Override
					protected void handle(Map<String, List<ChangedItemValue>> changed) throws RequestRejectedException {
						otdrModel.handle(changed);
					}
	
					@Override
					protected List<String> getTargetIds() {
						return otdrModel.getTargetIds();
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			webServerHandler = new NullAbstractIndependentMain("localhost", "8080", filename, filename, filename, false);
		}
	}
}
