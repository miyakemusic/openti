package openti;

import java.util.Arrays;
import java.util.List;

public abstract class Olts {
	private boolean stopFlag = false;
	
	protected abstract void onUpdate(String value);

	public List<String> targetIds() {
		return Arrays.asList(ID.ID_LS_ENABLED);
	}

	public void start() {
		new Thread() {
			@Override
			public void run() {
				stopFlag = false;
				while (!stopFlag) {
					double v = (Math.random() + 0.5) * 5 - 40;
					onUpdate(String.format("%.2f", v) + " dBm");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public void stop() {
		stopFlag = true;
	}

}
