import java.util.Scanner;

/** Takes entered seconds and converts them to hours, minutes and seconds.  Then it take it and converts it to a fraction.
 * @author cgoetz
 *
 */
public class ConvertToHours {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Insert Number of Seconds: ");
		int begin = scan.nextInt();
		int hours = begin / 3600;
		System.out.println(hours);
		int minutes = (begin / 60)%60;
		System.out.println(minutes);
		int seconds = begin%60;
		System.out.println(seconds);
		double fractionalHours = (double) begin / 3600;
		System.out.println("Fractional Hours: " + fractionalHours);
		
		scan.close();

	}

}
