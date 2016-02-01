//Made by Caitlyn Goetz
public class Cylinder {
	//instance variables
	private double myRadius;
	private double myHeight;
	
	//constructor
	public Cylinder (double r, double h){
		myRadius = r;
		myHeight = h;
	}
	
	//volume formula
	public double volume(){
		return Math.PI * Math.pow(myRadius, 2) * myHeight;
	}

	//Surface area	
	public double area(){
		return 2 * Math.PI * Math.pow(myRadius, 2) + 2 * Math.PI * myRadius * myHeight;
	}
}
