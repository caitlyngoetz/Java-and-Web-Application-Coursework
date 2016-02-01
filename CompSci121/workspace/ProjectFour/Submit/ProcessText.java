import java.io.File;


/**
 * @author cgoetz
 *This class reads in the inputed file and calls the FleschStatistics Class
 */
public class ProcessText {

	/**
	 * @param args
	 * This finds the all the arguments and make sure that there are arguments inputed
	 * and then sends those arguments to FleschStatistics
	 */
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("ProcessText Usage: java ProcessText file1 [file2 ...]");
			System.exit(1);
		}
		for (int i=0; i<args.length; i++){
			File file = new File(args[i]);
			if(file.canRead() && file.exists()){
					FleschStatistics inputFile = new FleschStatistics(file);
					System.out.println(inputFile);
				}else{
					System.out.println("This file does not exist.");
				}
			
		}

	}

}
