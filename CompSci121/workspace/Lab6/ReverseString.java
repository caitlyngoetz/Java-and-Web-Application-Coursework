import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = keyboard.nextLine();
		String copy = "";
		for(int i = (str.length()-1); i >= 0; i--)
		{
			copy += str.charAt(i);
		}
		System.out.println(copy);
	}

}
