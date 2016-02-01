
public class LinkedQueue<T> implements QueueADT<T> {
	private LinearNode<T> head, tail;
	private int size;
	
	public LinkedQueue(){
		size = 0;
		head = tail = null;
	}

	@Override
	public void enqueue(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if(tail == null){
			head = tail = newNode;
		}else{
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	@Override
	public T dequeue() {
		if(isEmpty()) throw new EmptyCollectionException("LinkedList");
		
		LinearNode<T> oldHead = head;
		if(size == 1){
			head = tail = null;
		}else{
			head= head.getNext();
		}
		size--;
		return oldHead.getElement();
	}

	@Override
	public T first() {
		if(isEmpty()){
			throw new EmptyCollectionException("LinkedQueue");
		}
		return head.getElement();
	}

	@Override
	public boolean isEmpty() {
	return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString(){
		StringBuilder strBld = new StringBuilder();
		strBld.append("[");
		
		LinearNode<T> current = head;
		while(current != null){
			strBld.append(current.getElement());
			strBld.append(", ");
			current = current.getNext();
		}
		
		if(size() > 0){
			strBld.delete(strBld.length()-2,  strBld.length());
		}
		
		strBld.append("]");
		return strBld.toString();

	}

}
