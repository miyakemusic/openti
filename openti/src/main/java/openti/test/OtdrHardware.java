package openti.test;

import java.nio.ByteBuffer;

public abstract class OtdrHardware {
	protected abstract void onCompleted();
	
	private boolean stopRequested = false;
	private byte[] data;
	
	public void start() {
		stopRequested = false;
		new Thread() {
			@Override
			public void run() {
				while(!stopRequested) {
					int size = 25001;
					ByteBuffer byteBuf = ByteBuffer.allocate(size*2);
					//short array[] = new short[25001];
					for (int i = 0; i < size; i++) {
						double v = Math.random() * 10 + 10;
						short shortV = (short)(v * 100);
						//array[i] = shortV;
						byteBuf.putShort(shortV);
					}
					
					data = byteBuf.array();
					
					break;
				}
				
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
