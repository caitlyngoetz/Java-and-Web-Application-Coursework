import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * @author cgoetz
 *This is the class that starts the FleschStatistics allowing the program to find
 *all of the information needed to fulfill the program
 */
public class FleschStatistics implements FleschStatisticsInterface{
	private String inputLine;
	private File file;
	private int wordCount, syllableCount, sentenceCount;
	private int wordLengthCount[] = new int[24];
	private int syllablePerWordCount[] = new int[16];
	
	
	/**
	 * @param inputFile
	 * This makes a file object and then makes sure that the inputed file exists
	 */
	public FleschStatistics(File inputFile) {
		file = inputFile;
		
		try{
			Scanner fileScan = new Scanner(file);			
			while (fileScan.hasNextLine()){
				String line = fileScan.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(line, " , .;:'\"&!?-_\n\t12345678910[]{}()@#$%^*/+-");
				sentenceCounter(line);
				while (tokenizer.hasMoreTokens()){
					String word = tokenizer.nextToken();
					wordCount++;
					wordLengthCount[word.length()]++;
					syllableCount += returnSyllableCount(word.toLowerCase());
				}
			}
		} catch (IOException e) {
			System.out.println("The file " + file.getName() + " was not found");
		}
	}
	
	/**
	 * @param word
	 * @return 
	 * this returns the number of syllables in every word of the file
	 */
	public int returnSyllableCount(String word){
		int count = 0;
		if(word.equals("a")|| word.equals("e") || word.equals("i") || word.equals("o") || word.equals("u") || word.equals("y")){
			count++;
		}else{
			for(int j = 0; j<word.length()-1; j++){
				char a = word.charAt(j);
				char b = word.charAt(j+1);
				if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'y'){
					count++;
				}
				if((a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'y') 
					&& (b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u' || b == 'y')){
					count--;
				}
			}
			if(word.charAt(word.length() - 1) == 'y' || word.charAt(word.length() - 1) == 'a' || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o' || word.charAt(word.length() - 1) == 'u'){
				count++;
			}
			if((word.charAt(word.length() - 1) == 'e')){
				if((word.charAt(word.length() - 2) == 'a' || word.charAt(word.length() - 2) == 'e' 
						|| word.charAt(word.length() - 2) == 'i' || word.charAt(word.length() - 2) == 'o' || word.charAt(word.length() - 2) == 'u'
						|| word.charAt(word.length() - 2) == 'y')){
					count++;
				}
			}
				
		}
		if(count == 0){
			count = 1;
		}
		syllablePerWordCount[count]++;
		return count;
}
	/**
	 * @param s
	 * @return
	 * this returns the number of sentences in each file
	 */
	public int sentenceCounter(String s){
		String line = s;
		for(int i=0; i<line.length(); i++){
			if(line.charAt(i) == '.'){
				sentenceCount++;
			}if (line.charAt(i) == '?'){
				sentenceCount++;
			}if (line.charAt(i) == '!'){
				sentenceCount++;
			}if (line.charAt(i) == ';'){
				sentenceCount++;
			}if (line.charAt(i) == ':'){
				sentenceCount++;
			}
		}
		return sentenceCount;
	}
	
	@Override
	public int getWordCount() {
		return wordCount;
	}

	@Override
	public int getSyllableCount() {
		return syllableCount;
	}

	@Override
	public int getSentenceCount() {
		return sentenceCount;
	}

	@Override
	public int[] getWordLengthCount() {
		return wordLengthCount;
	}

	@Override
	public int[] getSyllablePerWordCount() {
		return syllablePerWordCount;
	}

	@Override
	public double getFleschIndex() {
		double fleschIndex = 206.835 - 1.015 * (wordCount / (double)sentenceCount) - 84.6 * (syllableCount / (double)wordCount);
		return fleschIndex;
	}

	@Override
	public String getFleschGrade() {
		String fleschGrade = "";
		if(getFleschIndex() >= 91)
		{
			fleschGrade = "5th grader";
		}
		if(getFleschIndex()>= 81 && getFleschIndex()<= 90){
			fleschGrade = "6th grader";
		}
		if(getFleschIndex() >= 71 && getFleschIndex() <= 80) {
			fleschGrade = "7th grader";
		}
		if(getFleschIndex() >= 66 && getFleschIndex() <= 70){
			fleschGrade = "8th grader";
		}
		if(getFleschIndex() >= 61 && getFleschIndex() <= 65){
			fleschGrade = "9th grader";
		}
		if(getFleschIndex() >= 51 && getFleschIndex() <= 60){
			fleschGrade = "High school student";
		}
		if(getFleschIndex() >= 31 && getFleschIndex() <= 50){
			fleschGrade = "College student";
		}
		if(getFleschIndex() >= 0 && getFleschIndex() <= 30){
			fleschGrade = "College graduate";
		}
		if(getFleschIndex() < 0){
			fleschGrade = "Law school graduate";
		}
		return fleschGrade;
	}
	public String toString(){
		String str = "";
		DecimalFormat formatter = new DecimalFormat("###.00");
		str += "Flesch Statistics for " + file.getName() +"\n";
		str += "==========================================================\n";
		str += wordCount + " words\n";
		str += sentenceCount + " sentences\n";
		str += syllableCount + " syllables\n";
		str += "------------------------------\n";
		str += "Syllable Count :\n";
		str += "\tcount \tfrequency\n";
		str += "\t_____\t_________\n";
		for(int i=0; i<syllablePerWordCount.length; i++){
			if(syllablePerWordCount[i] > 0){
				str += "\t" + i + "\t" + syllablePerWordCount[i] + "\n";
			}
		}
		str += "------------------------------\n";
		str += "Word Lengths: \n";
		str += "\tlength\tfrequency\n";
		str += "\t______\t_________\n";
		for(int j=0; j<wordLengthCount.length; j++){
			if(wordLengthCount[j] > 0){
				str += "\t" + j + "\t" + wordLengthCount[j] + "\n";
			}
		}
		str += "------------------------------\n";
		str += "Flesch Index: " + formatter.format(getFleschIndex()) + "\n";
		str += "Flesch Grade: " + getFleschGrade() + "\n";
		str += "==========================================================\n";
		return str;
		
	}

	

	

}
