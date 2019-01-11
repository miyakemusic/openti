package openti.test;

import java.util.BitSet;

public class ObsoluteSimOtdr  {
	private OtdrHardware otdr = new OtdrHardware() {
		@Override
		protected void onCompleted() {
//			SimOtdr.this.updateBlockData(UserRegisterControl.ADDR_ADDROTDRTRACEDATA, otdr.getData());
//			
//			BitSet data = new BitSet();
//			data.set(UserRegisterControl.BIT_OTDRINTERRUPTSTATUS_TRACEDATAREADY);
//			SimOtdr.this.updateRegister(UserRegisterControl.ADDR_OTDRINTERRUPTSTATUS, data, data);
//			SimOtdr.this.triggerInterrupt();
		}
	};

	protected void writeBlock(long address, byte[] data) {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public void write_otdrtestcontrol_teststart(int value) {
//		if (value == 1) {
//			otdr.start();
//		}
//		else {
//			otdr.stop();
//		}
//	}
//
//
//	@Override
//	public void read_otdrtestcontrol_otdrtestcontrol() {
//		// TODO Auto-generated method stub
//		
//	}

}
