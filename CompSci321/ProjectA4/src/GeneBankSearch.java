import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
*
* @author scrabtre
* @author cgoetz
*
*/
public class GeneBankSearch {
	static BTree btree;
	static int degree;
	static int seqLength;
	static int debug;
	static int cacheSize;
	static String bTreeFile;
	static String qFile;

	static String error = "Usage: java GeneBankSearch <btree file> <query file> [<debug level>]";

	public static void main(String[] args) {

		if(args.length != 2 && args.length != 3){
			System.out.println("Incorrect # of arguments.\n\t" + error);
			System.exit(0);
		}

		bTreeFile = args[0];
		qFile = args[1];
		
		if(args.length == 3){
			debug = Integer.parseInt(args[2]);
		}
		else{
			debug = -1;
		}
		searchBTreeFile();
	}
	public static void searchBTreeFile(){
		BufferedReader bufferReader;
		String line;
		

		try{
			btree = new BTree(new File(bTreeFile), degree, seqLength, cacheSize, debug);
			bufferReader = new BufferedReader(new FileReader(qFile));
			if(debug == 0){
				System.out.println("The search of " + bTreeFile + " using strings from the " + qFile);
				System.out.println("<Freq>\t,Queary String>");
			}
			while ((line = bufferReader.readLine()) != null) {
				line = line.toUpperCase();
				if(debug == 0){
					System.out.println(btree.search(line) + "\t" + line);
				}
				else {
					btree.search(line);
				}
			}
		} catch (FileNotFoundException e){
			System.out.println("File was not found.\n\t" + error);
			System.exit(0);
		} catch (IOException e){
			System.out.println("IO Exception was caught\n\t" + error);
			e.printStackTrace();
			System.exit(0);
		} catch (IllegalArgumentException e){
			System.out.println("Degree or sequence length does not match\n\t" + error);
			e.printStackTrace();
			System.exit(0);
		
		}
	}
}