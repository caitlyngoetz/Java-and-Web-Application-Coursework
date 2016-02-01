import java.util.Scanner;

public class Moody {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int x = 9;
		while(x != 0) {
		System.out.println("Please choose your current mood by number or 0 to exit:");
		for(Mood mood: Mood.values())
		{
			System.out.println((mood.ordinal()+1) + ")" + "  " + mood);
	}
		x = keyboard.nextInt();
		switch (x) {
		case 1: System.out.println("I love life.");
				break;
		case 2: System.out.println("I need a tissue.");
				break;
		case 3: System.out.println("I can't believe it!");
				break;
		case 4: System.out.println("You drive me up the hall!");
				break;
		case 5: System.out.println("Are we there yet?");
				break;
		case 6: System.out.println("Why do I have to do this?!?!?!?");
				break;
		case 0: System.out.println("Thanks for playing!  See ya later, alligator!");
				break;
		default: System.out.println("Not a valid number");
		}
	}
	}
}
