package dtu.cdio.tutorial.listeners;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import de.yadrone.base.navdata.HDVideoStreamData;
import de.yadrone.base.navdata.VideoListener;
import de.yadrone.base.navdata.VideoStreamData;
import de.yadrone.base.video.ImageListener;
import dtu.cdio.tutorial.gui.DroneVariablesGUI;

public class VideoListenerImpl implements ImageListener {

	private DroneVariablesGUI gui;
	private boolean showRawImg = true;
	private boolean frameSizeSet = false;
	public VideoListenerImpl(DroneVariablesGUI gui, boolean showRawImg) {
		System.out.println("loading openCV native library...");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("loading complete");
		this.gui = gui;
		this.showRawImg = showRawImg;
		if(gui != null) {
			gui.addListenerName("video listener");
			gui.showVideoFeed();
		}
	}
	
	@Override
	public void imageUpdated(BufferedImage image) {
		
		if(showRawImg){
			if(!frameSizeSet) gui.setVideoFrameSize(image.getWidth(), image.getHeight());
			gui.setImage(image);
		}
		processImage(BufferedImage2Mat(image));
	}
	
	private synchronized void processImage(Mat rawImg){
		ArrayList<MatOfPoint> lines = new ArrayList<MatOfPoint>();
		MatOfPoint line1 = new MatOfPoint(new Point(rawImg.cols()/2 -20, rawImg.rows()/2), new Point(rawImg.cols()/2+20, rawImg.rows()/2));
		MatOfPoint line2 = new MatOfPoint(new Point(rawImg.cols()/2, rawImg.rows()/2-20), new Point(rawImg.cols()/2, rawImg.rows()/2+20));
		lines.add(line2);
		lines.add(line1);
		Imgproc.drawContours(rawImg, lines, 1, new Scalar(0,255,0), 5);
		if(!showRawImg) gui.setImage(Mat2BufferedImage(rawImg));
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
