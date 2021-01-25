package openti.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.dev.MessageObject;
import openti.ID;

abstract class ClientServer {

	public ClientServer(Socket socket) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			onRead(reader.readLine());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	abstract protected void onRead(String readLine);
	
}
public abstract class SocketHandler {

	private StandaloneTesterModel testerModel;
//	private ServerSocket sSocket;
	private ClientServer clientServer;
//	SyncObject syncObject = new SyncObject(this.testerModel);
//	private Socket client;
	PrintWriter writer = null;
	BufferedReader reader = null;
	
	public SocketHandler(Socket socket, StandaloneDomainModel otdrModel) {
//		try {
//			sSocket = new ServerSocket(8089);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		new Thread() {
//			
//
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println("Waiting for client");
//					try {
//						Socket socket = sSocket.accept();
//						clientServer = new ClientServer(socket) {
//
//							@Override
//							protected void onRead(String readLine) {
//								synchronized (syncObject) {
//									syncObject.notify();
//								}
//							}
//							
//						};
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}		
//				}
//			}
//			
//		}.start();

		new Thread() {
			@Override
			public void run() {
				handle(socket, otdrModel);	
			}	
		}.start();
		
	}

	private void handle(Socket socket, StandaloneDomainModel otdrModel) {
	
		
		this.testerModel = otdrModel;	
		
//		try {
//			client = new Socket(socket.getInetAddress(), 8089);
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
	//		syncObject.terminate();
		}
		writer.println("Connected");
		//String line = null;

        while (true) {
        	try {
				String message = reader.readLine();
				SocketMessage socketMessage = new ObjectMapper().readValue(message, SocketMessage.class);
	    		
	    		if (socketMessage.type.equals(SocketMessage.Type.Command)) {
	    			String[] tmp = socketMessage.body.split("=");
	        		String value = otdrModel.getValue(tmp[0]);
	        		otdrModel.requestChange(tmp[0], tmp[1]);
	        		//writer.println(value);	
	    		}
	    		else if (socketMessage.type.equals(SocketMessage.Type.Query)) {
	    			String[] tmp = socketMessage.body.split("=");
	    			String value = otdrModel.getPropertyStore().get(socketMessage.body).getCurrentValue();
	    			writer.println(value);
	    		}
	    		else if (socketMessage.type.equals(SocketMessage.Type.Message)) {
	    			onMessage(new ObjectMapper().readValue(socketMessage.body, MessageObject.class));
	    		}
	    		else if (socketMessage.type.equals(SocketMessage.Type.MessageClose)) {
	    			onCloseMessage();
	    		}
			} catch (IOException e) {
				e.printStackTrace();
				try {
					socket.close();
					break;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        }
	}

	abstract protected void onMessage(MessageObject readValue);
	abstract protected void onCloseMessage();

	public void replyMessage(String id, String string) {
		writer.println(id);
	}
}
