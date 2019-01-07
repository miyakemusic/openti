package openti;

import java.util.List;
import java.util.Map;

import jp.silverbullet.dependency2.ChangedItemValue;
import jp.silverbullet.handlers.EasyAccessInterface;
import jp.silverbullet.register2.RegisterAccessor;
import openti.UserRuntimeRegisterHolder.Reg1;

public class TestSequencer2 {

	public void handle(RegisterAccessor registerAccessor, EasyAccessInterface propertyAccessor, Map<String, List<ChangedItemValue>> changed) {
		UserRuntimeRegisterHolder register = new UserRuntimeRegisterHolder(registerAccessor);
		UserEasyAccess properties = new UserEasyAccess(propertyAccessor);
		
		register.reg1.set(Reg1.bit1, 0x01).set(Reg1.bit2, 0x00).write();
		register.reg1.read(Reg1.bit2);
		register.reg1.clear();
	}
}
