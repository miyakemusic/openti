package openti;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public 	abstract class VipSimulator {
	private boolean stopFlag = false;
	private BufferedImage originalImage;

	public VipSimulator() {
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			System.load("C:\\opencv\\build\\java\\x64\\opencv_java450.dll");
		}
		else {
			System.out.println("System.load(\"/usr/local/lib/libopencv_java450.so\");");
			System.load("/usr/local/lib/libopencv_java450.so");
		}
		
        try {
        	File imageFile = new File(getClass().getResource("/openti/test/manta.jpg").getPath());
			originalImage = ImageIO.read(imageFile);
		} catch (IOException e) {
			try {
				originalImage = ImageIO.read(new File("Microscope-SM.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	double num = 0;
	double sigma = 20;
	public void start() {
		onStart();
		stopFlag = false;
		
		new Thread() {
			@Override
			public void run() {
				num = 99;
				sigma = 20;

				while(true) {
					if (stopFlag) {
						break;
					}

					num -= 10;
					Mat mat = bufferedImageToMat(originalImage);
					Mat destination = new Mat(mat.rows(),mat.cols(),mat.type());
					if (num < 10) {
						num = 0;
						sigma = 1;
					}
			        Imgproc.GaussianBlur(mat, destination, new Size((int)num, (int)num), sigma);

			        MatOfByte mob=new MatOfByte();
			        Imgcodecs.imencode(".png", destination, mob);
			        
			        onUpdate(mob.toArray());
			        if (num <= 0) {
			        	onComplete();
			        	break;
			        }

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}.start();
	}

	abstract protected void onUpdate(byte[] bytes);
	abstract protected void onComplete();
	abstract protected void onStart();
	
	public void stop() {
		stopFlag = true;
	}
	
	public Mat bufferedImageToMat(BufferedImage bi) {
		  Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
		  byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
		  mat.put(0, 0, data);
		  return mat;
	}
	
}
