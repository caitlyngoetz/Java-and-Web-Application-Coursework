
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Partial class for lab exercise using Random, Math and Color classes to draw
 * random color blobs.
 * 
 * @author mvail, amit
 */

public class ColorBlobs extends JPanel
{
	private final int TIMER_DELAY = 500; // milliseconds
	private final int MIN = 4;
	private Random rand;

	// Note: no other instance variables are necessary for this project

	/**
	 * Initialize the ColorBlobs class.
	 */
	public ColorBlobs()
	{
		// Note: no modifications to this method are necessary for this project
		rand = new Random();
		setBackground(Color.black);
		startAnimation();
		setPreferredSize(new Dimension(600, 600));
	}

	/**
	 * This method draws on the panel. It is called periodically by the
	 * animation thread.
	 */
	public void paintComponent(Graphics page)
	{
		//super.paintComponent(page);

		int width = getWidth(); // width of the drawing panel
		int height = getHeight(); // height of the drawing panel
	

		// TODO: Now you fill in the rest
		int ovalWidth = rand.nextInt(width/2-width/30)+width/30;
		int ovalHeight = rand.nextInt(height/2-height/30)+height/30;
		int x = rand.nextInt(width);
		int y = rand.nextInt(height);
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		
		page.setColor(new Color(red, green, blue));
		page.fillOval(ovalWidth, ovalHeight, x, y);
		
		
		
		
		
		

	}

	/**
	 * The main method that starts up the application. DO NOT MODIFY.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Color Blobs");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ColorBlobs());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Create an animation thread that runs periodically DO NOT MODIFY
	 */
	private void startAnimation()
	{
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				repaint(); // redraw the panel
			}
		};
		new Timer(TIMER_DELAY, taskPerformer).start();
	}

}
