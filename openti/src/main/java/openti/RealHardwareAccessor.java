package openti;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

import jp.silverbullet.register2.BitValue;
import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.register2.RegisterAccessorListener;
import jp.silverbullet.register2.RegisterBit;
import jp.silverbullet.register2.RegisterSpecHolder;
import jp.silverbullet.register2.SvRegister;

public class RealHardwareAccessor implements RegisterAccessor {

	private RegisterAccessorListener listener;
	private RegisterSpecHolder specHolder;
	private Set<RegisterAccessorListener> listeners = new HashSet<>();

	public interface NativeDll extends Library {
		NativeDll INSTANCE = (NativeDll)
            Native.loadLibrary(Platform.isWindows() ? "NativeDll.dll" : "NativeSoLinux", NativeDll.class);
		int writeReg32(long addr, int val);
		int writeBlock(long addr, byte[] bytes, int size);
		int readReg32(long addr);
		int readBlock(long addr, byte[] bytes, int size);
		int waitInterrupt();
		int init();
		
		public interface Interrupt extends Callback {
		    boolean callback(int id, int value);
		}
		public void setCallback(Interrupt evnHnd);
    }
	
	public RealHardwareAccessor(RegisterSpecHolder specs) {
		this.specHolder = specs;
		NativeDll.INSTANCE.init();
		
		new Thread() {
			@Override
			public void run() {
				while (true) {
					int ret = NativeDll.INSTANCE.waitInterrupt();
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							fireInterrupt();
						}						
					});
				}
			}
		}.start();
	}

	private void fireInterrupt() {
		this.listeners.forEach(listener -> listener.onInterrupt());
	}
	
	@Override
	public void write(Object regName, List<BitValue> data) {
		SvRegister reg = this.specHolder.getRegisterByName(regName.toString());	

		long current = NativeDll.INSTANCE.readReg32(reg.getDecAddress());
		BitSet bitSet = BitSet.valueOf(new long[] {current});
		data.forEach(bit -> {
			RegisterBit bitInfo = reg.getBit(bit.bitName.toString());
			long v = bit.value;
			BitSet b = BitSet.valueOf(new long[] {v<<bitInfo.getStartBit()});
			bitSet.or(b);
		});

		int value = 0;
		for (int i = 0; i < bitSet.length(); i++) {
			if (bitSet.get(i)) {
				value |= (1 << i);
			}
		}
		value &= Integer.MAX_VALUE;
		NativeDll.INSTANCE.writeReg32(reg.getDecAddress(), value);
	}

	@Override
	public long readRegister(Object regName, Object bitName) {
		SvRegister reg = this.specHolder.getRegisterByName(regName.toString());	
		int read =  NativeDll.INSTANCE.readReg32(reg.getDecAddress());
		
		RegisterBit bit = reg.getBit(bitName.toString());
		
		BitSet bitSet = BitSet.valueOf(new long[] {read});
		bitSet.get(bit.getStartBit(), bit.getEndBit()+1);
		return bitSet.toLongArray()[0]>>bit.getStartBit();
	}

	@Override
	public void clear(Object string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(RegisterAccessorListener listener) {
		listeners .add(listener);
	}

	@Override
	public byte[] readRegister(Object regName) {
		SvRegister reg = this.specHolder.getRegisterByName(regName.toString());	
		String from = reg.getAddress().split("-")[0].replace("0x", "");
		String to = reg.getAddress().split("-")[1].replace("0x", "");
		long fromDec = Long.parseLong(from, 16 );
		long toDec = Long.parseLong(to, 16 );
		int size = (int)(toDec - fromDec);
		byte[] bytes = new byte[size];
		NativeDll.INSTANCE.readBlock(reg.getDecAddress(), bytes, size);
		
		return bytes;
	}

	@Override
	public void write(Object regName, Object bitName, int value) {
		this.write(regName, Arrays.asList(new BitValue(bitName, value)));
	}

}
