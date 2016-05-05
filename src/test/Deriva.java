package test;

import java.io.IOException;

import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvGetSize;
import static org.bytedeco.javacpp.opencv_highgui.cvNamedWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_core.CvPoint;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_highgui.*;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;

/**
 * Created by edominguez on 4/5/16.
 */
public class Deriva {

    public static void main(String[] args) throws IOException {
        IplImage img = cvLoadImage("./resources/Night_stars_berlin.png");
        IplImage gry = img;
        //A gris
//        IplImage gry = cvCreateImage(cvGetSize(img), img.depth(), 1);
//        cvCvtColor(img, gry, CV_BGR2GRAY);

        //Threshold
//        cvAdaptiveThreshold(gry, gry, 255, CV_ADAPTIVE_THRESH_MEAN_C, CV_THRESH_BINARY_INV, 5, 4);
        cvThreshold(gry, gry, 250, 255, CV_THRESH_BINARY);


        //Muestro lineas del "reticulado"
        CvPoint p0 = new CvPoint(gry.width() / 2, gry.height() / 2);
        CvPoint p1 = new CvPoint(0, gry.height() / 2);
        CvPoint p2 = new CvPoint(gry.width(), gry.height() / 2);
        CvPoint p3 = new CvPoint(gry.width() / 2, 0);
        CvPoint p4 = new CvPoint(gry.width() / 2, gry.height());

        cvLine(gry, p1, p2, opencv_core.CvScalar.RED, 1, CV_AA, 0);
        cvLine(gry, p3, p4, opencv_core.CvScalar.RED, 1, CV_AA, 0);

        int radius = gry.height() / 10;
        cvCircle(gry, p0, radius, opencv_core.CvScalar.RED);

        //Muestro imgaen?
//        cvNamedWindow("image", CV_WINDOW_AUTOSIZE);
//        cvShowImage("image", gry);
//        cvWaitKey(0);

        //Guardo Imagen
        cvSaveImage("./resources/gris.jpg", gry);

    }


}
