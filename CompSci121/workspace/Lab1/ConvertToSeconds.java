import java.util.Scanner;

/** Takes entered hours, minutes and seconds and converts them into seconds.
 * @author cgoetz
 *
 */
public class ConvertToSeconds {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter hours: ");
		int hours = scan.nextInt();
		System.out.print("Enter minutes: ");
		int minutes = scan.nextInt();
		System.out.print("Enter seconds: ");
		int seconds = scan.nextInt();

		int secondsOfHours = hours * 60 * 60;
		int secondsOfMinutes = minutes * 60;
		int total = secondsOfHours + secondsOfMinutes + seconds;
		
		System.out.println("Total Number of Seconds: " + total);
		
		scan.close();	

	}

}
