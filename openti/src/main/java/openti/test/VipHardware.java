package openti.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class VipHardware {

	static public void main(String[] arg) {
		new VipHardware();
	}
	
	public VipHardware() {
		System.load("C:\\opencv-3.4.12\\build\\java\\x64\\opencv_java3412.dll");
//		JFrame frame = new JFrame();
//		frame.setSize(new Dimension(800, 600));
		
//		JLabel label = new JLabel();
//		frame.setLayout(new BorderLayout());
//		frame.add(label, BorderLayout.CENTER);
		
//		ImageIcon icon = new ImageIcon(getClass().getResource("/openti/test/Microscope-SM.jpg"));
//		label.setIcon(icon);
		
//		frame.setVisible(true);
        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        System.out.println("OpenCV Mat: " + m);
        Mat mr1 = m.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = m.col(5);
        mc5.setTo(new Scalar(5));
        
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        String path = getClass().getResource("/openti/test/1122599.jpg").getPath();
        Mat mat = Imgcodecs.imread(path, Imgcodecs.IMREAD_COLOR);
        
        if(mat.empty()) {
        	System.out.println("empty");
        }
        Core.transpose(mat, mat);
        Core.flip(mat, mat, 1);
        Imgcodecs.imwrite("ThumbsUp_output.jpg", mat);
        
        Mat destination = new Mat(mat.rows(),mat.cols(),mat.type());
        Imgproc.GaussianBlur(mat, destination, new Size(5, 5), 8, 6);
        byte[] bytes = new byte[(int) (mat.total() * mat.channels())];
        destination.get(0, 0, bytes);
        
	}

}
