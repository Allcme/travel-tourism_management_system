/*Technologies Used: Core Java (Swing & AWT)
Database Used: MySQL
IDE used: Netbeans / Eclipse
*/

package learn;

import javax.swing.*; //for Jframe
import java.awt.*; //for image class

//in java multiple inheritence is allowed but with interfaces not classes 
public class Splash extends JFrame /* = class*/ implements Runnable /*= interface*/ {  //helps to open frames with swing import statement
//if u make a class as {public "abstract" class} u can't make objects then
	
	Thread thread; //Explicitily third class ka object
	
	//constructor is made and it as same name as the class name
	Splash() {
	//	setSize(1200, 600);  //building frame with (length, width) respectively
		
		//setting location to move it around screen
	//	setLocation(100, 100);  //(left, top)
		
		//image need to picked up by using an object 
		//picked up from source directory using ClassLoader
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
		
		//THIS HELPS TO SCALE THE IMAGE
		Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT); //(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		
		//converts from image to image_icon
		ImageIcon i3 = new ImageIcon(i2);
		//we can't directly use the Image into JLabel so we need to convert it 
		JLabel image = new JLabel(i3); //icon is placed
		add(image);  //image component added on frame 
		
				
		//by default frame is hidden
		setVisible(true); //frame will now visible in origin y-axis
		
		//object created for thread to run interface
		thread = new Thread(this);
		thread.start(); //used for multiheaded function
		
	}
	
	//without using abstract we need to overight the runnable interface.
	public void run() {
		try {
			Thread.sleep(7000); //closing time(7_seconds)
//			new Login();
			setVisible(false); //closing frame
			new Login();
		} catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		
		//creating the class object with which constructor is called.
		Splash frame = new Splash();
		
		//the size and location will change dinametically as we need
		int x = 1;
		for(int i = 1; i<= 560; x+=7, i+=6) {
			frame.setLocation(650 - (x + i)/2, 300  - (i/2)); // (length, width)
			frame.setSize(x + i, i);
			
			//for sleep motion
			try {
				Thread.sleep(10); //opening time (time_in_miliseconds)
			} catch (Exception e) {}
		}
		
		
	}

}
