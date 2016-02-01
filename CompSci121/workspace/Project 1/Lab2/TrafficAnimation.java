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
 * Animates a [put your description here]
 * @author [put your name here]
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
	private int x = 0;
	//pixels added to x each time paintComponent() is called
	private int stepSize = 10;
	
	/* This method draws on the applet's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics canvas) 
	{
		//clears the previous image
		//super.paintComponent(canvas);
		
		//account for changes to window size
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		//Fill the canvas with the background color
		canvas.setColor(getBackground());
		canvas.fillRect(0, 0, width, height);
    	
		//Calculate the new position
		x = (x + stepSize) % width;
    	
		//Draw new square
		//TODO: replace this square with your drawing
		int squareSide = height/5;
		int y = height/2 - squareSide/2;
		canvas.setColor(Color.green);
		canvas.fillRect(x, y, squareSide, squareSide);
		 
		//Draw and color wheels
		canvas.setColor(Color.blue);
		canvas.fillOval(x, y+squareSide,squareSide/3, squareSide/3);
		
		canvas.setColor(Color.blue);
		canvas.fillOval(x+2*squareSide/3, y+squareSide, squareSide/3, squareSide/3);
		
		//Write title
        String str = "Look out!!!";
        int titleSize = width / 8;

        canvas.setFont(new Font("Serif", Font.BOLD, titleSize));    
        FontMetrics metrics = canvas.getFontMetrics();         // Get Font's metrics

        Dimension d = getSize();                          // Get the frame's size

        setBackground(Color.black);
        canvas.setColor(Color.yellow);

        int a = (d.width - metrics.stringWidth(str)) / 2; // Calculate coordinates
        int b = (d.height + metrics.getHeight()) / 4;

        canvas.drawString(str, a, b);                          // Draw the string
        
        //Draw head
        int c = width / 2;
        int f = 3 * height /4;
        int headSizeY = height/16;
        int headSizeX = width/24;
        
        canvas.setColor(Color.red);
        canvas.fillOval(c, f, headSizeX, headSizeY);
        
        //Draw body
        int g = width / 2;
        int h = 13 * height /16;
        int bodySizeX = 2 * width/24;
        int bodySizeY = 2 * height/16;
        
        canvas.setColor(Color.red);
        canvas.fillRect(g, h, bodySizeX, bodySizeY);
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