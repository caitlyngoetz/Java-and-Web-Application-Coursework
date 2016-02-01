//Driver meathod
public class CylinderDriver {

	//assigns numbers to radius and height and tells program to say the volume and area
	public static void main(String[] args) {
		Cylinder c = new Cylinder(2.0, 4.0);
		
		System.out.println("Volume = " + c.volume() + " centimeters cubed");
		
		System.out.println("Surface area = " + c.area() + " square inches");
	}

}
