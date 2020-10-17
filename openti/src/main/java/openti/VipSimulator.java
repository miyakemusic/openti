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

import jp.silverbullet.core.sequncer.SvHandlerModel;

public 	abstract class VipSimulator {
	private boolean stopFlag = false;
	private BufferedImage originalImage;

	public VipSimulator() {
		System.load("C:\\opencv\\build\\java\\x64\\opencv_java450.dll");
        try {
			originalImage = ImageIO.read(new File(getClass().getResource("/openti/test/Microscope-SM.jpg").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	double num = 0;
	double sigma = 20;
	public void start() {
		stopFlag = false;
		
		new Thread() {
			@Override
			public void run() {
				num = 199;
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
