package openti;
import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.register2.RuntimeRegister;
import jp.silverbullet.register2.RuntimeRegisterHolder;
public class UserRegister extends RuntimeRegisterHolder {
	public UserRegister(RegisterAccessor registerAccessor) {
		super(registerAccessor);
	}
	public enum Register {
		Test_control, 
		Test_setup, 
		Hardkey, 
		Data, 
	}
	public enum Test_control {
		Pause, 
		Stop, 
		Start, 
	}
	public RuntimeRegister<Test_control> test_control = new RuntimeRegister<>(Register.Test_control, accessor);
	public enum Test_setup {
		Setup, 
	}
	public RuntimeRegister<Test_setup> test_setup = new RuntimeRegister<>(Register.Test_setup, accessor);
	public enum Hardkey {
		Realtime, 
		Average, 
	}
	public RuntimeRegister<Hardkey> hardkey = new RuntimeRegister<>(Register.Hardkey, accessor);
	public enum Data {
	}
	public RuntimeRegister<Data> data = new RuntimeRegister<>(Register.Data, accessor);
}
