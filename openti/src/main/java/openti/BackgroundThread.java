package openti;

import jp.silverbullet.core.dependency2.RequestRejectedException;
import jp.silverbullet.dev.BuilderModelImpl;
import openti.SilverbulletUserEasyAccess.EnumApplication;
import openti.SilverbulletUserEasyAccess.EnumCollecmode;
import openti.SilverbulletUserEasyAccess.EnumError;
import openti.SilverbulletUserEasyAccess.EnumOtdrTestcontrol;
import openti.SilverbulletUserRegister.ERROR_STATUS;
import openti.SilverbulletUserRegister.HARDKEY;

public class BackgroundThread extends Thread {

	private BuilderModelImpl model;

	public BackgroundThread(BuilderModelImpl model) {
		this.model = model;
	}

	@Override
	public void run() {
		SilverbulletUserRegister register = new SilverbulletUserRegister(model.getRuntimRegisterMap());			
		SilverbulletUserEasyAccess props = new SilverbulletUserEasyAccess(model.getEasyAccessInterface());


		try {
			while(true) {
				register.waitInterrupt();
				if (register.hardkey.readAndReset(HARDKEY.AVG) == 0x01) {
					props.setCollecmode(EnumCollecmode.ID_COLLECMODE_AVERAGE);
					toggleStartStop(props);						
				}
				else if (register.hardkey.readAndReset(HARDKEY.REL) == 0x01) {
				
				}
				else if (register.hardkey.readAndReset(HARDKEY.MENU) == 0x01) {
					props.setApplication(EnumApplication.ID_APPLICATION_TOP);
				}
				else if (register.hardkey.readAndReset(HARDKEY.FILE) == 0x01) {
					props.setApplication(EnumApplication.ID_APPLICATION_FILE_MANAGER);
				}
				
				if (register.error_status.readAndReset(ERROR_STATUS.BAT) == 0x01) {
					props.setError(EnumError.ID_ERROR_HARDWARE);
				}
				if (register.error_status.readAndReset(ERROR_STATUS.CUR) == 0x01) {
					props.setError(EnumError.ID_ERROR_HARDWARE);
				}
				if (register.error_status.readAndReset(ERROR_STATUS.DISK) == 0x01) {
					props.setError(EnumError.ID_ERROR_HARDWARE);
				}
				if (register.error_status.readAndReset(ERROR_STATUS.TEMP) == 0x01) {
					props.setError(EnumError.ID_ERROR_HARDWARE);
				}
				
//				if (register.hardkey.read_and_reset_Average()) {
//					props.setCollecmode(EnumCollecmode.ID_COLLECMODE_AVERAGE);
//
//					toggleStartStop(props);
//				}
//				if (register.hardkey.read_and_reset_Realtime()) {
//					props.setCollecmode(EnumCollecmode.ID_COLLECMODE_REALTIME);
//					toggleStartStop(props);
//				}
//				if (register.otdrInterruptStatus.read_erroroccurs()) {
//					props.setError(EnumError.ID_ERROR_HARDWARE);
//				}
			}
		}
		catch (RequestRejectedException e) {
			e.printStackTrace();
		}
	}

	private void toggleStartStop(SilverbulletUserEasyAccess props) throws RequestRejectedException {
		if (props.getOtdrTestcontrol().equals(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP)) {
			props.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_START);
		}
		else {
			props.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP);
		}
	}
}
