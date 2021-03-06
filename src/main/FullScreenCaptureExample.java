package main;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class FullScreenCaptureExample implements Runnable {

    //public static ArrayList image = new ArrayList();
    private static String str = null; // Ten file 
    // Hàm chup ảnh lại màng hình.
    public static void capTureScreen() {
        try {
            Robot robot = new Robot(); // Tạo đối tượng class robot.(để làm gì thì không biết)
            String format = "jpg";
	    // Đường dẫn chính thức.
            //D://SangB1699999//New folder//New folder (4)//New folder (3)//New folder (2)//New folder//
            
			str = currentTime.takeTime(); // take current time to make name file
			// secondary path.
            String path = "D://SangB1699999//" +str+ ".jpg"; // Chuổi lưu đương dẫn lưu file ảnh
            // take screen size to capture
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); // Lấy full màng hình.
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect); // save in bufferd Image to write in file object 
            //File file = new File(fileName);
            ImageIO.write(screenFullImage, format, new File(path)); // initialize File object to write
            System.out.println("A full screenshot saved: ");
        } catch (AWTException | IOException ex) {
            System.err.println(ex.toString());
            //System.out.println("le quang sang");
        }
    }

    public static void main(String[] args) {
        // to do something here
    }

    @Override // override run fuction from Thread object
    public void run() {
        while (true) {
                capTureScreen(); // screen capture after 10s. when user clicked
                try {
                    Thread.sleep(30000); // is 10s
                } catch (InterruptedException ex) {
                    Logger.getLogger(FullScreenCaptureExample.class.getName()).log(Level.SEVERE, null, ex); // i don't know what is it expception
                }
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
