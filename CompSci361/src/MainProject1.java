import java.io.File;
import java.util.Scanner;

public class MainProject1 {
	public static void main(String[] args) {
		File file;
		Scanner scan;
		try{
			file = new File(args[0]);
			scan = new Scanner(file);
			RegEx regex = new RegEx(scan.nextLine());
			
			while(scan.hasNext()){
				String testString = scan.nextLine();
				if(testString.equals("quit")) break;

				System.out.println(regex.validateString(testString) ? "yes" : "no");
			}
		}
		catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}
}
