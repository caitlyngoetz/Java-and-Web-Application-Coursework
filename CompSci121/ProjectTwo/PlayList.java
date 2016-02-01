import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * 
 * @author cgoetz
 *Program makes a library of songs and orders them by playtime
 */
public class PlayList {
	/**
	 * Program makes song objects and orders them by playtime seconds
	 * 
	 */
	public static void main(String[] args) {
		//Song 1
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the title: ");
		String title = scan.nextLine();
		System.out.println("Enter the artist: ");
		String artist = scan.nextLine();
		System.out.println("Enter the play time: ");
		String x = scan.nextLine();
		int colon = x.indexOf(":");
		String minutes = x.substring(0, colon);
		String seconds = x.substring(colon + 1, x.length());
		int y = Integer.parseInt(minutes);
		int z = Integer.parseInt(seconds);
		int secondsOfMinutes = y * 60;
		System.out.println("Enter the file name: ");
		String fileName = scan.nextLine();
		int playTime = secondsOfMinutes + z;
		
		//Song 2
		System.out.println("Enter the title: ");
		String title2 = scan.nextLine();
		System.out.println("Enter the artist: ");
		String artist2 = scan.nextLine();
		System.out.println("Enter the play time: ");
		String x2 = scan.nextLine();
		int colon2 = x2.indexOf(":");
		String minutes2 = x2.substring(0, colon2);
		String seconds2 = x2.substring(colon2 + 1, x2.length());
		int y2 = Integer.parseInt(minutes2);
		int z2 = Integer.parseInt(seconds2);
		int secondsOfMinutes2 = y2 * 60;
		System.out.println("Enter the file name: ");
		String fileName2 = scan.nextLine();
		int playTime2 = secondsOfMinutes2 + z2;
	
		//Song 3
		System.out.println("Enter the title: ");
		String title3 = scan.nextLine();
		System.out.println("Enter the artist: ");
		String artist3 = scan.nextLine();
		System.out.println("Enter the play time: ");
		String x3 = scan.nextLine();
		int colon3 = x3.indexOf(":");
		String minutes3 = x3.substring(0, colon3);
		String seconds3 = x3.substring(colon3 + 1, x3.length());
		int y3 = Integer.parseInt(minutes3);
		int z3 = Integer.parseInt(seconds3);
		int secondsOfMinutes3 = y3 * 60;
		System.out.println("Enter the file name: ");
		String fileName3 = scan.nextLine();
		int playTime3 = secondsOfMinutes3 + z3;
		
		//Creates the Song objects
		Song s1, s2, s3;

			s1 = new Song(title, artist, playTime, fileName);
			
			s2 = new Song(title2, artist2, playTime2, fileName2);
			
			s3 = new Song(title3, artist3, playTime3, fileName3);
	
		//Finds the average and formats it to two decimals
		DecimalFormat formatter = new DecimalFormat("###.00");
		double averagePlayTime = (playTime + playTime2 + playTime3) / 3.0;
		String averageX = formatter.format(averagePlayTime); 
		System.out.println("Average playtime: " + averageX);
		
		//Finds the song closest to 4 minutes
		int p1 = Math.abs(240 - playTime);
		int p2 = Math.abs(240 - playTime2);
		int p3 = Math.abs(240 - playTime3);
		
		if (p1 < p2 && p1 < p3) {
			System.out.println("Song with playtime closest to 240 secs is: " + title);
		}else if (p2 < p1 && p2 < p3) {
			System.out.println("Song with playtime closest to 240 secs is: " + title2);
		}else{ System.out.println("Song with playtime closest to 240 secs is: " + title3);		
		}
		//Makes the table
		System.out.println("==============================================================================");
		System.out.println("Title                Artist               Filename                    Playtime");
		System.out.println("==============================================================================");
		
		//Figures out what order to display the songs in
		if (s1.getPlayTime() <= s2.getPlayTime() && s2.getPlayTime() <= s3.getPlayTime()) {
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
		}else if (s1.getPlayTime()<= s3.getPlayTime() && s3.getPlayTime() <= s2.getPlayTime()) {
			System.out.println(s1);
			System.out.println(s3);
			System.out.println(s2);
		}else if (s2.getPlayTime()<= s1.getPlayTime() && s1.getPlayTime() <= s3.getPlayTime()) {
			System.out.println(s2);
			System.out.println(s1);
			System.out.println(s3);
		}else if (s2.getPlayTime()<= s3.getPlayTime() && s3.getPlayTime() <= s1.getPlayTime()) {
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s1);
		}else if (s3.getPlayTime()<= s1.getPlayTime() && s1.getPlayTime() <= s2.getPlayTime()) {
			System.out.println(s3);
			System.out.println(s1);
			System.out.println(s2);
		}else { System.out.println(s3);
				System.out.println(s2);
				System.out.println(s1);
		}
		//Finishes off the table
		System.out.println("==============================================================================");
		scan.close();
	}
	
	
}
		
	

