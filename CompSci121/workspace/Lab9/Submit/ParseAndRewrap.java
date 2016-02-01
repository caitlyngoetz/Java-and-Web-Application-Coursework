import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseAndRewrap {
	ArrayList<String> capital = new ArrayList<String>();
	String line, word, shortestLine, longestLine;
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a plain text file name: ");
		String fileName = scan.nextLine();
		System.out.println("Please enter the maximum number of characters in a single line: ");
		int maxChars = scan.nextInt();
		int shortestLine = maxChars+1;
		String longestLine = "";
		File file = new File(fileName);
		String outLine="";

		try {
		
			Scanner fileScan = new Scanner(file);
			
			System.out.println("\nContents of \"" + fileName + "\":\n");
			
			while (fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				
				Scanner lineScan = new Scanner(line);
				
				while (lineScan.hasNext()) {
					String word = lineScan.next();
					
					if(word.length() + outLine.length() <= maxChars){
						outLine = outLine + word + " ";
					}
					else{
						System.out.println(outLine);
					
						
						if (outLine.length() < shortestLine){
							shortestLine = outLine.length();
						}
						if (outLine.length() > longestLine.length()) {
							longestLine = outLine;
						}
						outLine = word + " ";
					}
				}
				
			}
			System.out.println(outLine);
			
			
			if (outLine.length() < shortestLine){
				shortestLine = outLine.length();
			}
			if (outLine.length() > longestLine.length()) {
				longestLine = outLine;
			}
			System.out.println("Longest line: " + (longestLine.length()-1));
			System.out.println("Shortest line: " + (shortestLine -1));
		} catch (FileNotFoundException e) {
			System.out.println("File \"" + fileName + "\" could not be opened.");
			System.out.println(e.getMessage());
			System.exit(1);}
	
	}
}
