package openti;

import jp.silverbullet.BuilderModelImpl;
import jp.silverbullet.dependency2.RequestRejectedException;
import openti.UserEasyAccess.EnumCollecmode;
import openti.UserEasyAccess.EnumError;
import openti.UserEasyAccess.EnumOtdrTestcontrol;
import openti.UserRegister.ERROR_STATUS;
import openti.UserRegister.HARDKEY;

public class BackgroundThread extends Thread {

	private BuilderModelImpl model;

	public BackgroundThread(BuilderModelImpl model) {
		this.model = model;
	}

	@Override
	public void run() {
		UserRegister register = new UserRegister(model.getRuntimRegisterMap());			
		UserEasyAccess props = new UserEasyAccess(model.getEasyAccessInterface());


		try {
			while(true) {
				register.waitInterrupt();
				if (register.hardkey.readAndReset(HARDKEY.AVG) == 0x01) {
					props.setCollecmode(EnumCollecmode.ID_COLLECMODE_AVERAGE);
					toggleStartStop(props);						
				}
				else if (register.hardkey.readAndReset(HARDKEY.REL) == 0x01) {
				
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

	private void toggleStartStop(UserEasyAccess props) throws RequestRejectedException {
		if (props.getOtdrTestcontrol().equals(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP)) {
			props.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_START);
		}
		else {
			props.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP);
		}
	}
}
