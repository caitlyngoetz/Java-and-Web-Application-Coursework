import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class RandomWalk {
	int gridSize;
	Random rand = new Random();
	ArrayList<Point> path = new ArrayList<Point>();
	private Point start = new Point(0,0);
	private Point current = new Point(0,0);
	private Point end;
	private boolean done = false;
	
	public RandomWalk(int gridSize){
		rand = new Random();
		this.gridSize = gridSize;
		end = new Point(gridSize -1, gridSize - 1); 
		path.add(start);
	}
	
	public RandomWalk(int gridSize, long seed){
		rand = new Random(seed);
		this.gridSize = gridSize;
		end = new Point(gridSize - 1, gridSize - 1);
	}
	
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
	
	public void createWalk() {
	while(!isDone()){
		step();
	}
	}
	
	public boolean isDone() {
		if((current.x == gridSize - 1) && (current.y == gridSize - 1)){
			done = true;
		}
		return done;
	}
	
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


