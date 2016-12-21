

public class HuffmanTreePQ
{
    private Heap heap;

    public HuffmanTreePQ()
    {
        heap = new Heap();
    }
    
    public boolean isEmpty()
    {
        return (heap.isEmpty());
     
    }

    public HuffmanNode deQueue()
    {
        return heap.getMin();
    }

    public void enQueue(HuffmanNode node)
    {
        heap.insert(node);
    }
  
    public int size()
   {
       return heap.size();
   }
}
