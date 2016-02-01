import java.util.Scanner;
import java.text.DecimalFormat;

public class MyNameIs {

	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your first name: ");
		String firstName = keyboard.next();
		System.out.println("Please ener your last name: ");
		String lastName = keyboard.next();
		System.out.println("Please enter a number: ");
		double num1 = keyboard.nextDouble();
		System.out.println("Please enter a number between 0 and  1: ");
		double num2 = keyboard.nextDouble();  
		double per = (num2 *100);
		double x = num1 * num2;
		DecimalFormat formatter1 = new DecimalFormat("0.##");
		formatter1.format(x);
		double y = Math.pow(num1, num2);
		
		
		
		System.out.println("Hi, my name is " + firstName + " " + lastName + ".");
		System.out.println("You'll find me under \"" + lastName + ", " + firstName
				+ ".\"");
		System.out.println("I'd like my Mathletes badge to read: \"" 
				+ firstName.charAt(0) + ". " + lastName + ".\"");
		System.out.println("I know that " + per + "% of " + num1 + " is " 
				+ formatter1.format(x) + "." );
		System.out.println("I also know that " + num1 + " raised to the power of " 
				+ num2 + " is " + formatter1.format(y) + ".");
		
		keyboard.close();
		
		

	}

}
