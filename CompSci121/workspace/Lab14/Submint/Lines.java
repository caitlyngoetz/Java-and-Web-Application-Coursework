import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A self-contained animated "screen saver"-like application
 * that draws 2 connected lines. It needs refactoring to use
 * arrays before it can be realistically enhanced to support
 * more lines.
 * 
 * @author mvail
 * @author amit
 */
@SuppressWarnings("serial")
public class Lines extends JPanel implements ActionListener {
	private final int DELAY = 100; // milliseconds
	private final int COLOR_MIN = 0;
	private final int COLOR_MAX = 255;
	
	private final int LINES = 100;
	private final int POINTS = LINES + 1;
	
	//private Point p0, p1, p2;
	private Point [] p = new Point[POINTS];
	//private Point p0delta, p1delta, p2delta;
	private Point [] pDelta = new Point[POINTS];
	private int red[] = new int[LINES];
	private int green[] = new int[LINES];
	private int blue[] = new int[LINES];
	//private int red0, green0, blue0, red1, green1, blue1;
	private int rdir[] = new int[LINES];
	private int gdir[] = new int[LINES];
	private int bdir[] = new int[LINES];
	//private int rdir0, gdir0, bdir0, rdir1, gdir1, bdir1;
	private Random rand;
	private Timer timer;
	
	/**
	 * Set background color and start animation.
	 */
	public Lines() {
		int width = 600;
		int height = 600;
		setPreferredSize(new Dimension(width,height));

		setDoubleBuffered(true); //this makes the animation smoother
		setBackground(Color.black);
		
		rand = new Random();
		for(int i=0; i<p.length; i++){
			p[i] = new Point(rand.nextInt(width), rand.nextInt(height));
		}
//		p0 = new Point(rand.nextInt(width), rand.nextInt(height));
//		p1 = new Point(rand.nextInt(width), rand.nextInt(height));
//		p2 = new Point(rand.nextInt(width), rand.nextInt(height));
		for(int i = 0; i<p.length; i++){
			pDelta[i] = new Point(rand.nextInt(11) - 5, rand.nextInt(11) - 5);
		}
//		p0delta = new Point(rand.nextInt(11) - 5, rand.nextInt(11) - 5);
//		p1delta = new Point(rand.nextInt(11) - 5, rand.nextInt(11) - 5);
//		p2delta = new Point(rand.nextInt(11) - 5, rand.nextInt(11) - 5);
		
		for(int i=0; i<LINES; i++){
			red[i] = rand.nextInt(COLOR_MAX + 1);
			green[i] = rand.nextInt(COLOR_MAX + 1);
			blue[i] = rand.nextInt(COLOR_MAX + 1);
		}
		//red0 = rand.nextInt(COLOR_MAX + 1);
		//green0 = rand.nextInt(COLOR_MAX + 1);
		//blue0 = rand.nextInt(COLOR_MAX + 1);
		//red1 = rand.nextInt(COLOR_MAX + 1);
		//green1 = rand.nextInt(COLOR_MAX + 1);
		//blue1 = rand.nextInt(COLOR_MAX + 1);

		for(int i = 0; i<LINES; i++){
			rdir[i] = rand.nextInt(11) - 5;
			gdir[i] = rand.nextInt(11) - 5;
			bdir[i] = rand.nextInt(11) - 5;
		}
//		rdir0 = rand.nextInt(11) - 5;
//		gdir0 = rand.nextInt(11) - 5;
//		bdir0 = rand.nextInt(11) - 5;
//		rdir1 = rand.nextInt(11) - 5;
//		gdir1 = rand.nextInt(11) - 5;
//		bdir1 = rand.nextInt(11) - 5;
		
		timer = new Timer(DELAY, this); //this panel will also be the Timer's ActionListener
		timer.start();
	}

	/**
	 * Draw a colored line and update its position and color for the next time paint() is called.
	 * 
	 * @param g Graphics context
	 */
	public void paintComponent(Graphics g0) {
		// necessary for using setStroke()
		Graphics2D g = (Graphics2D) g0;

		// check panel dimensions in case of resizing
		int width = getWidth();
		int height = getHeight();
		
		// repaint background
		g.setColor(getBackground());
		g.fillRect(0, 0, width, height);
		
		// scale line weight according to display size
		int stroke = Math.max(1, Math.min(width, height)/100);
		g.setStroke(new BasicStroke(stroke));
		
		// draw colored line with end-points p0 and p1
//		g.setColor(new Color(red[i], green[], blue[]));
//		g.drawLine(p[0].x, p[0].y, p[1].x, p[1].y);
		for(int i = 0; i<LINES; i++){
			g.setColor(new Color(red[i], green[i], blue[i]));
			g.drawLine(p[i].x, p[i].y, p[i+1].x, p[i+1].y);
		}
		
//		// draw colored line with end-points p1 and p2
//		g.setColor(new Color(red[], green[], blue[]));
//		g.drawLine(p[1].x, p[1].y, p[2].x, p[2].y);
//		
		// update the point positions
		for(int i=0; i<p.length; i++){
			p[i].x += pDelta[i].x;
			if (p[i].x > width || p[i].x < 0) {
				pDelta[i].x *= -1;
				p[i].x = Math.min(p[i].x, width);
				p[i].x = Math.max(p[i].x, 0);
			}
			p[i].y += pDelta[i].y;
			if (p[i].y > height || p[i].y < 0) {
				pDelta[i].y *= -1;
				p[i].y = Math.min(p[i].y, height);
				p[i].y = Math.max(p[i].y, 0);
			}
		}
//		p[0].x += p0delta.x;
//		if (p[0].x > width || p[0].x < 0) {
//			p0delta.x *= -1;
//			p[0].x = Math.min(p[0].x, width);
//			p[0].x = Math.max(p[0].x, 0);
//		}
//		p[0].y += p0delta.y;
//		if (p[0].y > height || p[0].y < 0) {
//			p0delta.y *= -1;
//			p[0].y = Math.min(p[0].y, height);
//			p[0].y = Math.max(p[0].y, 0);
//		}
//		p[1].x += p1delta.x;
//		if (p[1].x > width || p[1].x < 0) {
//			p1delta.x *= -1;
//			p[1].x = Math.min(p[1].x, width);
//			p[1].x = Math.max(p[1].x, 0);
//		}
//		p[1].y += p1delta.y;
//		if (p[1].y > height || p[1].y < 0) {
//			p1delta.y *= -1;
//			p[1].y = Math.min(p[1].y, height);
//			p[1].y = Math.max(p[1].y, 0);
//		}
//		p[2].x += p2delta.x;
//		if (p[2].x > width || p[2].x < 0) {
//			p2delta.x *= -1;
//			p[2].x = Math.min(p[2].x, width);
//			p[2].x = Math.max(p[2].x, 0);
//		}
//		p[2].y += p2delta.y;
//		if (p[2].y > height || p[2].y < 0) {
//			p2delta.y *= -1;
//			p[2].y = Math.min(p[2].y, height);
//			p[2].y = Math.max(p[2].y, 0);
//		}
		
		// update the line colors
		for(int i = 0; i<LINES; i++){
			red[i] += rdir[i];
			if (red[i] > COLOR_MAX) {
				red[i] = COLOR_MAX;
				rdir[i] *= -1;
			} else if (red[i] < COLOR_MIN) {
				red[i] = COLOR_MIN;
				rdir[i] *= -1;
			}
			green[i] += gdir[i];
			if (green[i] > COLOR_MAX) {
				green[i] = COLOR_MAX;
				gdir[i] *= -1;
			} else if (green[i] < COLOR_MIN) {
				green[i] = COLOR_MIN;
				gdir[i] *= -1;
			}
			blue[i] += bdir[i];
			if (blue[i] > COLOR_MAX) {
				blue[i] = COLOR_MAX;
				bdir[i] *= -1;
			} else if (blue[i] < COLOR_MIN) {
				blue[i] = COLOR_MIN;
				bdir[i] *= -1;
			}
		}
	}
//		red[i] += rdir[i];
//		if (red[i] > COLOR_MAX) {
//			red[i] = COLOR_MAX;
//			rdir[i] *= -1;
//		} else if (red[i] < COLOR_MIN) {
//			red[i] = COLOR_MIN;
//			rdir[i] *= -1;
//		}
//		green[i] += gdir[i];
//		if (green[i] > COLOR_MAX) {
//			green[i] = COLOR_MAX;
//			gdir[i] *= -1;
//		} else if (green[i] < COLOR_MIN) {
//			green[i] = COLOR_MIN;
//			gdir[i] *= -1;
//		}
//		blue[i] += bdir[i];
//		if (blue[i] > COLOR_MAX) {
//			blue[i] = COLOR_MAX;
//			bdir[i] *= -1;
//		} else if (blue[i] < COLOR_MIN) {
//			blue[i] = COLOR_MIN;
//			bdir[i] *= -1;
//		}
//		red1 += rdir1;
//		if (red1 > COLOR_MAX) {
//			red1 = COLOR_MAX;
//			rdir1 *= -1;
//		} else if (red1 < COLOR_MIN) {
//			red1 = COLOR_MIN;
//			rdir1 *= -1;
//		}
//		green1 += gdir1;
//		if (green1 > COLOR_MAX) {
//			green1 = COLOR_MAX;
//			gdir1 *= -1;
//		} else if (green1 < COLOR_MIN) {
//			green1 = COLOR_MIN;
//			gdir1 *= -1;
//		}
//		blue1 += bdir1;
//		if (blue1 > COLOR_MAX) {
//			blue1 = COLOR_MAX;
//			bdir1 *= -1;
//		} else if (blue1 < COLOR_MIN) {
//			blue1 = COLOR_MIN;
//			bdir1 *= -1;
//		}
//	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent evt) {
		repaint();
	}	
	
	/**
	 * Creates the JFrame to hold Lines panel.
	 * @param args not used
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lines");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Lines primary = new Lines();

		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}