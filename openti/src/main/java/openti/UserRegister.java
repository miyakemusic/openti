package openti;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.register2.RuntimeRegister;
import jp.silverbullet.core.register2.RuntimeRegisterHolder;
public class UserRegister extends RuntimeRegisterHolder {
	public UserRegister(RegisterAccessor registerAccessor) {
		super(registerAccessor);
	}
	public enum Register {
		TEST_CONTROL, 
		TEST_SETUP, 
		HARDKEY, 
		TEST_CONFIG1, 
		ERROR_STATUS, 
		DATA, 
		OSCILLO_TEST, 
		EYEDIAGRAM, 
		PPG, 
		ED, 
	}
	public enum TEST_CONTROL {
		TEST, 
		PAU, 
		STP, 
		STA, 
	}
	public RuntimeRegister<TEST_CONTROL> test_control = new RuntimeRegister<>(Register.TEST_CONTROL, accessor);
	public enum TEST_SETUP {
		POINTS, 
		DURATION, 
	}
	public RuntimeRegister<TEST_SETUP> test_setup = new RuntimeRegister<>(Register.TEST_SETUP, accessor);
	public enum HARDKEY {
		FILE, 
		MENU, 
		REL, 
		AVG, 
	}
	public RuntimeRegister<HARDKEY> hardkey = new RuntimeRegister<>(Register.HARDKEY, accessor);
	public enum TEST_CONFIG1 {
		DISTANCE, 
		PULSE, 
	}
	public RuntimeRegister<TEST_CONFIG1> test_config1 = new RuntimeRegister<>(Register.TEST_CONFIG1, accessor);
	public enum ERROR_STATUS {
		BAT, 
		DISK, 
		CUR, 
		TEMP, 
	}
	public RuntimeRegister<ERROR_STATUS> error_status = new RuntimeRegister<>(Register.ERROR_STATUS, accessor);
	public enum DATA {
		NEW1546957728577, 
	}
	public RuntimeRegister<DATA> data = new RuntimeRegister<>(Register.DATA, accessor);
	public enum OSCILLO_TEST {
		TRGPOS, 
		TEST, 
	}
	public RuntimeRegister<OSCILLO_TEST> oscillo_test = new RuntimeRegister<>(Register.OSCILLO_TEST, accessor);
	public enum EYEDIAGRAM {
		EYEDIAGRAM, 
	}
	public RuntimeRegister<EYEDIAGRAM> eyediagram = new RuntimeRegister<>(Register.EYEDIAGRAM, accessor);
	public enum PPG {
		START_STOP, 
	}
	public RuntimeRegister<PPG> ppg = new RuntimeRegister<>(Register.PPG, accessor);
	public enum ED {
		START_STOP, 
	}
	public RuntimeRegister<ED> ed = new RuntimeRegister<>(Register.ED, accessor);
}
