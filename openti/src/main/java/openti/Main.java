package openti;

import jp.silverbullet.SilverBulletServer;
import jp.silverbullet.handlers.EasyAccessModel;
import jp.silverbullet.handlers.RegisterAccess;
import openti.UserEasyAccess.EnumCollecmode;
import openti.UserEasyAccess.EnumError;
import openti.UserEasyAccess.EnumOtdrTestcontrol;

public class Main extends SilverBulletServer {
	public static void main(String arg[]) {
		new Main().start(arg[0]);
	}
	@Override
	protected String getDefaultFilename() {
		return "ti_back.zip"; 
		
	}
	@Override
	protected String getUserPath() {
		String ret = this.getClass().getName().replace("." + this.getClass().getSimpleName(), "");
		return ret;
	}
	@Override
	protected void onStart(EasyAccessModel easyAccess, RegisterAccess registerAccess) {
		new Thread() {
			@Override
			public void run() {
				UserRegisterControl register = new UserRegisterControl(registerAccess);
				UserEasyAccess props = new UserEasyAccess(easyAccess);
				
				while(true) {
					register.waitIntrrupt();
					if (register.hardkey.read_and_reset_Average()) {
						props.setCollecmode(EnumCollecmode.ID_COLLECMODE_AVERAGE);
						toggleStartStop(props);
					}
					if (register.hardkey.read_and_reset_Realtime()) {
						props.setCollecmode(EnumCollecmode.ID_COLLECMODE_REALTIME);
						toggleStartStop(props);
					}
					if (register.otdrInterruptStatus.read_erroroccurs()) {
						props.setError(EnumError.ID_ERROR_HARDWARE);
					}
				}
			}

			private void toggleStartStop(UserEasyAccess props) {
				if (props.getOtdrTestcontrol().equals(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP)) {
					props.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_START);
				}
				else {
					props.setOtdrTestcontrol(EnumOtdrTestcontrol.ID_OTDR_TESTCONTROL_STOP);
				}
			}
			
		}.start();
	}
}
