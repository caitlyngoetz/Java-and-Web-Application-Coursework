import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class in GridMonitor.  Implements the GridMonitorInterface.  Allows methods to run.
 * @author cgoetz
 */
public class GridMonitor implements GridMonitorInterface {
	Scanner scan;
	int rows, cols;
	double sumGrid[][], baseGrid[][], avgGrid[][], deltaGrid[][];
	boolean dangerGrid[][];


	public GridMonitor(String filename) throws FileNotFoundException {
			scan = new Scanner(new File(filename));
			rows = scan.nextInt();
			cols = scan.nextInt();
			baseGrid = new double[(int) rows][(int) cols];
			sumGrid = new double[(int) rows][(int) cols];
			avgGrid = new double[(int) rows][(int) cols];
			deltaGrid = new double[(int) rows][(int) cols];
			dangerGrid = new boolean[(int) rows][(int) cols];
			
			for (int row = 0; row < rows; row++){
				for (int col = 0; col < cols; col++){
					baseGrid[row][col] = scan.nextDouble();
				}
			}
			
			sumGrid = getSurroundingSumGrid();
			avgGrid = getSurroundingAvgGrid();
			deltaGrid = getDeltaGrid();
			dangerGrid = getDangerGrid();
			
	}
	/**
	 * Returns the original base grid, as read from file.
	 * 
	 * @return base grid
	 */
	@Override
	public double[][] getBaseGrid() {
		double copyBaseGrid[][] = new double[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				copyBaseGrid[i][j] = baseGrid[i][j];
			}
		}
		return copyBaseGrid;
	}
	/**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is the sum of the 4 surrounding base elements. For elements on a grid border,
	 * the base element's own value is used when looking out of bounds, as if there
	 * is a mirror surrounding the grid. This method is exposed for testing.
	 * 
	 * @return grid containing the sum of adjacent positions
	 */
	@Override
	public double[][] getSurroundingSumGrid() {
		for (int i = 0; i < rows; i++){
			for (int j =0; j < cols; j++){
				double currentSum = 0;
				//north
				if(i + 1 < rows){
					currentSum += baseGrid[i + 1][j];
				}else {
					currentSum += baseGrid[i][j];
				}
				//south
				if (i -1 >= 0){
					currentSum += baseGrid[i-1][j];
				}else{
					currentSum += baseGrid[i][j];
				}
				//east
				if (j +1 < cols){
					currentSum += baseGrid[i][j+1];
				}else{
					currentSum += baseGrid[i][j];
				}
				//west
				if (j -1 >= 0){
					currentSum += baseGrid[i][j-1];
				}else{
					currentSum += baseGrid[i][j];
				}
				
				
				//System.out.println( currentSum);
				sumGrid[i][j] = currentSum;
			}
		}

		return sumGrid;
	}
	/**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is the average of the 4 surrounding base elements. This method is exposed for 
	 * testing.
	 * 
	 * @return grid containing the average of adjacent positions
	 */
	@Override
	public double[][] getSurroundingAvgGrid() {
		double copyAvgGrid[][] = new double[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				double average = sumGrid[i][j] / 4;
				avgGrid[i][j] = average;
				copyAvgGrid[i][j] = avgGrid[i][j];
			}
		}
		return copyAvgGrid;
	}
	/**
	 * Returns a grid with the same dimensions as the base grid, but each element 
	 * is the maximum delta from the average. For example, if the surrounding
	 * average at some coordinate is 2.0 and the maximum delta is 50% of the average,
	 * the delta value at the same coordinate in this grid will be 1.0. This method is
	 * exposed for testing.
	 * 
	 * @return grid containing the maximum delta from average of adjacent positions
	 */
	@Override
	public double[][] getDeltaGrid() {
		double copyDeltaGrid[][] = new double[rows][cols];
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				double delta = avgGrid[i][j] * 0.5;
				deltaGrid[i][j] = delta;
				copyDeltaGrid[i][j] = deltaGrid[i][j];
			}
		}
		return copyDeltaGrid;
	}

	/**
	 * Returns a grid with the same dimensions as the base grid, but each element
	 * is a boolean value indicating if the cell is at risk. For example, if the cell
	 * at a coordinate is less than the surrounding average minus its maximum delta or
	 * greater than the surrounding average plus its maximum delta, the corresponding
	 * coordinate in this grid will be true. If the base cell value is within the safe
	 * range, however, the corresponding value in this grid will be false.
	 * 
	 * @return grid containing boolean values indicating whether the cell at this
	 * location is in danger of exploding
	 */
	@Override
	public boolean[][] getDangerGrid() {
		boolean copyDangerGrid[][] = new boolean[rows][cols];
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				boolean danger = true;
				if (((Math.abs(baseGrid[i][j]) < (Math.abs(avgGrid[i][j]) - Math.abs(deltaGrid[i][j]))) ||
						(Math.abs(baseGrid[i][j]) > (Math.abs(avgGrid[i][j]) + Math.abs(deltaGrid[i][j]))))){
					danger = true;
				}else danger = false;
				dangerGrid[i][j] = danger;
				copyDangerGrid[i][j] = dangerGrid[i][j];
			}
		}
		return copyDangerGrid;
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(dangerGrid[i][j] == true){
					output += "Danger  ";
				}
				if(dangerGrid[i][j] == false){
					output += "Safe  ";
				}
			}
			output += "\n";
		}
		return output;
	}
}
