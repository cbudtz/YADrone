package area51.drone.opencv.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import static org.opencv.videoio.Videoio.*;
import static org.opencv.imgproc.Imgproc.*;
import static org.opencv.video.Video.*;
import static org.opencv.core.CvType.*;
import static org.opencv.imgcodecs.Imgcodecs.*;
import static org.opencv.utils.Converters.*;
import static org.opencv.imgproc.Subdiv2D.*;
import static org.opencv.utils.Converters.*;


public class DetectTag {

	public static Mat detectTag(Mat mat){
		Mat img_gray = new Mat();         		
		cvtColor(mat, img_gray, COLOR_BGR2GRAY);
		blur(img_gray, img_gray, new Size(5,5));
		
		//Find vertical lines. Car plates have high density of vertical lines
		Mat img_sobel = new Mat();
		Sobel(img_gray, img_sobel, CV_8U, 1, 0, 3, 1, 0);
		
		//threshold image
		Mat img_threshold = new Mat();
		threshold (img_sobel, img_threshold, 0, 255,THRESH_OTSU+THRESH_BINARY); // CV_THRESH_OTSU == THRESH_OTSU, CV_THRESH_BINARY == THRESH_BINARY
		
		Mat element = getStructuringElement(MORPH_RECT, new Size(17, 3));
		
		morphologyEx(img_threshold, img_threshold, MORPH_CLOSE, element); // CV_MOP_CLOSE == MORPH_CLOSE
		
		
		//Find contours of possibles plates
		ArrayList< MatOfPoint > contours = new ArrayList<MatOfPoint>();
		
		findContours(img_threshold, contours, new Mat(), // a vector of contours
				RETR_EXTERNAL, // retrieve the external contours CV_RETR_EXTERNAL == RETR_EXTERNAL
				CHAIN_APPROX_NONE); // all pixels of each contour CV_CHAIN_APPROX_NONE = CHAIN_APPROX_NONE
		
		//Start to iterate to each contour found
		Iterator<MatOfPoint> itc = contours.iterator();
		ArrayList<RotatedRect> rects = new ArrayList<RotatedRect>();
		MatOfPoint rectss = new MatOfPoint();
//		rectss.
		while(itc.hasNext()){
			
			MatOfPoint cur_mat = itc.next();
			RotatedRect mr = minAreaRect(new MatOfPoint2f(cur_mat.toArray()));
			if(!verifySizes(mr)){
				contours.remove(itc);
			}else{
				rects.add(mr);
			}
		}
		

		return img_threshold;
		
		
	}
	
	public static void floodFill(ArrayList<MatOfPoint> rects ){
		for(int i=0; i< rects.size(); i++){
			//For better rect cropping for each possible box
			//Make floodfill algorithm because the plate has white background
			//And then we can retrieve more clearly the contour box
			Mat result = new Mat();
			circle(result, rects.get(i)., 3, new Scalar(0,255,0), -1);
			//get the min size between width and height
			float minSize=(rects[i].size.width < rects[i].size.height)?
			rects[i].size.width:rects[i].size.height;
			minSize=minSize-minSize*0.5;
			//initialize rand and get 5 points around center for floodfill
			algorithm
			srand ( time(NULL) );
			//Initialize floodfill parameters and variables
			Mat mask;
			mask.create(input.rows + 2, input.cols + 2, CV_8UC1);
			mask= Scalar::all(0);
			int loDiff = 30;
			int upDiff = 30;
			int connectivity = 4;
			int newMaskVal = 255;
			int NumSeeds = 10;
			Rect ccomp;
			int flags = connectivity + (newMaskVal << 8 ) +
			CV_FLOODFILL_FIXED_RANGE + CV_FLOODFILL_MASK_ONLY;
			for(int j=0; j<NumSeeds; j++){
			Point seed;
			seed.x=rects[i].center.x+rand()%(int)minSize-(minSize/2);
			seed.y=rects[i].center.y+rand()%(int)minSize-(minSize/2);
			circle(result, seed, 1, Scalar(0,255,255), -1);
			int area = floodFill(input, mask, seed, Scalar(255,0,0), &ccomp,
			Scalar(loDiff, loDiff, loDiff), Scalar(upDiff, upDiff, upDiff),
			flags);
			}
	}
	
	public static boolean verifySizes(RotatedRect candidate ){
		float error=(float) 0.4;
		//Spain car plate size: 52x11 aspect 4,7272
		float aspect=(float) 4.7272;
		//Set a min and max area. All other patches are discarded
		int min= (int) (15*aspect*15); // minimum area
		int max= (int) (125*aspect*125); // maximum area
		//Get only patches that match to a respect ratio.
		float rmin= aspect-aspect*error;
		float rmax= aspect+aspect*error;
		int area= (int) (candidate.size.height * candidate.size.width);
		float r= (float)candidate.size.width / (float)candidate.size.height;
		if(r<1)
		r= 1/r;
		if(( area < min || area > max ) || ( r < rmin || r > rmax )){
		return false;
		}else{
		return true;
		}
		}
	private Mat floodfill(Mat mat){
		Mat mat_process = new Mat();
		Mat mat_floodfill = new Mat(mat.rows() + 2, mat.cols() + 2,
				CvType.CV_8UC1);
		int pixelsToMask = 50;
		Point pt1 = new Point(mat.cols() / 2 - pixelsToMask, mat.rows()
				/ 2 - pixelsToMask);
		Point pt2 = new Point(mat.cols() / 2 + pixelsToMask, mat.rows()
				/ 2 + pixelsToMask);

		// apply contrast shift
		mat.convertTo(mat_process, -1, CONTRAST_ALPHA, CONTRAST_BETA);

		// convert to gray scale
		Imgproc.cvtColor(mat_process, mat_process, Imgproc.COLOR_BGR2GRAY);

		Rect rect = null;
		int connectivity = 4;
		int newMaskVal = 255;
		int flags = connectivity + (newMaskVal << 8)
				+ Imgproc.FLOODFILL_MASK_ONLY;

		// apply floodfill - result is the mask / only the floodfilled part
		Imgproc.floodFill(mat_process, mat_floodfill, pt1, new Scalar(255),
				rect, new Scalar(255), new Scalar(0), flags);
		return mat_floodfill;
	}
}
