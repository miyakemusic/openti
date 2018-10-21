package openti.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

import jp.silverbullet.handlers.RegisterAccess;
import openti.AbstractUserSimulator;
import openti.SimRegisterControl;
import openti.UserRegisterControl;

public class SimOscillo extends AbstractUserSimulator{

	private boolean stopRequested;
	private EyeImage data = new EyeImage(500,400);
	private SimRegisterControl regControl;
	private boolean ppgRunning = false;
	private int ppgBitRate;
	private int ppgTestPattenr;
	private double triggerPos = 0.0;
	private long samplingCount = 0;
	
	public SimOscillo(RegisterAccess registerAccess) {
		regControl = new SimRegisterControl(registerAccess);
	}
	

	@Override
	protected void writeBlock(long address, byte[] data) {
		// TODO Auto-generated method stub
		
	}

	private void stopCollection() {
		stopRequested = true;
	}

	private void startCollection() {
		stopRequested = false;
		this.samplingCount = 0;
		new Thread() {
			@Override
			public void run() {
				work();
			}
		}.start();		
	}

	protected void work() {
		int width = this.data.getWidth();
		int height = this.data.getHeight();
		Random random = new Random();
		this.data.clear();
		
		while(!stopRequested) {
			if (!this.ppgRunning) {
				this.updateData();
				continue;
			}
			
			double amp = 5;
			
			for (int x = 0; x < width; x++) {
				double dWidth = width;
				double dHeight = height;
				double dX = x;
				//dX += Math.PI / 2.0 / (dWidth/2.0);
				double phase = triggerPos;
				{
					double v_plus = Math.sin(dX / (dWidth/2.0) * Math.PI + phase) * (amp /5 * dHeight / 4.0)+ getNoise(random);
					v_plus += dHeight / 2;
					int y = (int)v_plus;
					increment(x, y);
				}
				{
					double v_minus = Math.sin(dX / (dWidth/2.0) * Math.PI + phase) * (amp /5 * dHeight / 4.0)+ getNoise(random);
					v_minus *= -1;
					v_minus += dHeight / 2;
					int y = (int)v_minus;
					increment(x, y);
				}
				
				{
					double v_plus = (amp /5 * dHeight / 4.0)+ getNoise(random);
					v_plus += dHeight / 2;
					int y = (int)v_plus;
					increment(x, y);
				}
				{
					double v_minus = (amp /5 * dHeight / 4.0)+ getNoise(random);
					v_minus *= -1;
					v_minus += dHeight / 2;
					int y = (int)v_minus;
					increment(x, y);
				}
			}
			
			updateData();
		}

	}


	private void updateData() {
		super.updateBlockData(UserRegisterControl.ADDR_ADDREYEDIAGRAM, getByteArray(data));
		
		if (samplingCount == 0) {
			super.triggerInterrupt();
		}
		samplingCount++;
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private byte[] getByteArray(EyeImage data2) {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bao);
			oos.writeObject(this.data);
			return bao.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private double getNoise(Random random) {
		return (random.nextGaussian() - 0.5) * 5.0;
	}
	
	private void increment(int x, int y) {
		if (y>=0 && y <data.getHeight()) {
			data.increment(x,y);
		}
	}

	@Override
	public void write_OSCControl_startstop(int value) {
		if (value == 0) {
			stopCollection();
		}
		else if (value == 1) {
			startCollection();
		}
	}

	@Override
	public void write_PPGControl_TestPattern(int value) {
		ppgTestPattenr = value;
	}


	@Override
	public void write_PPGControl_StartStop(int value) {
		ppgRunning = (value == 1);
	}


	@Override
	public void write_PPGControl_BitRate(int value) {
		ppgBitRate = value;
	}

	@Override
	public void write_OSCControl_DataClear(int value) {
		if (value == 1) {
			this.data.clear();
		}
	}


	@Override
	public void write_OSCControl_Trigger(int value) {
		triggerPos = ((double)value) * 1e-3;
	}

}
