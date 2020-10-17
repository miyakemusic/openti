package openti;

import java.util.List;

import com.google.api.services.drive.model.File;

public interface IMainUI {

	void setDeviceName(String deviceName);

	void setVisible(boolean b);

	void onPendingFilesUpdated(List<File> list);

}
