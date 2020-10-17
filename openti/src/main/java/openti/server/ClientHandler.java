package openti.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import openti.ID;

public class ClientHandler {

	private StandaloneTesterModel testerModel;

	public ClientHandler(Socket socket, StandaloneOtdrModel otdrModel) {
		new Thread() {
			@Override
			public void run() {
				handle(socket, otdrModel);	
			}	
		}.start();
		
	}

	private void handle(Socket socket, StandaloneOtdrModel otdrModel) {
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
		String line = null;

        while (true) {
        	try {
				line = reader.readLine();
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
        	
        	if (line.equalsIgnoreCase("START")) {
        		syncObject.register(ID.ID_OTDR_TESTCONTROL, ID.ID_OTDR_TESTCONTROL_STOP);
        		otdrModel.requestChange(ID.ID_OTDR_TESTCONTROL, ID.ID_OTDR_TESTCONTROL_START);
        	}
        	else if (line.equalsIgnoreCase("STOP")) {
        		otdrModel.requestChange(ID.ID_OTDR_TESTCONTROL, ID.ID_OTDR_TESTCONTROL_STOP);
        	}
        	else if (line.equalsIgnoreCase("TRACE?")) {
        		String value = otdrModel.getValue(ID.ID_TRACE);
        		writer.println(value);
        	}
        	else if (line.equalsIgnoreCase("*OPC?")) {
        		synchronized(syncObject) {
        			try {
						syncObject.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
        		}
        		writer.println("1");
        	}
        }
	}
}
