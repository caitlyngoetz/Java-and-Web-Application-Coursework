import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseForCaps {
	ArrayList<String> capital = new ArrayList<String>();
	String line, word;
	
	

	public static void main(String[] args) {
		System.out.println("Please enter a plain text file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		File file = new File(fileName);
		String outLine = "";
		int maxChars = 0;
		int shortestLine = maxChars+1;
		String longestLine = "";

		try {
			Scanner fileScan = new Scanner(file);
			
			System.out.println("\nContents of \"" + fileName + "\":\n");
			
			while (fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				
				Scanner lineScan = new Scanner(line);
				
				while (lineScan.hasNext()) {
					String word = lineScan.next();
					
					if(word.length() + outLine.length() <= maxChars);{
						outLine = outLine + word + " ";
					}
						System.out.println(outLine);
						if (outLine.length() < shortestLine){
							shortestLine = outLine.length();
						}
						if (outLine.length() > longestLine.length()) {
							longestLine = outLine;
						}
					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File \"" + fileName + "\" could not be opened.");
			System.out.println(e.getMessage());
			System.exit(1);}
	
	}

	
	


	

}
