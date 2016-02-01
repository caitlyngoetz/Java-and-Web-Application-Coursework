import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Search for shortest paths between start and end points on a circuit board
 * as read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to
 * a GUI according to options specified via command-line arguments.
 * 
 * @author cgoetz
 */
public class CircuitTracer {
	private CircuitBoard board;
	private Storage<TraceState> stateStore;
	private ArrayList<TraceState> bestPaths;
	private boolean consoleOutput;
	private int shortestPath;

	/** launch the program
	 * @param args three required arguments:
	 *  first arg: -s for stack or -q for queue
	 *  second arg: -c for console output or -g for GUI output
	 *  third arg: input file name 
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			printUsage();
			System.exit(1);
		}
		try {
			new CircuitTracer(args); //create this with args
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/** Print instructions for running CircuitTracer from the command line. */
	private static void printUsage() {
		//TODO: print out clear usage instructions when there are problems with
		// any command line args
		System.out.println("Command Line Arguments are not correct.");
		System.out.println("java CircuitTracer -s||-q filename");
		System.out.println("-s for stack or -q for queue");
	}

	/** 
	 * Set up the CircuitBoard and all other components based on command
	 * line arguments.
	 * 
	 * @param args command line arguments passed through from main()
	 */
	private CircuitTracer(String[] args) {
		//TODO: parse command line args
		//TODO: initialize the Storage to use either a stack or queue

		String storageCheck = args[0];
		String consoleCheck = args[1];
		String inputFile = args[2];
		bestPaths = new ArrayList<TraceState>();

		if(storageCheck.equals("-s")){
			stateStore = new Storage<TraceState>(Storage.DataStructure.stack);
		}else if(storageCheck.equals("-q")){
			stateStore = new Storage<TraceState>(Storage.DataStructure.queue);
		}

		if(consoleCheck.equals("-c")){
			consoleOutput = true;
		}else{
			consoleOutput = false;
		}

		//TODO: read in the CircuitBoard from the given file
		try{
			board = new CircuitBoard(inputFile);
			//System.out.println(board.toString());
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}

		//TODO: run the search for best paths
		TraceState startingTrace = new TraceState(board);
		if(startingTrace.isComplete()){
			board.toString();
			System.exit(0);
		}

		Point startingPoint = board.getStartingPoint();
		if(board.isOpen(startingPoint.x + 1, startingPoint.y)){
			TraceState north = new TraceState(board, startingPoint.x+1, startingPoint.y);
			if(north.getBoard().isOpen(startingPoint.x+1, startingPoint.y)){
				north.getBoard().makeTrace(startingPoint.x+1, startingPoint.y);
			}
			stateStore.store(north);
		}
		if(board.isOpen(startingPoint.x - 1, startingPoint.y)){
			TraceState south = new TraceState(board, startingPoint.x-1, startingPoint.y);
			if(south.getBoard().isOpen(startingPoint.x-1, startingPoint.y)){
				south.getBoard().makeTrace(startingPoint.x-1, startingPoint.y);
			}
			stateStore.store(south);
		}
		if(board.isOpen(startingPoint.x, startingPoint.y + 1)){
			TraceState east = new TraceState(board, startingPoint.x, startingPoint.y+1);
			if(east.getBoard().isOpen(startingPoint.x, startingPoint.y+1)){
				east.getBoard().makeTrace(startingPoint.x, startingPoint.y+1);
			}
			stateStore.store(east);
		}
		if(board.isOpen(startingPoint.x, startingPoint.y - 1)){
			TraceState west = new TraceState(board, startingPoint.x, startingPoint.y-1);
			if(west.getBoard().isOpen(startingPoint.x, startingPoint.y-1)){
				west.getBoard().makeTrace(startingPoint.x, startingPoint.y-1);
			}
			stateStore.store(west);
		}
		while(!stateStore.isEmpty()){
			TraceState nextUnevaluated = stateStore.retrieve();
			
			if(nextUnevaluated.isComplete()){
				bestPaths.add(nextUnevaluated);
//				if(nextUnevaluated.pathLength() <= shortestPath){
//					shortestPath = nextUnevaluated.pathLength();
//					bestPaths.add(nextUnevaluated);
//				}
			} 
			if(nextUnevaluated.getBoard().isOpen(nextUnevaluated.getRow() + 1, nextUnevaluated.getCol())){
				TraceState north = new TraceState(nextUnevaluated, nextUnevaluated.getRow()+1, nextUnevaluated.getCol());
				if(north.getBoard().isOpen(nextUnevaluated.getRow() + 1, nextUnevaluated.getCol())){
					north.getBoard().makeTrace(nextUnevaluated.getRow() + 1, nextUnevaluated.getCol());
				}
				stateStore.store(north);
			}
			if(nextUnevaluated.getBoard().isOpen(nextUnevaluated.getRow() - 1, nextUnevaluated.getCol())){
				TraceState south = new TraceState(nextUnevaluated, nextUnevaluated.getRow()-1, nextUnevaluated.getCol());
				if(south.getBoard().isOpen(nextUnevaluated.getRow() - 1, nextUnevaluated.getCol())){
					south.getBoard().makeTrace(nextUnevaluated.getRow() - 1, nextUnevaluated.getCol());
				}
				stateStore.store(south);
			}
			if(nextUnevaluated.getBoard().isOpen(nextUnevaluated.getRow(), nextUnevaluated.getCol() + 1)){
				TraceState east = new TraceState(nextUnevaluated, nextUnevaluated.getRow(), nextUnevaluated.getCol()+1);
				if(east.getBoard().isOpen(nextUnevaluated.getRow(), nextUnevaluated.getCol() + 1)){
					east.getBoard().makeTrace(nextUnevaluated.getRow(), nextUnevaluated.getCol() + 1);
				}
				stateStore.store(east);
			}
			if(nextUnevaluated.getBoard().isOpen(nextUnevaluated.getRow(), nextUnevaluated.getCol() - 1)){
				TraceState west = new TraceState(nextUnevaluated, nextUnevaluated.getRow(), nextUnevaluated.getCol()-1);
				if(west.getBoard().isOpen(nextUnevaluated.getRow(), nextUnevaluated.getCol() - 1)){
					west.getBoard().makeTrace(nextUnevaluated.getRow(), nextUnevaluated.getCol() - 1);
				}
				stateStore.store(west);
			}
		}

		TraceState temp = bestPaths.get(0);
		for(int i = 1; i < bestPaths.size(); i++){
			if(temp.pathLength() > bestPaths.get(i).pathLength()){
				temp = bestPaths.get(i);
			}
			//System.out.println(bestPaths.get(i).toString());
		}


		//TODO: output results to console or GUI, according to specified choice
		for(int i = 0; i< bestPaths.size(); i++){
			if(bestPaths.get(i).pathLength() == temp.pathLength()){
				System.out.println(bestPaths.get(i).toString());
			}
		}
	}

} // class CircuitTracer