import java.text.DecimalFormat;

public class Box {

		//instance variables
		private double height;
		private double width;
		private double depth;
		private boolean full;
		DecimalFormat formatter = new DecimalFormat("####.00");
		
		//constructor
		public Box (double h, double w, double d) {
			height = h;
			width = w;
			depth = d;
			full= false;
			
		}
		//Getters and Setters
		public double getHeight() {
			return height;
		}
		
		public void setHeight(double height) {
			this.height = height;
		}
		
		public double getWidth() {
			return width;
		}
		
		public void setWidth(double width) {
			this.width = width;
		}
		
		public double getDepth() {
			return depth;
		}
		
		public void setDepth(double depth) {
			this.depth = depth;
		}
		
		public boolean getFull() {
			return full;
		}
		
		public void setFull(boolean full) {
			this.full = full;
		}
		
		//Volume Formula
		public double volume() {
			return height * width * depth;
		}
		
		//Surface Area Formula
		public double surfaceArea() { 
			return 2 * (height * width) + 2 * (height * depth) + 
					2 * (width + depth);
		}
		//toString method
		public String toString() {
			return "The dimensions are (" + this.height + "X" + this.width
					+ "X" + this.depth + ") and the box is " + this.full;
		}
}
		

	


