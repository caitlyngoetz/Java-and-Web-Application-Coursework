import java.util.Scanner;
public class Area {

	//Caitlyn Goetz
	//Program computes area of a rectangular room
	
	public static void main(String[] args) {
		double length;
		double width;
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("What is the length? ");
		length = kbd.nextDouble();
		
		System.out.println("What is the width? ");
		width = kbd.nextDouble();
		
		double area = length * width;
		
		System.out.println("The area of th room is " + area + "ft.");
		kbd.close();

	}

}
