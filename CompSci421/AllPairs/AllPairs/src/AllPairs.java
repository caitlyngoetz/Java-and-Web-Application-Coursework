import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Caitlyn Goetz
 *
 */
public class AllPairs {

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
	 * Calls the slowest and fastes methods while timing them
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
			array[Integer.parseInt(scan.next())][Integer.parseInt(scan.next())] = Integer.parseInt(scan.next());
		}

		long shortestStartTime = System.currentTimeMillis();
		double[][] shortestPathArray = slowAllPath(array);
		long shortestEndTime = System.currentTimeMillis();
		long shortestTime = (shortestEndTime - shortestStartTime);

		long fastestStartTime = System.currentTimeMillis();
		double[][] fastestPathArray = fastAllPath(array);
		long fastestEndTime = System.currentTimeMillis();
		long fastestTime = (fastestEndTime - fastestStartTime);

		double slowestPath = findShortestLength(shortestPathArray);

		boolean slowestNegative = checkWeightCycles(shortestPathArray);
		boolean fastestNegative = checkWeightCycles(fastestPathArray);
	
		System.out.println("slower shortest path algorithm: " + shortestTime + " ms\n");
		System.out.println("faster shortest path algorithm: " + fastestTime + " ms\n");
		if(slowestNegative != true && fastestNegative != true){
			System.out.println("shortest path length: NULL\n");
		}else{
			System.out.println("shortest path length: " + (int) slowestPath + "\n");
		}
		scan.close();
	}

	/**
	 * Looks for negative weight cycles in array
	 * @param shortestPathArray
	 * @return boolean for negative weight cycle 
	 */
	private static boolean checkWeightCycles(double[][] shortestPathArray) {
		double n = shortestPathArray[0].length;
		int i;
		boolean check = true;
		for(i = 0; i < n; i++){
			if(shortestPathArray[i][i] < 0){
				check = false;
			}
		}
		return check;
	}

	/**
	 * Finds the shortest path in the array 
	 * @param array
	 * @return returns the miniumum path in array
	 */
	private static double findShortestLength(double[][] array) {
		double min = array[0][0];
		int i, j;
		for(i = 0; i < array.length; i++){
			for(j = 0; j < array[i].length; j++){
				if(array[i][j] < min){
					min = array[i][j];
				}
			}
		}
		return min;
	}

	/**
	 * Finds all the paths with the slower algorithm
	 * @param W
	 * @return final array
	 */
	private static double[][] slowAllPath(double W[][]){
		int n = W.length;
		double[][][] L = new double[n][][];
		L[0] = W;
		
		for(int m = 1; m < n; m++){
			L[m] = extendShortestPaths(L[m-1], W); 
		}
		return L[n-1]; 
	}

	/**
	 * Finds all the paths with the faster algorithm
	 * @param W
	 * @return final array
	 */
	private static double[][] fastAllPath(double W[][]){
		int n = W.length;
		double[][][] L = new double[n][][];
		L[1] = W;
		
		int m = 1;
		while(2*m < n) {
			int m2 = m*2;
			
			L[m2] = new double[n][n];
			L[m2] = extendShortestPaths(L[m], L[m]);
			
			m = m2;
		}
		return L[m]; 
	}

	/**
	 * Extends the paths
	 * @param L
	 * @param W
	 * @return array with extended paths
	 */
	private static double[][] extendShortestPaths(double L[][], double W[][]){
		int n = W.length;
		double[][] array = new double[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				array[i][j] = Double.POSITIVE_INFINITY;
				
				for(int k = 0; k < n; k++){
					double total = L[i][k] + W[k][j];
					if(array[i][j] < total)
						array[i][j] = array[i][j];
					else
						array[i][j] = total;
				}
			}
		}
		return array;
	}

}
