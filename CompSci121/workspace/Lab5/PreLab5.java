import java.util.Scanner;

public class PreLab5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input integer: ");
		int i = scan.nextInt();
		int max = 0;
		while (i >= 0) {
			if (i > max)
				max = i;

			System.out.println("Input another integer: ");
			i = scan.nextInt();
		}
		System.out.println("The largest integer was " + max);

	}
}
