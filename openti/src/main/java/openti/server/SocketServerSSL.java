package openti.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import openti.ID;
import openti.ValueChangeListener;

public class SocketServerSSL {

	public static void main(String[] arg) {
		new SocketServerSSL();
	}

	private StandaloneOtdrModel otdrModel;
	
	public SocketServerSSL() {
		init();
		
		SSLServerSocket sSocket = null;
		SSLSocket socket = null;
		PrintWriter writer = null;
		BufferedReader reader = null;
		
		SyncObject syncObject = new SyncObject();
		
		try{
			SSLServerSocketFactory sslServerSocketFactory =
					(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			sSocket = (SSLServerSocket) sslServerSocketFactory.
                        createServerSocket(8083);
			
			socket = (SSLSocket) sSocket.accept();
		
			System.out.println("Waiting for client");

			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			writer = new PrintWriter(socket.getOutputStream(), true);

			writer.println("Connected");
			String line = null;
			int num;
	        while (true) {
	        	line = reader.readLine();
	        	
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
	        			syncObject.wait();
	        		}
	        		writer.println("1");
	        	}

	        }			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (reader!=null){
					reader.close();
				}
				if (writer!=null){
					writer.close();
				}
				if (socket!=null){
					socket.close();
				}
				if (sSocket!=null){
					sSocket.close();
				}
	            System.out.println("サーバー側終了です");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void init() {
		otdrModel = new StandaloneOtdrModel("ti_back.zip") {

			@Override
			protected void onChanged(String id, String value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			protected void onBlobChanged(String id, Object value, String name) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
	class SyncObject {
		private Map<String, String> map = new HashMap<>();
		public SyncObject() {
			otdrModel.addValueChangeListener(new ValueChangeListener() {
				@Override
				public void onUpdate(String message) {
					Set<String> remove = new HashSet<>();
					for (String id : map.keySet()) {
						if (otdrModel.getValue(id).equals(map.get(id))) {
							remove.add(id);							
						}
					}
					if (remove.size() > 0) {
						synchronized(SyncObject.this) {
							SyncObject.this.notify();
						}	
					}
					for (String id : remove) {
						map.remove(id);
					}
				}
			});
		}
		public void register(String id, String value) {
			map.put(id, value);
		}
		
	}
}
