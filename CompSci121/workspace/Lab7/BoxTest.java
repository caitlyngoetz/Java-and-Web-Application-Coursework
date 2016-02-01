
public class BoxTest {

	public static void main(String[] args) {
		Box b = new Box(5.0, 4.0, 2.0);
		
		System.out.println("Dimensions of 1st box are ");
		System.out.println(b);
		
		
		Box b2 = new Box(1,1,1);
		b2.setHeight(10);;
		b2.setWidth(20);
		b2.setDepth(4);;
		System.out.println("Dimensions of new box are Depth: " + b2.getDepth() + " Width: " + b2.getWidth() + " Height is: " +b2.getHeight());
		System.out.println("Area of 1st box is "+ b.surfaceArea());
		System.out.println("Area of 2nd box is " + b2.surfaceArea());
		System.out.println("Vlume of 1st box is " + b.volume());
		System.out.println("Volume of 2nd box is " + b2.volume());
	}
}