package openti.server;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SocketClient extends JFrame {

	public static void main(String[] args) {
		new SocketClient().setVisible(true);
	}

	private Socket cSocket;
	private PrintWriter writer;
	private BufferedReader reader;
	private JTextArea textArea;
	private JTextField host;

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
				retreiveTrace();
			}
		});		
		
		JButton allButton = new JButton("Start&Trace");
		panel.add(allButton);
		allButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startAndTrace();
			}
		});		
		textArea = new JTextArea();
		this.add(textArea, BorderLayout.CENTER);
		
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
		
		retreiveTrace();
	}

	protected void retreiveTrace() {
		writer.println("TRACE?");
		try {
			String reply = reader.readLine();
			textArea.setText(reply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void startTest() {
		writer.println("START");
	}

	protected void connect() throws UnknownHostException, IOException {
		if (cSocket != null) {
			cSocket.close();
		}
		
		cSocket = new Socket(host.getText(), 8083);

		writer = new PrintWriter(cSocket.getOutputStream(), true);
		reader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
		this.textArea.setText(reader.readLine());
	}
}
