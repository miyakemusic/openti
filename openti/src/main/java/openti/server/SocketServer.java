package openti.server;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jp.silverbullet.core.dependency2.ChangedItemValue;
import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.sequncer.SvHandlerModel;
import jp.silverbullet.swing.SwingGui;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import openti.AbstractIndependentMain;
import openti.ID;
import openti.Utils;

public class SocketServer {
	public static void main(String[] arg) {
		new SocketServer(arg[0], arg[1], arg[2]);
	}

	private StandaloneOtdrModel otdrModel;
	private String filename;
	private String uri;
	
	public SocketServer(String port, String gui, String filename) {
		String title = gui + "(" + port + ")";
		init(gui, title, filename);
		
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
	            System.out.println("サーバー側終了です");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void init(String gui, String title, String uri) {
		this.filename = uri.split("/")[uri.split("/").length-1];//new File(filename).getName();
		this.uri = uri;
		
        requestFile();
  
		otdrModel = new StandaloneOtdrModel(filename);
		Image bgImage =  Toolkit.getDefaultToolkit().createImage("C:\\Users\\miyak\\Desktop\\capture.PNG");
		
		new SwingGui(otdrModel.getUiBuilder(), otdrModel.getPropertyStore(), 
				otdrModel.getBlobStore(), otdrModel.getSequencer(), gui, title, bgImage) {

					@Override
					protected void onReload() {
						requestFile();
						otdrModel.reload();
					}
			
		}.setVisible(true);
		
		String host = "localhost";
		String port = "8080";
		String project = "Default00";
		String username = "silverbullet";
		String deviceName = "OTDR1";
		boolean headless = true;
		new AbstractIndependentMain(host, port, project, username, deviceName, headless) {

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
				// TODO Auto-generated method stub
				
			}
			
		};
		
	}

	private void requestFile() {
		try {
    		OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(uri)
                    .get()
                    .build();
			Response responseOk = client.newCall(request).execute();
			byte[] data = responseOk.body().bytes();
			Files.write(Paths.get(filename), data);
			System.out.println("File downloaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
