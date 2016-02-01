import java.awt.Graphics;


public class SquareThing extends PaintableThing {
	public SquareThing(int x, int y, int w, int h){
		super(x, y, w, h);
	}
public void draw (Graphics g){
	g.setColor(color);
	g.drawOval(x, y, w, h);
}
}
