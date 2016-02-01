/* 
 * TrafficAnimation.java 
 * COMPSCI121 Project 1: Traffic Animation
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animates a car to travel through a lane around the page
 * @cgoetz
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel {
	//Note: This is where you declare constants and variables that
	//	need to keep their values between calls	to paintComponent().
	//	Any other variables should be declared locally, in the
	//	method where they are used.

	//constant to regulate the frequency of Timer events
	// Note: 100ms is 10 frames per second - you should not need
	// a faster refresh rate than this
	private final int DELAY = 100; //milliseconds
	//anchor coordinate for drawing / animating
	private int x = -150;
	//pixels added to x each time paintComponent() is called
	private int stepSize = 10;
	
	/** This method draws on the applet's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 */
	public void paintComponent(Graphics canvas) 
	{
		//clears the previous image
		//super.paintComponent(canvas);
		
		//account for changes to window size
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		//Fill the canvas with the background color
		canvas.setColor(new Color(34, 139, 34));
		canvas.fillRect(0, 0, width, height);
		canvas.setColor(new Color(169, 169, 169));
		canvas.fillRect(0, height/4, width, 2*height/4);
		
		//Draws lines on road
		canvas.setColor(Color.yellow);
		canvas.drawRect(0, height/2, width, height/42);
		
    	
		//Calculate the new position
		x = (x + stepSize) % (width + 300);
		
		//Draws "car" for semi
		int squareSide = height/5;
		int y = height/2 - squareSide/2;
		canvas.setColor(new Color(30, 144, 255));
		canvas.fillRect(x, y, squareSide, squareSide);
		
		//Draw and color side window for semi
		canvas.setColor(Color.black);
		canvas.fillRect(x+2*squareSide/3, y, squareSide/3, squareSide/2);
		 
		//Draw and color wheels for semi
		canvas.setColor(Color.black);
		canvas.fillOval(x, y+squareSide,squareSide/3, squareSide/3);
		
		canvas.setColor(Color.black);
		canvas.fillOval(x+2*squareSide/3, y+squareSide, squareSide/3, squareSide/3);
		
		//Draw door handle on "car" of semi
		canvas.setColor(Color.black);
		canvas.drawRect(x+2*squareSide/3, y+2*squareSide/3, squareSide/12, squareSide/9);
		
		//Draw trailer on semi
		canvas.setColor(new Color(0, 191, 255));
		canvas.fillRect(x-3*squareSide, y, 6*squareSide/2, squareSide);
		
		//Draw wheels on trailer
		canvas.setColor(Color.black);
		canvas.fillOval(x-3*squareSide, y+squareSide, squareSide/3, squareSide/3);
		
		//Write title
        String str = "Look out!!!";
        int titleSize = width / 8;

        canvas.setFont(new Font("Serif", Font.BOLD, titleSize));    
        FontMetrics metrics = canvas.getFontMetrics();         // Get Font's metrics

        Dimension d = getSize();                          // Get the frame's size

        setBackground(Color.black);
        canvas.setColor(Color.orange);

        int a = (d.width - metrics.stringWidth(str)) / 2; // Calculate coordinates
        int b = (d.height + metrics.getHeight()) / 6;

        canvas.drawString(str, a, b);                          // Draw the string
        
        //Draw head
        int c = 4*width / 9;
        int f = 3 * height /4;
        int headSizeY = height/6;
        int headSizeX = width/6;
        
        canvas.setColor(new Color(255, 140, 0));
        canvas.fillOval(c, f, headSizeX, headSizeY);
        
        //Draw eyes
        int m = 11*width / 24;
        int n = 13*height / 16;
        int eyeSizeX = width/24;
        int eyeSizeY = height/16;
        
        int m2 = width/2;
        int n2 = 13*height / 16;
        
       canvas.setColor(new Color(0, 0, 139));
        canvas.fillOval(m, n, eyeSizeX, eyeSizeY);
        
        canvas.setColor(new Color(0, 0, 139));
        canvas.fillOval(m2, n2, eyeSizeX, eyeSizeY);
        
        //Draw nose
        int j = 11*width / 24;
        int k = 14*height / 16;
        int noseSizeX = 2*width/24;
        int noseSizeY= 2*height/16;
        canvas.setColor( new Color(0, 0, 139));
        canvas.fillArc(j, k, noseSizeX, noseSizeY, 30, 30);
        
      
	}

	/**
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 * This method also sets up a Timer that will call
	 * paint() with frequency specified by the DELAY
	 * constant.
	 */
	public TrafficAnimation() 
	{
		setBackground(Color.black);
		//Do not initialize larger than 800x600
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);
		
		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/////////////////////////////////////////////
	// DO NOT MODIFY main() or startAnimation()
	/////////////////////////////////////////////
	
	/**
	 * Starting point for the TrafficAnimation program
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

   /**
    * Create an animation thread that runs periodically
	* DO NOT MODIFY this method!
	*/
    private void startAnimation()
    {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                repaint();
            }
        };
        new Timer(DELAY, taskPerformer).start();
    }
}
