package openti.test;

import java.nio.ByteBuffer;
import java.util.Random;

public abstract class OtdrHardware {
	protected abstract void onCompleted();
	
	private boolean stopRequested = false;
	private byte[] data;
	
	public void start() {
		stopRequested = false;
		new Thread() {
			@Override
			public void run() {
				Random random = new Random();
				int size = 2001;
				ByteBuffer byteBuf = ByteBuffer.allocate(size*2);
				for (int i = 0; i < size; i++) {
					double v = Math.sin((double)i/1000.0) * 100 + random.nextGaussian() * 20;
					short shortV = (short)(v);
					byteBuf.putShort(shortV);
				}
				
				data = byteBuf.array();
	
				
				onCompleted();
			}

		}.start();
	}

	public void stop() {
		stopRequested = true;
	}

	public byte[] getData() {
		return this.data;
	}
}
