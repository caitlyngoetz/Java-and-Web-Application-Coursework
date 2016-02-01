import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


/**
 * A thing that can be painted on a given Graphics object.
 * 
 * @author mvail
 */
public abstract class PaintableThing {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected Color color;
	
	public PaintableThing(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		Random rand = new Random ();
		color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}
	
	/**
	 * Draws this thing on the given Graphics object.
	 * @param g Graphics context on which to draw
	 */
	public abstract void draw(Graphics g);
}