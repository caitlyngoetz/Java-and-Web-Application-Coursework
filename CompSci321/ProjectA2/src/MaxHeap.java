import java.util.ArrayList;

public class MaxHeap {
	ArrayList<Process> priorQueue;
	
	public MaxHeap(){
		
	}
	
	
	public ArrayList<Process> deleteMax(ArrayList<Process> pQueue){
		priorQueue = pQueue;
		
		if(priorQueue.size() == 1){
			priorQueue.remove(0);	
		}else{
			int last = (priorQueue.size() - 1);
			Process insert = priorQueue.get(last);
			
			priorQueue.remove(last);
			priorQueue.set(0, insert);
			maxHeapify(priorQueue, 0);
		}
		return priorQueue;
	}
	
	public ArrayList<Process> prtHeapify(ArrayList<Process> pQueue, int in){
		priorQueue = pQueue;
		int parentIndex = ((in - 1) / 2);
		
		Process pParent = priorQueue.get(parentIndex);
		Process pChild = priorQueue.get(in);
		
		if((pParent).compareTo(pChild) == 0){
			priorQueue.set(in, pParent);
			priorQueue.set(parentIndex, pChild);
		}
		return priorQueue;
	}
	
	public int findKey(ArrayList<Process> pQueue, int in, int key) {
		int length = pQueue.size();
		
		for(int i = in; i < (length - 1); i++){
			if(pQueue.get(i).notProcessedTime == key)
				return i;
		}
		return -1;
	}
	
	public ArrayList<Process> replaceKey(ArrayList<Process> pQueue, int in, int newKey){
		priorQueue = pQueue;
		int oldKey = priorQueue.get(in).priority;
		Process newP = priorQueue.get(in);
		
		newP.priority = newKey;
		priorQueue.set(in, newP);
		
		if(newKey > oldKey)
			prtHeapify(priorQueue, in);
		if(newKey < oldKey)
			maxHeapify(priorQueue, in);
		
		return priorQueue;
	}
	
	public ArrayList<Process> insert(ArrayList<Process> priorityQueue, Process p){
		priorQueue = priorityQueue;
		int last = priorQueue.size();
		
		priorQueue.add(p);
		prtHeapify(priorQueue, last);
		return priorQueue;
	}
	
	public ArrayList<Process> maxHeapify(ArrayList<Process> pQueue, int in){
		priorQueue = pQueue;
		int left = ((2 * in) + 1);
		int right = ((2 * in) + 2);
		int big = left;
		
		Process pLeft = null;
		Process pRight = null;
		
		int size = (priorQueue.size() - 1);
		
		
		if(left <= size) {
			pLeft = priorQueue.get(left);
			if(right <= size){
				pRight = priorQueue.get(right);
				if(pLeft.compareTo(pRight) == 0) // pLeft smaller than pRight
					big = right;
			}
			
			Process pBig = priorQueue.get(big);
			
			if(pBig.compareTo(pLeft) == 0){ // pBig smaller than pLeft
				Process swapper = priorQueue.get(in);
				priorQueue.set(in, pBig);
				priorQueue.set(big, swapper);
			}
			maxHeapify(priorQueue, big);
		}
		return priorQueue;
	}
}