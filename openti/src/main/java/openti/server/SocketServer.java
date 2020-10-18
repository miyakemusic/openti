package openti.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import jp.silverbullet.swing.SwingGui;

public class SocketServer {
	public static void main(String[] arg) {
		new SocketServer(arg[0], arg[1]);
	}

	private StandaloneOtdrModel otdrModel;
	
	public SocketServer(String port, String gui) {
		String title = gui + "(" + port + ")";
		init(gui, title);
		
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

	private void init(String gui, String title) {
		otdrModel = new StandaloneOtdrModel("miyake_otdr.zip");
		new SwingGui(otdrModel.getUiBuilder(), otdrModel.getPropertyStore(), 
				otdrModel.getBlobStore(), otdrModel.getSequencer(), gui, title).setVisible(true);
	}
	

}
