import java.util.ArrayList;

public class PQueue {
	
	MaxHeap maxHeap;
	ArrayList<Process> priorQueue;
	int pQueueSize;
	
	public PQueue(){
		priorQueue = new ArrayList<Process>();
		pQueueSize = 0;
		maxHeap = new MaxHeap();
	}
	
	public Process enPQueue(Process p){
		priorQueue = maxHeap.insert(priorQueue, p);
		pQueueSize++;
		return p;
	}	
	
	public void update(int timeToIncrementPriority, int maxLevel){
		int length = priorQueue.size();
		int result;
		
		for(int i = 0; i < (length - 1); i++){
			result = maxHeap.findKey(priorQueue, i, timeToIncrementPriority);
			
			if(result != -1){
				if(priorQueue.get(i).priority < maxLevel){
					int key = priorQueue.get(i).priority;
					key++;
					priorQueue = maxHeap.replaceKey(priorQueue, i, key);
				}
			}
		}
	}
	

	
	public Process dePQueue(){
		Process root = priorQueue.get(0);
		priorQueue = maxHeap.deleteMax(priorQueue);
		pQueueSize--;
		return root;
	}
	
	public boolean isEmpty(){
		if(pQueueSize == 0)
			return true;
		return false;
	}
	

}
