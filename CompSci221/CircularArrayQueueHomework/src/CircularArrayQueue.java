
public class CircularArrayQueue<T> implements QueueADT<T> {
	private T[] queue;
	private int front, rear;
	private int size;
	private final int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(){
		queue = (T[])(new Object[DEFAULT_CAPACITY]);
		front = 0;
		rear = 0;
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void expandCapacity(){
		T[] temp = (T[])(new Object[queue.length*2]);
		for(int i = 0; i < size; i++){
			temp[i] = queue[front];
			front = (front + 1) % queue.length;
		}
		front = 0;
		rear = size;
		queue = temp;
	}

	@Override
	public void enqueue(T element) {
		if(size == queue.length){
			expandCapacity();
		}
		queue[rear] = element;
		rear = (rear + 1)%queue.length;
		size++;
		
	}

	@Override
	public T dequeue() {
		if(isEmpty()) throw new EmptyCollectionException("CircularArrayQueue");
		T retVal = queue[front];
		front = (front + 1)%queue.length;
		size--;
		return retVal;
	}

	@Override
	public T first() {
		if(isEmpty()) throw new EmptyCollectionException("CircularArrayQueue");
		return queue[front];
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("[");
		for(int i = 0; i < size; i++){
			str.append(queue[(front + 1) % queue.length] + ", ");
		}
		if (size > 0){
			str.delete(str.length()-2, str.length());
		}
		str.append("]");
		
		return str.toString();
	}

}
