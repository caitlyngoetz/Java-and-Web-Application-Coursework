import java.util.Scanner;

/**
 * This is the program that gathers input and output for the user
 * @cgoetz 
 */
public class RandomWalkTest
{
	private static int gridSize;
	private static long seed;
	
	/**
	 * This asks for the input from the user and sees if it is viable
	 */
	private static void getInput() 
	{System.out.println("Enter grid size: ");
	Scanner scan = new Scanner(System.in);
	gridSize = scan.nextInt();
	while(gridSize <= 0) {
		System.out.println("Error: grid size must be positive!");
		gridSize = scan.nextInt();
	}
		
	System.out.println("Enter random seed: ");
	seed = scan.nextInt();
	while(seed < 0) {
		System.out.println("Error: random seed must be >= 0!");
		seed = scan.nextInt();
	}
	}
	
	/**
	 * This makes the walker object and outputs the points that the walker went over 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// call getInput to process user input
		getInput();

		// create RandomWalk object using the appropriate constructor
		if(seed ==0){
			RandomWalk walk = new RandomWalk(gridSize);
			walk.createWalk();
			System.out.println(walk.toString());
		}//end if
		
		else{
			RandomWalk walk = new RandomWalk(gridSize, seed);
			walk.createWalk();
			System.out.println(walk.toString());
		}
		// create the random walk and then print it
		
	
		
	}
	}

