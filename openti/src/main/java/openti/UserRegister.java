package openti;
import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.register2.RuntimeRegister;
import jp.silverbullet.register2.RuntimeRegisterHolder;
public class UserRegister extends RuntimeRegisterHolder {
	public UserRegister(RegisterAccessor registerAccessor) {
		super(registerAccessor);
	}
	public enum Register {
		TEST_CONTROL, 
		TEST_SETUP, 
		HARDKEY, 
		DATA, 
	}
	public enum TEST_CONTROL {
		TEST, 
		PAUSE, 
		STOP, 
		START, 
	}
	public RuntimeRegister<TEST_CONTROL> test_control = new RuntimeRegister<>(Register.TEST_CONTROL, accessor);
	public enum TEST_SETUP {
		SETUP, 
	}
	public RuntimeRegister<TEST_SETUP> test_setup = new RuntimeRegister<>(Register.TEST_SETUP, accessor);
	public enum HARDKEY {
		REALTIME, 
		AVERAGE, 
	}
	public RuntimeRegister<HARDKEY> hardkey = new RuntimeRegister<>(Register.HARDKEY, accessor);
	public enum DATA {
		NEW1546947679311, 
	}
	public RuntimeRegister<DATA> data = new RuntimeRegister<>(Register.DATA, accessor);
}
