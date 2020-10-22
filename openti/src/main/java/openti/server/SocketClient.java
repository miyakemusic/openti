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

import openti.ScriptManager;


public class SocketClient extends JFrame {

	public static void main(String[] args) {
		new SocketClient().setVisible(true);
	}

	private Socket cSocket;
	private PrintWriter writer;
	private BufferedReader reader;
	private JTextArea textArea;
	private JTextField host;
	private JTextField port;

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
		JButton send = new JButton("Send");
		panel.add(send);
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				writer.println(command.getText());
			}
		});
		
		JButton startButton = new JButton("Start");
		panel.add(startButton);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startTest();
			}
		});			
		
		JButton traceButton = new JButton("Trace");
		panel.add(traceButton);
		traceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					@Override
					public void run() {
						try {
							retreiveTrace();
						} catch (ScriptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}.start();
			}
		});		
//		
//		JButton allButton = new JButton("Start&Trace");
//		panel.add(allButton);
//		allButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				startAndTrace();
//			}
//		});		
		textArea = new JTextArea();
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
		
	}

	protected void startAndTrace() {
		writer.println("START");
		writer.println("*OPC?");
		try {
			String reply = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	protected void startTest() {
		try {
			List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\miyak\\git\\openti\\openti\\target\\script.txt"));
			for (String line : lines) {
				String[] tmp = line.split(";");
				String addr = tmp[0];
				String command = tmp[1];
				
				PrintWriter writer = getWriter(addr);
				BufferedReader reader = getReader(addr);
				
				textArea.setText(textArea.getText() + "\n" + line);
				writer.println(command);
				if (command.endsWith("?")) {
					String reply = reader.readLine();
					textArea.setText(textArea.getText() + " --> " + reply);
				}
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

		this.textArea.setText(reader.readLine());
	}
	

	protected void retreiveTrace() throws ScriptException {
		this.textArea.setText("");
		new ScriptManager() {

			@Override
			public void write(String addr, String command) {
				print(addr + ":" + command + "\n");
				getWriter(addr).println(command);
			}

			@Override
			public String read(String addr, String query) {
				query = query + "?";
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				print(addr + ":" + query);
				getWriter(addr).println(query);
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
			public void log(String arg) {
				print(arg);
				
			}

			@Override
			public void message(String message) {
		    	JOptionPane.showMessageDialog(SocketClient.this, message);
		    }
			
		}.test2();
	}

	protected void print(String arg) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				textArea.setText(textArea.getText() + arg);
			}
		});
	}
}
