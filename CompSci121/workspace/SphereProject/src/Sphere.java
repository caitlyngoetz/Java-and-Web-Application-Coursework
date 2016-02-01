
public class Sphere {
	//instance variable
	private double myRadius;
	
	//Constructor
	public Sphere(double r){
		myRadius = r;
	}

	//volume of Sphere
	public double volume(){
		return 4.0/3.0 * Math.PI * Math.pow(myRadius, 3.0);
	}
	
	//surface area of Sphere
	public double area(){
		return 4.0 * Math.PI * Math.pow(myRadius, 2.0);
	}
	
}

