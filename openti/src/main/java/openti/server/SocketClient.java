package openti.server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.silverbullet.dev.ControlObject;
import jp.silverbullet.dev.MessageObject;
import jp.silverbullet.dev.ScriptManager;


public class SocketClient extends JFrame {

	public static void main(String[] args) {
		new SocketClient().setVisible(true);
	}

	private Socket cSocket;
	private PrintWriter writer;
	private BufferedReader reader;
	private JTextArea resultArea;
	private JTextField host;
	private JTextField port;
	private JTextArea scriptArea;

	public SocketClient() {
		setSize(800, 600);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
			
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		this.add(panel, BorderLayout.NORTH);
		
		JButton connectButton = new JButton("Connect");
		panel.add(connectButton);
		connectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					connect();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		host = new JTextField("192.168.10.3");
		panel.add(host);
		
		port = new JTextField("8083");
		panel.add(port);
		
		JTextField command = new JTextField("");
		panel.add(command);
		command.setPreferredSize(new Dimension(100, 24));

		
		JButton traceButton = new JButton("Start");
		panel.add(traceButton);
		traceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					@Override
					public void run() {
						try {
							startScript(Arrays.asList(scriptArea.getText().split("\n")));
						} catch (ScriptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}.start();
			}
		});		

		
		resultArea = new JTextArea();
		resultArea.setPreferredSize(new Dimension(100, 50));
		this.add(new JScrollPane(resultArea), BorderLayout.SOUTH);
		
		
		scriptArea = new JTextArea();
		this.add(new JScrollPane(scriptArea), BorderLayout.CENTER);
		
		try {
			List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\miyak\\OneDrive\\デスクトップ\\script.txt"));
			StringBuffer buf = new StringBuffer();
			lines.forEach(line -> buf.append(line + "\n"));
			scriptArea.setText(buf.toString());
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

//	protected void startAndTrace() {
//		writer.println("START");
//		writer.println("*OPC?");
//		try {
//			String reply = reader.readLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}


//	protected void startTest() {
//		try {
//			List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\miyak\\git\\openti\\openti\\target\\script.txt"));
//			for (String line : lines) {
//				String[] tmp = line.split(";");
//				String addr = tmp[0];
//				String command = tmp[1];
//				
//				PrintWriter writer = getWriter(addr);
//				BufferedReader reader = getReader(addr);
//				
//				resultArea.setText(resultArea.getText() + "\n" + line);
//				writer.println(command);
//				if (command.endsWith("?")) {
//					String reply = reader.readLine();
//					resultArea.setText(resultArea.getText() + " --> " + reply);
//				}
//				Thread.sleep(1000);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	class SocketObj {
		public SocketObj(String host, int port) {
			try {
				socket = new Socket(host, port);
				writer = new PrintWriter(socket.getOutputStream(), true);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private Socket socket;
		PrintWriter writer;
		BufferedReader reader;
	}
	Map<String, SocketObj> sockets = new HashMap<>();
	
	private BufferedReader getReader(String addr) {
		if (!sockets.containsKey(addr)) {
			String[] tmp = addr.split(":");
			String host = tmp[0];
			int port = Integer.valueOf(tmp[1]);
			sockets.put(addr, new SocketObj(host, port));
		}
		return sockets.get(addr).reader;
	}

	private PrintWriter getWriter(String addr) {
		System.out.println(addr);
		if (addr == null) {
			System.out.println();
		}
		if (!sockets.containsKey(addr)) {
			String[] tmp = addr.split(":");
			String host = tmp[0];
			int port = Integer.valueOf(tmp[1]);
			sockets.put(addr, new SocketObj(host, port));
		}
		return sockets.get(addr).writer;
	}

	protected void connect() throws UnknownHostException, IOException {
		if (cSocket != null) {
			cSocket.close();
		}
		
		cSocket = new Socket(host.getText(), Integer.valueOf(port.getText()));

		writer = new PrintWriter(cSocket.getOutputStream(), true);
		reader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));

		this.resultArea.setText(reader.readLine());
	}
	

	protected void startScript(List<String> script) throws ScriptException {
		Map<String, String> hostMap = new HashMap<>();
		for(String s : script) {
			if (s.startsWith("var")) {
				String[] tmp = s.split("[\s]+");
				if (Character.isUpperCase(tmp[1].toCharArray()[0])) {
					hostMap.put(tmp[1], "localhost:8085");
				}
			}
		}
		hostMap.put("MT1041A", "localhost:8085");
		hostMap.put("G0400A", "localhost:8086");
		
		this.resultArea.setText("");
		
		Object sync = new Object();
		new ScriptManager() {

			@Override
			public void write(String addr, String command) {
				addr = hostMap.get(addr);
				print("write " + addr + ":" + command + "\n");
				getWriter(addr).println(createSocketMessage(SocketMessage.Type.Command, command));
			}

			@Override
			public String read(String addr, String query) {
				addr = hostMap.get(addr);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				print("read " + addr + ":" + query);
				getWriter(addr).println(createSocketMessage(SocketMessage.Type.Query, query));
				try {
					String reply = getReader(addr).readLine();
					print(" -> " + reply + "\n");
					return reply;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "";
			}

			@Override
			public String waitEqual(String addr, String id, String value) {
				//addr = hostMap.get(addr);
				print("waitEqual" + addr);
				while (true) {
					if (read(addr, id).equals(value)) {
						break;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return "";
			}

			@Override
			public void debug(String arg) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public String message(String addr, String message, String controls) {
				print(addr + ":" + message + ":" + controls);
				try {
					addr = hostMap.get(addr);
					MessageObject obj = new MessageObject(message, new ObjectMapper().readValue(controls, ControlObject.class), "");
					
					getWriter(addr).println(createSocketMessage(SocketMessage.Type.Message, obj.toString()));
//					synchronized(sync) {
//						try {
//							sync.wait();
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
					String reply = getReader(addr).readLine();
					getWriter(addr).println(createSocketMessage(SocketMessage.Type.MessageClose, ""));
					return reply;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "";
			}

			@Override
			public boolean requires(String portid, String testMethod) {
				return true;
			}

			
		}.start(script);
	}

	protected void print(String arg) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				resultArea.setText(resultArea.getText() + arg);
			}
		});
	}

	private String createSocketMessage(SocketMessage.Type type, String command) {
		try {
			return new ObjectMapper().writeValueAsString(new SocketMessage(type, command));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
