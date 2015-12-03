package area51.drone.opencv.test;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;

import org.opencv.video.Video;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import de.yadrone.apps.tutorial.TutorialVideoListener;
import de.yadrone.base.ARDrone;
import de.yadrone.base.video.ImageListener;





public class OpencvTest {

	public final double CONTRAST_ALPHA = 2.2;
	public final double CONTRAST_BETA = 90;
	public final int CAMERA_RES_WIDTH = 680;
	public final int CAMERA_RES_HEIGHT = 480;
	public final Scalar COL_WHITE = new Scalar(255, 255, 255);
	public final int CHANNEL_LOW = 70;
	public final int CHANNEL_HIGH = 130;
	// Matrices
//	private Mat mat_org;
//	private Mat mat_preProcessedWalls;
//	private Mat mat_preProcessedObstacle;
//	private Mat mat_preProcessedCmt;
//	private Mat mat_hsv;
//	private Mat mat_gray;
	private Mat mat_raw;

	private VideoCapture cam;
	private JFrame gui;
	private boolean DEBUG_STATE = false;
	private Mat frame;
	public static void main(String[] args) {
		new OpencvTest().run();
	}
	public OpencvTest() {
		super();

		gui = new JFrame();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLocationRelativeTo(null);
		gui.setBounds(0, 0, CAMERA_RES_WIDTH, CAMERA_RES_HEIGHT);
		gui.setLayout(null);
		gui.setVisible(true);

		// Load OpenCV library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		frame = new Mat();
	}

	public void run(){
		mat_raw = new Mat();

		if(DEBUG_STATE){
		cam = new VideoCapture();
		cam.open(0);

		delay(1000);
		cam.set(Videoio.CAP_PROP_FRAME_WIDTH, CAMERA_RES_WIDTH);
		cam.set(Videoio.CAP_PROP_FRAME_HEIGHT, CAMERA_RES_HEIGHT);
		}
		
		ARDrone drone = new ARDrone();
//		TutorialVideoListener videoListener =  new TutorialVideoListener(drone);
//		
		drone.getVideoManager().addImageListener(new ImageListener() {
			
			public void imageUpdated(BufferedImage img) {
				frame = BufferedImage2Mat(img);
				frame = DetectTag.detectTag(frame);
				gui.getGraphics().drawImage(Mat2BufferedImage(frame), 1, 1, null);
			}
		});
		
//		if(!cam.isOpened() && DEBUG_STATE){
//			System.out.println("Error");
//		}
//		else {
			
//			while(true){
//				boolean readSucces = false;
//				if(DEBUG_STATE){
//					cam.read(frame);
//					readSucces = true;
//				}
//				if(read)
//				readSucces = true;
//				if (readSucces){
//					MatOfPoint pts = new MatOfPoint(new Point(20,20), new Point(100,100), new Point(50,200));
//					LinkedList<MatOfPoint> lpts = new LinkedList<MatOfPoint>();
//					lpts.add(pts);
//					Imgproc.fillPoly(frame, lpts, new Scalar(new double[]{10,255,255}));
//					Core.normalize(frame, frame, 0, 255, Core.NORM_MINMAX);
//					frame = DetectTag.detectTag(frame);
//					frame = RGBfiltering(frame, CHANNEL_LOW, CHANNEL_HIGH);
//					frame = floodfill(frame);
//					System.out.println("Frame Obtained");
//					System.out.println("Captured Frame Width " + 
//							frame.width() + " Height " + frame.height());
					//					System.out.println(frame.dump());
//					System.out.println(frame.row(1).dump());
//					gui.getGraphics().drawImage(Mat2BufferedImage(frame), 1, 1, null);
					//    	    		Highgui.imwrite("camera.jpg", frame);
//					System.out.println("OK");
//					break;
//				}
//			}	
//		}
//		cam.release();

	}

	public void delay(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Mat RGBfiltering(Mat mat_org, int channelLow, int channelHigh) {
		Mat mat_RGB = new Mat();

		ArrayList<Mat> chan = new ArrayList<Mat>();
		// split each channel into a new mat
		Core.split(mat_org, chan);

		// apply threshold to each channel
		// red channel
		Imgproc.threshold(chan.get(2), chan.get(2), channelLow, channelHigh,
				Imgproc.THRESH_TOZERO_INV);

		// green channel
		Imgproc.threshold(chan.get(1), chan.get(1), channelLow, channelHigh,
				Imgproc.THRESH_TOZERO_INV);

		// blue channel
		Imgproc.threshold(chan.get(0), chan.get(0), channelLow, channelHigh,
				Imgproc.THRESH_TOZERO_INV);

		// merge the thresholded channels
		Core.merge(chan, mat_RGB);

		return mat_RGB;
	}
	
	private synchronized Mat BufferedImage2Mat(BufferedImage image){
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
		mat.put(0, 0, targetPixels);
		return mat;
	}
	private synchronized BufferedImage Mat2BufferedImage(Mat m) {
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if ( m.channels() > 1 ) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}

		int bufferSize = m.channels() * m.cols() * m.rows();
		byte [] b = new byte[bufferSize];
		m.get(0,0,b); // get all the pixels
		BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);  

		return image;
	}


}
