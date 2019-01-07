package openti;

import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.register2.RuntimeRegister;
import jp.silverbullet.register2.RuntimeRegisterHolder;

public class UserRuntimeRegisterHolder extends RuntimeRegisterHolder {

	public UserRuntimeRegisterHolder(RegisterAccessor registerAccessor) {
		super(registerAccessor);
	}
	
	public enum Reg1 {
		bit1, bit2
	}

	public enum Reg2 {
		bit3, bit4
	}

	public RuntimeRegister<Reg1> reg1 = new RuntimeRegister<>("Reg1", accessor);
	public RuntimeRegister<Reg2> reg2 = new RuntimeRegister<>("Reg2", accessor);
}
