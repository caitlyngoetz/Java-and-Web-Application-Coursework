
/**
 * defines a process
 * You need to implement the compareTo method in this class.
 * Each process has a priority level, time remaining to finish, 
 * and arrival time
 * 
 * @author cgoetz
 *
 */
public class Process implements Comparable<Process> {
	public int priorityLevel, arrivalTime, timeRemaining, notProcessedTime;
	public int priority;
	
	public Process(int currentTime, int randProcessTime, int priorLevel){
		arrivalTime = currentTime;
		timeRemaining = randProcessTime;
		priorityLevel = priorLevel;
		notProcessedTime = 0;
	}
	
	public boolean finish() {
		if(timeRemaining == 0){
			return true;
		}else{	
			return false;
		}	
	}

	public void resetTimeNotProcessed() {
		notProcessedTime = 0;
		
	}
	
	public int getPriority() {
		return priorityLevel;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}



	public void reduceTimeRemaining() {
		timeRemaining--;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}




	@Override
	public int compareTo(Process o) {
		Process process = (Process) o;
		if(priorityLevel > process.getPriority()){
			return 1;
		}else if (priorityLevel == process.getPriority()){
			if(arrivalTime < process.getArrivalTime()){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 0;
		
			}
		
		}
}
