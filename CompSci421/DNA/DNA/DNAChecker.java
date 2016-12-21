/**
 * Reads in DNA strings from files, then 
 * uses LCS (Longest Common Sub-Sequence) class
 * to compare two strings of DNA sequences.  
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DNAChecker
{
	private String sequence1;		// first DNA sequence
	private String sequence2;		// second DNA sequence 
	private String fileName1;		// file with first sequence
	private String fileName2;		// file with second sequence
	private String longestCommonSequence;		// a longest common sub-sequence of two
	private LCS lcs;		// object that compares two strings and finds a LCS of the two
	
	/**
	 * Basic constructor, just initializes fileName variables. 
	 * @param fileName1 - String of name of first file
	 * @param fileName2 - String of name of second file
	 */
	public DNAChecker(String fileName1, String fileName2)
	{
		this.fileName1 = fileName1;
		this.fileName2 = fileName2;
	}
	
	/**
	 * Method that wraps around other methods that
	 * complete the compare and find a LCS of two DNA strings
	 */
	public void process()
	{
		// read in the sequences from the files
		initSequences();
		// initialize object to compare the two strings
		lcs = new LCS(sequence1, sequence2);
		// find a LCS of the two strings 
		longestCommonSequence = lcs.findLCS();
		// print results to console
		printLCS();
	}
	
	/**
	 * Calls read method to read in strings from files 
	 */
	private void initSequences()
	{
		sequence1 = read(fileName1);
		sequence2 = read(fileName2);
	}
	
	/**
	 * Reads in a String from a plain text file. 
	 * @param fileName - String of file name
	 * @return - String contained in the file 
	 */
	private String read(String fileName) 
	{
		// Scanner for reading in file
		Scanner inFile = null;
		// sequence return after read in String from file
		String sequence = "";
		try 
		{
			// initialize Scanner
			inFile = new Scanner(new FileReader(fileName));
			// read in String until get to end of file
			while(inFile.hasNext())
			{
				// append String to sequence variable
				sequence += inFile.next();
			}
		}
		// in case file not found
		catch (FileNotFoundException fe) 
		{
			System.out.println("File " + fileName + " not found.");
			fe.printStackTrace();
		}
		finally
		{
			inFile.close();
		}
		return sequence; 
	}
	
	/**
	 * Prints a LCS of the two Strings 
	 */
	private void printLCS()
	{
		System.out.println("The LCS for the genetic sequences in the files " + fileName1 + " and " + fileName2);
		System.out.println("is " + longestCommonSequence.length() + " characters long and is: ");
		System.out.println();
		System.out.println(longestCommonSequence);
	}
}
