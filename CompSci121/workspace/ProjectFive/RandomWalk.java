import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * This is the main method
 * @author cgoetz
 *
 */
public class RandomWalk {
	int gridSize;
	Random rand = new Random();
	ArrayList<Point> path = new ArrayList<Point>();
	private Point start = new Point(0,0);
	private Point current = new Point(0,0);
	private Point end;
	private boolean done = false;
	
	/**
	 *  This method is the constructor that creates the grid and its endpoint
	 * @param gridSize The size of the grid given by the user
	 */
	public RandomWalk(int gridSize){
		rand = new Random();
		this.gridSize = gridSize;
		end = new Point(gridSize -1, gridSize - 1); 
		path.add(start);
	}
	
	/**
	 * This method is the constructor that creates the grid and its endpoint
	 * @param gridSize The size of the grid given by the user
	 * @param seed	The size of the seed for the grid given by the user
	 */
	public RandomWalk(int gridSize, long seed){
		rand = new Random(seed);
		this.gridSize = gridSize;
		end = new Point(gridSize - 1, gridSize - 1);
	}
	
	/**
	 * This method decides if the RandomWalker steps from the East or the South
	 */
	public void step(){
		int step = rand.nextInt(2);
//		if((step == 1) && (current.x == gridSize - 1)){
//			
//			current.y++;
//		}
//		if(step == 0 && current.y == gridSize - 1){
//			current.x++;
//		}
		if(step ==1){
			if(current.x == gridSize -1){
			current.y++;
			}else {
				current.x++;
			}
		}else if(step == 0) {
			if(current.y == gridSize -1){
				current.x++;
			}else {
				current.y++;
			}
		}
		path.add(new Point (current));
	}
	
	/**
	 * This method tells the RandomWalker to keep walking unless the step is done
	 */
	public void createWalk() {
	while(!isDone()){
		step();
	}
	}
	
	/**
	 * This method checks to see if the walker is at the edge of the grid 
	 * @return This returns if it is done or not
	 */
	public boolean isDone() {
		if((current.x == gridSize - 1) && (current.y == gridSize - 1)){
			done = true;
		}
		return done;
	}
	
	/**
	 * This is the list that will keep track of the coordinate at every step
	 * @return It then returns those coordinates
	 */
	public ArrayList<Point> getPath(){
		return path;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		int z;
		for(z = 0; z < path.size(); z++){
			s.append("[");
			s.append(path.get(z).x);
			s.append(",");
			s.append(path.get(z).y);
			s.append("]");
	}
		return s.toString();
	
		}
	}