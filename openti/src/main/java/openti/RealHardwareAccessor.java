package openti;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;

import jp.silverbullet.register2.BitValue;
import jp.silverbullet.register2.RegisterAccessor;
import jp.silverbullet.register2.RegisterAccessorListener;
import jp.silverbullet.register2.RegisterBit;
import jp.silverbullet.register2.RegisterSpecHolder;
import jp.silverbullet.register2.SvRegister;

public class RealHardwareAccessor implements RegisterAccessor {

	private RegisterAccessorListener listener;
	private RegisterSpecHolder specHolder;

	public interface NativeDll extends Library {
		NativeDll INSTANCE = (NativeDll)
            Native.loadLibrary("nativecpp.dll", NativeDll.class);
		int writeReg(long addr, long val);
		int writeBlock(long addr, byte[] bytes, int size);
		long readReg(long addr);
		int readBlock(long addr, byte[] bytes, int size);
		
		public interface Interrupt extends Callback {
		    boolean callback(int id, int value);
		}
		public void setCallback(Interrupt evnHnd);
    }
	
	public RealHardwareAccessor(RegisterSpecHolder specs) {
		this.specHolder = specs;
//		
//		NativeDll.INSTANCE.writeReg(0x01, 5);
//		long ret = NativeDll.INSTANCE.readReg(0x01);
//		System.out.println(ret);
//		
//		byte[] bytes = new String("hello").getBytes();
//		NativeDll.INSTANCE.writeBlock(0x01, bytes, bytes.length);
//		
//		byte[] bytes2 = new byte[4];
//		NativeDll.INSTANCE.readBlock(0x01, bytes2, bytes2.length);
//		String s = new String(bytes2);
//		System.out.println(s);
	}

	@Override
	public void write(Object regName, List<BitValue> data) {
		SvRegister reg = this.specHolder.getRegisterByName(regName.toString());	

		long current = NativeDll.INSTANCE.readReg(reg.getDecAddress());
		BitSet bitSet = BitSet.valueOf(new long[] {current});
		data.forEach(bit -> {
			RegisterBit bitInfo = reg.getBit(bit.bitName.toString());
			long v = bit.value;
			BitSet b = BitSet.valueOf(new long[] {v<<bitInfo.getStartBit()});
			bitSet.or(b);
		});

		NativeDll.INSTANCE.writeReg(reg.getDecAddress(), bitSet.toLongArray()[0]);
	}

	@Override
	public long readRegister(Object regName, Object bitName) {
		SvRegister reg = this.specHolder.getRegisterByName(regName.toString());	
		long read =  NativeDll.INSTANCE.readReg(reg.getDecAddress());
		
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
		// TODO Auto-generated method stub
		
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
