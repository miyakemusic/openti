package openti.test;

import java.util.List;

import jp.silverbullet.core.register2.BitValue;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.register2.RegisterAccessorListener;

public class SimBrokenHardware implements RegisterAccessor {

	@Override
	public long readRegister(Object regName, Object bitName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear(Object regName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(RegisterAccessorListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] readRegister(Object regName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(Object regName, Object bitName, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(Object regName, List<BitValue> data) {
		// TODO Auto-generated method stub
		
	}

}
