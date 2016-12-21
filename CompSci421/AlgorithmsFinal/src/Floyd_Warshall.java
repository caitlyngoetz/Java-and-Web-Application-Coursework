import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Floyd_Warshall {
	/**
	 * Sets up file and sends it to the readFile 
	 * method for scanning in
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		if(args.length != 1){
			System.out.println("Usage: java AllPairs <filename>");
		}

		File file = new File(args[0]);

		readFile(file);
	}
	
	/**
	 * Scans file and sets up the initial array
	 * Calls the slowest and fastest methods while timing them
	 * Sends that to be checked for Negative Weight Cycles
	 * Finds shortest path length
	 * Outputs to console
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	private static void readFile(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		int vertices = Integer.parseInt(scan.next());
		scan.next();

		double array[][] = new double[vertices][vertices];
		int i, j;
		
		for(i = 0; i < vertices; i++)
			for(j = 0; j < vertices; j++)
				if(i != j)
					array[i][j] = Double.POSITIVE_INFINITY;

		while(scan.hasNext()){
			System.out.println("hello");
			array[Integer.parseInt(scan.next())][Integer.parseInt(scan.next())] = Integer.parseInt(scan.next());
		}

		floydWarshall(array);
		
		scan.close();
	}

	private static void floydWarshall(double[][] array) {
		int n = array.length;
		double[][][] D = new double[n][][];
		D[0] = array;
		int k, i, j;
		for(k=1; k < n; k++){
			D[k] = new double[n][n];
			for(i = 1; i < n; i++){
				for(j = 1; j < n; j++){
					D[k][i][j] = Math.min(D[k-1][i][j], D[k-1][i][k]+D[k-1][k][j]);
				}
			}
			System.out.println(Arrays.toString(D));
		}
	}
}
