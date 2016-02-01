//
//BouncyBall.java
//
//Example using Random and conditional statements
//COMPSCI 121
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animated program with a ball bouncing off the program boundaries
 * 
 * @author mvail
 */
public class BouncyBall extends JPanel {
	private final int INIT_WIDTH = 600;
	private final int INIT_HEIGHT = 400;
	private final int DELAY = 100; // milliseconds between Timer events
	private Random rand; // random number generator
	private int x, y; // anchor point coordinates
	private int xDelta, yDelta; // change in x and y from one step to the next
	private final int DELTA_RANGE = 20; // range for xDelta and yDelta
	private int RADIUS; // circle radius
	int red, green, blue, redDelta, greenDelta, blueDelta, radiusDelta;

	/**
	 * Draws a filled oval with random color and dimensions.
	 * 
	 * @param g
	 *            Graphics context
	 * @return none
	 */
	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		// clear canvas
		//g.setColor(getBackground());
		//g.fillRect(0, 0, width, height);
		RADIUS += radiusDelta;
		if (RADIUS >= INIT_WIDTH/10) {
			RADIUS = INIT_WIDTH/10;
			radiusDelta *= -1;
		}
		if (RADIUS <= 20) {
			RADIUS = 20;
			radiusDelta *= -1;
		}

		// CALCULATE NEW X
		x += xDelta;
		if (x >= width - RADIUS) {
			x = width - RADIUS;
			xDelta *= -1;
		}
		if (x <= RADIUS) {
			x = RADIUS;
			xDelta *= -1;
		}
		// TODO: needs more to stay in-bounds

		// CALCULATE NEW Y
		y += yDelta;
		if (y >= height - RADIUS) {
			y = height - RADIUS;
			yDelta *= -1;
		}
		if (y <= RADIUS) {
			y = RADIUS;
			yDelta *= -1;
		}
		// TODO: needs more to stay in-bounds

		// NOW PAINT THE OVAL
		red += redDelta;
		if (red <= 0) {
			red = 0;
			redDelta *= -1;
		}
		if (red >= 255) {
			red = 255;
			redDelta *= -1;
		}
		green += greenDelta;
		if (green <= 0) {
			green = 0;
			greenDelta *= -1;
		}
		if (green >= 255) {
			green = 255;
			greenDelta *= -1;
		}
		blue+= blueDelta;
		if (blue <= 0) {
			blue = 0;
			blueDelta *= -1;
		}
		if (blue >= 255) {
			blue = 255;
			blueDelta *= -1;
		}
		
		
			
		g.setColor(new Color(red, green, blue));
		g.fillOval(x - RADIUS, y - RADIUS, 2*RADIUS, 2*RADIUS);
	}

	/**
	 * Constructor for the display panel initializes necessary variables. Only
	 * called once, when the program first begins. This method also sets up a
	 * Timer that will call paint() with frequency specified by the DELAY
	 * constant.
	 */
	public BouncyBall() {
		setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
		this.setDoubleBuffered(true);
		setBackground(Color.black);

		rand = new Random(); // instance variable for reuse in paint()
		RADIUS = rand.nextInt(INIT_WIDTH/10-20)+20;
		radiusDelta = 3;

		// initial ball location within panel bounds
		// x1 = INIT_WIDTH / 2;
		// y1= INIT_HEIGHT / 2;
		x = rand.nextInt(((INIT_WIDTH - RADIUS) - RADIUS) + 1) + RADIUS;
		y = rand.nextInt(((INIT_HEIGHT - RADIUS) - RADIUS) + 1) + RADIUS;
		// TODO: replace centered starting point with a random
		// position anywhere in-bounds - the ball should never
		// extend out of bounds, so you'll need to take RADIUS
		// into account

		// deltas for x and y
		xDelta = rand.nextInt(DELTA_RANGE) - DELTA_RANGE / 2;
		yDelta = rand.nextInt(DELTA_RANGE) - DELTA_RANGE / 2;
		// TODO: replace with random deltas from -DELTA_RANGE/2
		// to +DELTA_RANGE/2
		
		//random colors
		red = rand.nextInt(256);
		green = rand.nextInt(256);
		blue = rand.nextInt(256);
		redDelta = 10;
		greenDelta = 15;
		blueDelta = 20;

		// Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically DO NOT MODIFY
	 */
	private void startAnimation() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};
		new Timer(DELAY, taskPerformer).start();
	}

	/**
	 * Starting point for the BouncyBall program DO NOT MODIFY
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bouncy Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BouncyBall());
		frame.pack();
		frame.setVisible(true);
	}

}
