package openti;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.google.api.services.drive.model.File;

public abstract class MainUI extends JFrame implements IMainUI{

	private DefaultListModel<String> model;

	public MainUI() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(400, 300));
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				MainUI.this.onWindowClosed();
			}
		});
		
		JPanel fileFrame = new JPanel();
		this.add(fileFrame);
		fileFrame.setLayout(new FlowLayout());
		fileFrame.setBorder(new TitledBorder("File"));
		model = new DefaultListModel<>();
		JList fileList = new JList(model);
		fileFrame.add(fileList);
		JButton buttonDownload = new JButton("Download");
		fileFrame.add(buttonDownload);
		buttonDownload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				downloadPendingFiles();
				updateList();
			}
		});
		
		for (File file : getPendingFileList()) {
			model.addElement(file.getName());
		}
	}

	protected void updateList() {
		model.clear();
		for (File file : getPendingFileList()) {
			model.addElement(file.getName());
		}
	}

	protected abstract void downloadPendingFiles();

	protected abstract void onWindowClosed();
	protected abstract List<File> getPendingFileList();
	
	public void setDeviceName(String deviceName) {
		this.setTitle(deviceName);
	}

	
	public void onPendingFilesUpdated(List<File> files) {
		model.clear();
		for (File m : files) {
			model.addElement(m.getName());
		}
	}
}
