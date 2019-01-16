package openti.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.silverbullet.register2.BitValue;
import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.register2.RegisterAccessorListener;
import openti.UserRegister;

public class SimHardware implements RegisterAccessor {

	private Set<RegisterAccessorListener> listeners = new HashSet<>();
	
	private OtdrHardware otdr = new OtdrHardware() {
		@Override
		protected void onCompleted() {
			listeners.forEach(listener -> listener.onUpdate(UserRegister.Register.DATA, otdr.getData()));
			listeners.forEach(listener -> listener.onInterrupt());
		}		
	};
	
	@Override
	public void write(Object regName, List<BitValue> data) {
		if (regName.equals(UserRegister.Register.TEST_CONTROL)) {
			data.forEach(v -> {
				if (v.bitName.equals(UserRegister.TEST_CONTROL.STA)) {
					if (v.value == 0x01) {
						otdr.start();
					}
				}
			});
			
		}

	}

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
		this.listeners.add(listener);
	}

	@Override
	public byte[] readRegister(Object regName) {
		if (regName.equals(UserRegister.Register.DATA)) {
			return otdr.getData();
		}
		return null;
	}
}
