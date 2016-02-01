import java.util.Random;


/**
 * Randomly generate processes with a given probability.
 * At beginning of each time unit, whether a process will arrive is 
 * decided by the given probability.  In addition, while generating a new 
 * process, both its priority and the required time units to finish the
 * process are randomly generate within given ranges.
 * 
 * @author cgoetz
 *
 */
public class ProcessGenerator {
	private double probability;
	private Random rand;

	public ProcessGenerator(double probability) {
	if(probability > 1.0){
		System.out.println("Error: probability must be less than 1.0");
		System.exit(1);
	}
	this.probability = probability;
	rand = new Random();
	}
	
	public boolean query() {
		double result = rand.nextDouble();
		if(result < probability){
			return true;
		}
		return false;
	}

	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		int current = currentTime;
		int maxTime = maxProcessTime;
		int maxLev = maxLevel;
		int processTime;
		int priorityLevel;
		
		// get # of decimal places for maxProessTime and maxLevel
		// use these as the powers to raise random doubles to
		
		double time = (int)(1 + (maxTime) * (rand.nextDouble()));
		double level = (int)(1 + (maxLevel) * (rand.nextDouble()));
		
		if(time < maxTime)
			processTime = (int)time;
		else
			processTime = maxTime;
		
		if(level < maxLev)
			priorityLevel = (int)level;
		else
			priorityLevel = maxLev;
		
		Process process = new Process(current, processTime, priorityLevel);
		return process;
	}



}
