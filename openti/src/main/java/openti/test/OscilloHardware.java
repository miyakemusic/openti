package openti.test;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class OscilloHardware {

	public static void main(String[] arg) {
		OscilloHardware sci = new OscilloHardware() {
			@Override
			protected void onUpdate() {

			}
		};
		sci.start();
	}
	private boolean stopRequested;
	private EyeImage data = new EyeImage(800,600);
//	private SimRegisterControl regControl;
	private boolean ppgRunning = false;
	private int ppgBitRate;
	private int ppgTestPattenr;
	private double triggerPos = 0.0;
	private long samplingCount = 0;

	private Object sync = new Object();
	private Thread thread;
	
	abstract protected void onUpdate();

	public OscilloHardware() {
		stopRequested = true;
		thread = new Thread() {
			@Override
			public void run() {
				work();
			}
		};
		thread.start();			
	}
	
	public void start() {
		stopRequested = false;
		this.samplingCount = 0;
		synchronized(sync) {
			sync.notify();
		}
	
	}

	protected void work() {
		int width = this.data.getWidth();
		int height = this.data.getHeight();
		Random random = new Random();
		this.data.clear();
		
		long times = 0;
		while(true) {
			if (stopRequested) {
				synchronized(sync) {
					try {
						sync.wait();
						this.data.clear();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			double amp = 5;
			
			for (int x = 0; x < width; x++) {
				double dWidth = width;
				double dHeight = height;
				double dX = x;
				//dX += Math.PI / 2.0 / (dWidth/2.0);
				double phase = triggerPos/10;
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
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			onUpdate();
		}

	}

	public byte[] getData() {
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

	public byte[] get() {
		try {
			return this.save();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public byte[] save() throws IOException, ClassNotFoundException {
		EyeImage eye = this.data;
		
		BufferedImage image = new BufferedImage(eye.getWidth(), eye.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int x = 0; x < eye.getWidth(); x++) {
			for (int y = 0; y < eye.getHeight(); y++) {
				int v = eye.getValue(x, y);
				int rgb =  0xff000000 | v <<16 | v <<8 | v;
				image.setRGB(x, y, this.getColorScaleBCGYR((double)v / 10.0));
//				if (v != 0) {
//					System.out.println(v);
//				}
			}
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		BufferedOutputStream os = new BufferedOutputStream( bos );
		image.flush();
//		ImageIO.write( image, "png", new File("C:\\Users\\miyak\\git\\openti\\openti\\eye.png") );
		ImageIO.write( image, "png", os);
		return bos.toByteArray();
	}
	private double getNoise(Random random) {
		return (random.nextGaussian() - 0.5) * 9.0;
	}
	
	private void increment(int x, int y) {
		if (y>=0 && y <data.getHeight()) {
			data.increment(x,y);
		}
	}
	
	private static final double M_PI = 3.141592;
	int getColorScaleBCGYR( double in_value )
	{
	    // 0.0～1.0 の範囲の値をサーモグラフィみたいな色にする
	    // 0.0                    1.0
	    // 青    水    緑    黄    赤
	    // 最小値以下 = 青
	    // 最大値以上 = 赤
	    int ret;
	    int a = 255;    // alpha値
	    int r, g, b;    // RGB値
	    double  value = in_value;
	    double  tmp_val = Math.cos( 4 * M_PI * value );
	    int     col_val = (int)( ( -tmp_val / 2 + 0.5 ) * 255 );
	         if ( value >= ( 4.0 / 4.0 ) ) { r = 255;     g = 0;       b = 0;       }   // 赤
	    else if ( value >= ( 3.0 / 4.0 ) ) { r = 255;     g = col_val; b = 0;       }   // 黄～赤
	    else if ( value >= ( 2.0 / 4.0 ) ) { r = col_val; g = 255;     b = 0;       }   // 緑～黄
	    else if ( value >= ( 1.0 / 4.0 ) ) { r = 0;       g = 255;     b = col_val; }   // 水～緑
	    else if ( value >= ( 0.0 / 4.0 ) ) { r = 0;       g = col_val; b = 0/*255*/;     }   // 青～水
	    else {                               r = 0;       g = 0;       b = 255;     }   // 青
	    ret = (a&0x000000FF) << 24
	        | (r&0x000000FF) << 16
	        | (g&0x000000FF) <<  8
	        | (b&0x000000FF);
	    return ret;
	}

	public void stop() {
		stopRequested= true;
	}

	public void setTriggerPos(Integer value) {
		this.triggerPos = value;
	}
}
