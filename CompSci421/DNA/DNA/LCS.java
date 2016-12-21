/*
	Reads in two sequences of DNA
	and returns the longest common subsequence

	@author Caitlyn Goetz
*/
public class LCS{
	
	private String sequence1, sequence2;  //first and second DNA sequences passed in
	private final int MAX_SEQUENCE_LENGTH = 1000;  //sets Max Length for the program

	//Constructor that creates the LCS object
	public LCS(String sequence1, String sequence2){
		this.sequence1 = sequence1;
		this.sequence2 = sequence2;
	}

	//Creates the tables that help find the LCS
	//Returns the result of the toString method
	public String findLCS(){
		int m = sequence1.length() + 1;
		int n = sequence2.length() + 1;
		char b[][] = new char[m][n];
		int c[][] = new int[m][n];
		
		if(this.sequence1.length() == 0 || this.sequence2.length() == 0){
			return "";
		}
		
		if(sequence1.equals(sequence2)){
			return this.sequence1.toString();
		}

		for(int i=1; i<m; i++){
			c[i][0] = 0;
		}
		for(int j=0; j<n; j++){
			c[0][j] = 0;
		}
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(sequence1.charAt(i-1) == sequence2.charAt(j-1)){
					c[i][j] = (c[i-1][j-1])+1;
					b[i][j] = 'd';  //d means we look diagonal
				}else if(c[i-1][j] >= c[i][j-1]){
					c[i][j] = c[i-1][j];
					b[i][j] = 'u';	//u means we look up
				}else{
					c[i][j] = c[i][j-1];
					b[i][j] = 'b';	//b means we look back
				}
			}
		}		
		if(this.sequence1.length() <= this.MAX_SEQUENCE_LENGTH && this.sequence2.length() <= this.MAX_SEQUENCE_LENGTH)
			return toString(b, m-1, n-1);
		
		
		return toString(b);
	}

	//Prints the LCS in a way that is usable to the DNAChecker.java class
	public String toString(char b[][], int i, int j){
		System.out.println("made it to first toString");
		System.out.println(i);
		System.out.println(j);
		if((i == 0) || (j == 0)){
			System.out.println("first");
			return "";
		}
		if(b[i][j] == 'd'){
			System.out.println("second");
			return toString(b, i-1, j-1) + this.sequence1.charAt(i-1);
		}if(b[i][j] == 'u'){
			System.out.println("third");
			return toString(b, i-1, j);
		}
		System.out.println("end");
		return toString(b, i, j-1);
		
	}
	
	public String toString(char b[][]){
		System.out.println("made it to the second toString");
		StringBuilder str = new StringBuilder();
		int i = b.length-1;
		int j = b[0].length-1;
		while(i != 0 && j != 0){
			int direction = b[i][j];
			if(direction == 'd'){
				str.insert(0,  this.sequence1.charAt(i-1));
				i--;
				j--;
			}else if(direction == 'u'){
				i--;
			}else{
				j--;
			}
		}
		return str.toString();
	}
}