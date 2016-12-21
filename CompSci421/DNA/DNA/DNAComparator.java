/**
 * Program that uses DNAChecker to find Longest Common
 * Subsequence of two DNA sequences. 
 * 
 * Usage: DNAComparator [filename1] [filename2]
 * where files are plain text files with strings of DNA sequences.
 * 
 * @author Matt T 
 * @version fall 2015
 */
public class DNAComparator
{
	public static void main(String[] args)
	{	
		DNAChecker checker;	// checks for LCS of two sequences 
		// very basic argument verification 
		if(args.length == 2 )
		{
			// create checker
			checker = new DNAChecker(args[0], args[1]);
			// run checks and print results 
			checker.process();
		}
		else
		{
			System.out.println("Invalid format: DNAComparator [filename1] [filename2]");
		}
	}

}
