package openti.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.silverbullet.core.register2.BitValue;
import jp.silverbullet.core.register2.RegisterAccessor;
import jp.silverbullet.core.register2.RegisterAccessorListener;
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
	
	private OscilloHardware oscillo = new OscilloHardware() {

		@Override
		protected void onUpdate() {
			listeners.forEach(listener -> listener.onUpdate(UserRegister.Register.EYEDIAGRAM, oscillo.get()));
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
		else if (regName.equals(UserRegister.Register.OSCILLO_TEST)) {
			data.forEach(v -> {
				if (v.bitName.equals(UserRegister.OSCILLO_TEST.TEST)) {
					if (v.value == 0x01) {
						oscillo.start();
					}
					else if ( v.value == 0x00) {
						oscillo.stop();
					}
				}
				else if (v.bitName.equals(UserRegister.OSCILLO_TEST.TRGPOS)) {
					oscillo.setTriggerPos(v.value);
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

	@Override
	public void write(Object regName, Object bitName, int value) {
		this.write(regName, Arrays.asList(new BitValue(bitName, value)));
	}
}
