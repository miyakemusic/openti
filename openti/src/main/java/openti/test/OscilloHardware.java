package openti.test;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
//		
//		new Thread() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 10; i++) {
//					try {
//						Thread.sleep(0);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					try {
//						byte[] b = sci.save();
//						FileOutputStream out = new FileOutputStream("C:\\Users\\miyak\\git\\openti\\openti\\eye_" + i + ".png");
//						out.write(b);
//						out.close();
//					} catch (ClassNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}.start();
	}
	private boolean stopRequested;
	private EyeImage data = new EyeImage(800,500);
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
			int yoffset = 0;
			for (int x = 0; x < width; x++) {
				double dWidth = width;
				double dHeight = height;
				double dX = x;
				//dX += Math.PI / 2.0 / (dWidth/2.0);
				double phase = triggerPos/10;
				createOne2(random, amp, 0, x, dWidth, dHeight, dX, phase);
//				createOne(random, amp, height/4, x, dWidth, dHeight, dX, phase);
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			onUpdate();
//			System.out.println("Update");
		}

	}
	private void createOne2(Random random, double amp, int yoffset, int x, double dWidth, double dHeight, double dX,
			double phase) {
			
		double base = dHeight;
		double baseAmp = amp;
		double baseLine = dHeight / 4;
		double lineStep = dHeight / 5;
		
		createLine(x, baseLine, random);
		createLine(x, baseLine + lineStep, random);
		createLine(x, baseLine + lineStep * 2, random);
		createLine(x, baseLine + lineStep * 3, random);
		
		boolean sin = true;
		boolean cos = true;
		/// sin ///
		if (sin) {
			// from 1
			createSine(x, baseLine, lineStep/2, phase, dWidth, random);
			createSine(x, baseLine, lineStep/2*2, phase, dWidth, random);
			createSine(x, baseLine, lineStep/2*3, phase, dWidth, random);
			
			// from2
			createSine(x, baseLine + lineStep, lineStep/2, phase, dWidth, random);
			createSine(x, baseLine + lineStep, lineStep/2*2, phase, dWidth, random);
	
			// from3
			createSine(x, baseLine + lineStep * 2, lineStep/2, phase, dWidth, random);
		}
		/// cos ///
		
		if (cos) {
			// from 3
			createSine(x, baseLine + lineStep * 3, -lineStep/2, phase, dWidth, random);
			createSine(x, baseLine + lineStep * 3, -lineStep/2*2, phase, dWidth, random);
			createSine(x, baseLine + lineStep * 3, -lineStep/2*3, phase, dWidth, random);
			
			// from 2
			createSine(x, baseLine + lineStep * 2, -lineStep/2, phase, dWidth, random);
			createSine(x, baseLine + lineStep * 2, -lineStep/2*2, phase, dWidth, random);
			
			// from 1
			createSine(x, baseLine + lineStep, -lineStep/2, phase, dWidth, random);
		}
	}
	
	private void createSine(int x, double baseLine, double amp, double phase, double dWidth, Random random) {
		double xx = (double)x / (dWidth/2.0) * Math.PI + phase;
		int y = (int)((Math.sin(xx)+1) * amp + getNoise(random) + (baseLine));
		increment(x, y);
	}

	private void createLine(int x, double value, Random random) {
		int y = (int)(value + getNoise(random));
		increment(x, y);
	}

	private void createOne(Random random, double amp, int yoffset, int x, double dWidth, double dHeight, double dX,
			double phase) {
		double half = 2;
		
		double level = (amp /5 * dHeight / 4.0);
		{ // upper line
			double v_plus = level + getNoise(random);
			v_plus += dHeight / 2;
			int y = (int)v_plus + yoffset;;
			increment(x, y);
		}
		{ // zero line 
			double v_zero = getNoise(random);
			v_zero += dHeight / 2;
			int y = (int)v_zero + yoffset;;
			increment(x, y);
		}
		{ // lower line
			double v_minus = level + getNoise(random);
			v_minus *= -1;
			v_minus += dHeight / 2;
			int y = (int)v_minus + yoffset;;
			increment(x, y);
		}
		{ // upper sine plus half
			double v_plus = Math.sin(dX / (dWidth/2.0) * Math.PI + phase) * level/ half + getNoise(random);
			v_plus += dHeight / 2 - level /2 ;
			int y = (int)v_plus + yoffset;
			increment(x, y);
		}
		{ // upper sine minus half
			double v_minus = Math.sin(dX / (dWidth/2.0) * Math.PI + phase) * level / half + getNoise(random);
			v_minus *= -1;
			v_minus += dHeight / 2 - level /2;
			int y = (int)v_minus + yoffset;;
			increment(x, y);
		}
		{ // lower sine plus half
			double v_plus = Math.sin(dX / (dWidth/2.0) * Math.PI + phase) * level/ half + getNoise(random);
			v_plus += dHeight / 2 + level /2 ;
			int y = (int)v_plus + yoffset;
			increment(x, y);
		}
		{ // lower sine minus half
			double v_minus = Math.sin(dX / (dWidth/2.0) * Math.PI + phase) * level / half + getNoise(random);
			v_minus *= -1;
			v_minus += dHeight / 2 + level /2;
			int y = (int)v_minus + yoffset;;
			increment(x, y);
		}
		
		{ // upper sine plus full
			double v_plus = Math.sin(dX / (dWidth/2.0) * Math.PI + phase) * level + getNoise(random);
			v_plus += dHeight / 2;
			int y = (int)v_plus + yoffset;
			increment(x, y);
		}
		{ // upper sine minus full
			double v_minus = Math.sin(dX / (dWidth/2.0) * Math.PI + phase) * level + getNoise(random);
			v_minus *= -1;
			v_minus += dHeight / 2;
			int y = (int)v_minus + yoffset;;
			increment(x, y);
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
//		long start = System.currentTimeMillis();
		
		EyeImage eye = this.data;
		
		BufferedImage image = new BufferedImage(eye.getWidth(), eye.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int x = 0; x < eye.getWidth(); x++) {
			for (int y = 0; y < eye.getHeight(); y++) {
				int v = eye.getValue(x, y);
				int rgb =  0xff000000 | v <<16 | v <<8 | v;
				image.setRGB(x, y, this.getColorScaleBCGYR((double)v / 10.0));
			}
		}
		
//		System.out.print(", " + String.valueOf(System.currentTimeMillis() - start) + ":" + Thread.currentThread().getName());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		BufferedOutputStream os = new BufferedOutputStream( bos );
		image.flush();
		ImageIO.write( image, "png", os);
		
//		System.out.print(", " + String.valueOf(System.currentTimeMillis() - start) + ":" + Thread.currentThread().getName());
//		System.out.println();
		
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
	    int ret;
	    int a = 255; 
	    int r, g, b; 
	    double  value = in_value;
	    double  tmp_val = Math.cos( 4 * M_PI * value );
	    int     col_val = (int)( ( -tmp_val / 2 + 0.5 ) * 255 );
	         if ( value >= ( 4.0 / 4.0 ) ) { r = 255;     g = 0;       b = 0;       }
	    else if ( value >= ( 3.0 / 4.0 ) ) { r = 255;     g = col_val; b = 0;       }
	    else if ( value >= ( 2.0 / 4.0 ) ) { r = col_val; g = 255;     b = 0;       }
	    else if ( value >= ( 1.0 / 4.0 ) ) { r = 0;       g = 255;     b = col_val; }
	    else if ( value >= ( 0.0 / 4.0 ) ) { r = 0;       g = col_val; b = 0;     }
	    else {                               r = 0;       g = 0;       b = 255;     }
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
