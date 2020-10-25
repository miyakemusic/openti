package openti.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import jp.silverbullet.swing.SwingGui;

public class SocketServer {
	public static void main(String[] arg) {
		new SocketServer(arg[0], arg[1], arg[2]);
	}

	private StandaloneOtdrModel otdrModel;
	
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

	private void init(String gui, String title, String filename) {
		otdrModel = new StandaloneOtdrModel(filename);
		new SwingGui(otdrModel.getUiBuilder(), otdrModel.getPropertyStore(), 
				otdrModel.getBlobStore(), otdrModel.getSequencer(), gui, title) {

					@Override
					protected void onReload() {
						otdrModel.reload();
					}
			
		}.setVisible(true);
	}
	

}
