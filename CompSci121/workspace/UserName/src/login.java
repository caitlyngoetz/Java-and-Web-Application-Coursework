import java.util.Scanner;
public class login {

	//Caitlyn Goetz
	//compute string using first letter of first name and first five letters of last name
	
	public static void main(String[] args) {
		String firstName;
		String lastName;
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("First name: ");
		firstName = kbd.next();
		
		System.out.println("Last name: ");
		lastName = kbd.next();
		
		String firstLetter = firstName.substring(0,1);
		String firstFive = lastName.substring(0,5);
		
		System.out.println("new login:" + firstLetter + firstFive);
		kbd.close();

	}

}
