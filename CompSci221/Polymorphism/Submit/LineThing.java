import java.awt.Graphics;


public class LineThing extends PaintableThing {
	public LineThing(int x, int y, int w, int h){
		super(x,y,w,h);
	}
public void draw (Graphics g){
	g.setColor(color);
	g.drawLine(x, y, w, h);
}
}
