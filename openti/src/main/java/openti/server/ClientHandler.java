package openti.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.dev.MessageObject;
import openti.ID;

public abstract class ClientHandler {

	private StandaloneTesterModel testerModel;

	public ClientHandler(Socket socket, StandaloneDomainModel otdrModel) {
		new Thread() {
			@Override
			public void run() {
				handle(socket, otdrModel);	
			}	
		}.start();
		
	}

	private void handle(Socket socket, StandaloneDomainModel otdrModel) {
		PrintWriter writer = null;
		BufferedReader reader = null;
		
		this.testerModel = otdrModel;
		SyncObject syncObject = new SyncObject(this.testerModel);
		
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
			syncObject.terminate();
		}
		writer.println("Connected");
		//String line = null;

        while (true) {
        	try {
				String message = reader.readLine();
				SocketMessage socketMessage = new ObjectMapper().readValue(message, SocketMessage.class);
	    		
	    		if (socketMessage.type.equals(SocketMessage.Type.Command)) {
	    			String[] tmp = socketMessage.body.split("=");
	        		String value = otdrModel.getValue(socketMessage.body.replace("?", ""));
	        		writer.println(value);	
	    		}
	    		else if (socketMessage.type.equals(SocketMessage.Type.Query)) {
	    			String[] tmp = socketMessage.body.split("=");
	    			otdrModel.requestChange(tmp[0], tmp[1]);
	    		}
	    		else if (socketMessage.type.equals(SocketMessage.Type.Message)) {
	    			onMessage(new ObjectMapper().readValue(socketMessage.body, MessageObject.class));
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
    

    		
//        	if (line.equalsIgnoreCase("START")) {
//        		syncObject.register(ID.ID_OTDR_TESTCONTROL, ID.ID_OTDR_TESTCONTROL_STOP);
//        		otdrModel.requestChange(ID.ID_OTDR_TESTCONTROL, ID.ID_OTDR_TESTCONTROL_START);
//        	}
//        	else if (line.equalsIgnoreCase("STOP")) {
//        		otdrModel.requestChange(ID.ID_OTDR_TESTCONTROL, ID.ID_OTDR_TESTCONTROL_STOP);
//        	}
//        	else if (line.equalsIgnoreCase("TRACE?")) {
//        		String value = otdrModel.getValue(ID.ID_TRACE);
//        		writer.println(value);
//        	}
//        	else if (line.equalsIgnoreCase("*OPC?")) {
//        		synchronized(syncObject) {
//        			try {
//						syncObject.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//        		}
//        		writer.println("1");
//        	}
//        	else {
//        		String[] tmp = line.split("=");
//        		if (line.endsWith("?")) {
//            		String value = otdrModel.getValue(line.replace("?", ""));
//            		writer.println(value);	
//        		}
//        		else {
//        			otdrModel.requestChange(tmp[0], tmp[1]);
//        		}
//        	}
        }
	}

	abstract protected void onMessage(MessageObject readValue);
}
