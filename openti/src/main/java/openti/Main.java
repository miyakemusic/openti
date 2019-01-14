package openti;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.NativeLibrary;

import jp.silverbullet.BuilderModelImpl;
import jp.silverbullet.SilverBulletServer;
import jp.silverbullet.dependency2.RequestRejectedException;
import jp.silverbullet.register2.RegisterAccessor;
import openti.UserEasyAccess.EnumCollecmode;
import openti.UserEasyAccess.EnumError;
import openti.UserEasyAccess.EnumOtdrTestcontrol;
import openti.UserRegister.ERROR_STATUS;
import openti.UserRegister.HARDKEY;
import openti.test.SimHardware;

public class Main extends SilverBulletServer {
	public static void main(String arg[]) {
		new Main().start(arg[0]);
	}
	@Override
	protected String getDefaultFilename() {
		return "ti_back.zip"; 
		
	}

	@Override
	protected void onStart(BuilderModelImpl model) {
		model.getRuntimRegisterMap().addDevice(new RealHardwareAccessor(model.getRegisterSpecHolder()));
		
		model.getSequencer().addUserSequencer(new TestSequencer());
		new Thread() {
			@Override
			public void run() {
				UserRegister register = new UserRegister(model.getRuntimRegisterMap());			
				UserEasyAccess props = new UserEasyAccess(model.getEasyAccessInterface());


				try {
					while(true) {
						register.waitInterrupt();
						if (register.hardkey.read(HARDKEY.AVG) == 0x01) {
							props.setCollecmode(EnumCollecmode.ID_COLLECMODE_AVERAGE);
							toggleStartStop(props);						
						}
						else if (register.hardkey.read(HARDKEY.REL) == 0x01) {
						
						}
						
						if (register.error_status.read(ERROR_STATUS.BAT) == 0x01) {
							props.setError(EnumError.ID_ERROR_HARDWARE);
						}
						if (register.error_status.read(ERROR_STATUS.CUR) == 0x01) {
							props.setError(EnumError.ID_ERROR_HARDWARE);
						}
						if (register.error_status.read(ERROR_STATUS.DISK) == 0x01) {
							props.setError(EnumError.ID_ERROR_HARDWARE);
						}
						if (register.error_status.read(ERROR_STATUS.TEMP) == 0x01) {
							props.setError(EnumError.ID_ERROR_HARDWARE);
						}
//						if (register.hardkey.read_and_reset_Average()) {
//							props.setCollecmode(EnumCollecmode.ID_COLLECMODE_AVERAGE);
//
//							toggleStartStop(props);
//						}
//						if (register.hardkey.read_and_reset_Realtime()) {
//							props.setCollecmode(EnumCollecmode.ID_COLLECMODE_REALTIME);
//							toggleStartStop(props);
//						}
//						if (register.otdrInterruptStatus.read_erroroccurs()) {
//							props.setError(EnumError.ID_ERROR_HARDWARE);
//						}
					}
				}
				catch (RequestRejectedException e) {
//					// TODO Auto-generated catch block
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
			
		}.start();
	}
	@Override
	protected List<RegisterAccessor> getSimulators() {
		return Arrays.asList(new SimHardware());
	}
	@Override
	protected String getBaseFolderAndPackage() {
		return "src/main/java;openti";
	}

}
