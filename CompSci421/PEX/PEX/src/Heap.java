
import java.util.ArrayList;


public class Heap
{
    private ArrayList<HuffmanNode> heap;   
 
    public Heap()
    {
        heap = new ArrayList<HuffmanNode>();   
    }
   
    public int size()
    {
        return heap.size();
    }

    public HuffmanNode getMin()
    {
       HuffmanNode smallest = heap.get(0); 
       heap.set(0, heap.get(heap.size()-1));
       heap.remove(heap.size()-1);

       minHeapifyDown(0);
       return smallest;
    }
    
    public void minHeapifyUp(int index)
    {
        int parent;

        if(index % 2 == 0)
        {
                parent = ((index/2) - 1);
        }
        else
        {
                parent = (index/2);
        }
        
        while((index > 0) && (heap.get(parent).getData().getFreq() > heap.get(index).getData().getFreq()))
        {
            HuffmanNode temp = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, temp);
            index = parent;

            if(index % 2 == 0)
            {
                parent = ((index/2) - 1);
            }
            else
            {
                parent = (index/2);
            }
        } 
    }
    
    public void minHeapifyDown(int index)
    {
    	int smallest;
        int left;
        int right;
        int i = index;
        left = (2*index)+ 1;
        right = (2*index)+ 2;
        
        if((left <= heap.size()-1) && (heap.get(left).getData().getFreq() < heap.get(i).getData().getFreq()))
        {
            smallest = left;
        }
        else
        {
            smallest = index;
        }

 
        if((right <= heap.size()-1) && (heap.get(right).getData().getFreq() < heap.get(smallest).getData().getFreq()))
        {

            smallest = right;
        }

        if(smallest != index)
        {
            HuffmanNode temporary = heap.get(smallest);
            heap.set(smallest, heap.get(index));
            heap.set(index, temporary);
            minHeapifyDown(smallest);
        }

    }
   
    public boolean isEmpty()
    {
        return (heap.isEmpty());
     
    }
    
    public void insert(HuffmanNode node)
    {
        heap.add(node);
        minHeapifyUp(heap.size()-1);
    }

}
