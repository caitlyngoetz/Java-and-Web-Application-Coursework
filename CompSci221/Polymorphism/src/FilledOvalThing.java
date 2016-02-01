import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class FilledOvalThing extends OvalThing {
	public FilledOvalThing(int x, int y, int w, int h) {
		super(x, y, w, h);
	

		
	}
	public void draw (Graphics g){
		Color fillColor;
		Random rand = new Random();
		fillColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g.setColor(fillColor);
		g.fillOval(x, y, w, h);
		g.setColor(color);
		g.drawOval(x, y, w, h);
	}

}
