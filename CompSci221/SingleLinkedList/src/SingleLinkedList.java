/**
 * SingleLinkedList represents a LinearNode-based implementation of both an unordered and indexed list.
 *
 * @author Java Foundations, 
 * @version 4.0
 */
public class SingleLinkedList<T> extends AbstractLinkedList<T> implements UnorderedListADT<T>, IndexedListADT<T>
{	
	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToFront(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);
		newNode.setNext(head);
		head = newNode;
		if(tail == null){
			tail = head;
		}
		modCount++;
		count++;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToRear(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);
		if(tail == null){
			head = tail = newNode;
		}else{
			tail.setNext(newNode);
			tail = newNode;
		}
		modCount++;
		count++;
	}	

	/**
	 * Adds the specified element to this list after the given target.
	 *
	 * @param  element the element to be added to this list
	 * @param  target the target element to be added after
	 * @throws ElementNotFoundException if the target is not found
	 */
	public void addAfter(T element, T target)
	{
		LinearNode<T> current = head;
		boolean found = false;
		while(current != null && !found){
			if(current.getElement().equals(target)){
				found = true;
			}else{
				current = current.getNext();
			}
		}
		if(!found) throw new ElementNotFoundException("LinkedList");
		LinearNode<T> newNode = new LinearNode<T>(element);
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		if(tail == current){
			tail = newNode;
		}
		count++;
		modCount++;
	}

	/**  
	 * Inserts the specified element at the specified index. 
	 * 
	 * @param index   the index into the array to which the element is to be
	 *                inserted.
	 * @param element the element to be inserted into the array   
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public void add(int index, T element) {
		LinearNode<T> current = head;
		LinearNode<T> next = null;
		boolean found = false;
		LinearNode<T> newNode = new LinearNode<T>(element);
		int indexCount = 0;
		
		if(count < index) throw new IndexOutOfBoundsException();
		
		while( current != null && !found){
			if(indexCount == index){
				next = current.getNext();
				newNode.setNext(next);
				current.setNext(newNode);
				found = true;
			}else{
				current = current.getNext();
				indexCount++;
			}
		}
		count++;
		modCount++;
	}

	/**  
	 * Adds the specified element to the rear of this list. 
	 *
	 * @param element  the element to be added to the rear of the list    
	 */
	public void add(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if(tail == null){
			head = tail = newNode;
		}else{
			tail.setNext(newNode);
			tail = newNode;
		}
		modCount++;
		count++;
	}	
	

	/**  
	 * Sets the element at the specified index. 
	 *
	 * @param index   the index into the array to which the element is to be set
	 * @param element the element to be set into the list
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public void set(int index, T element) {
		LinearNode<T> current = head;
		boolean found = false;
		int indexCount = 0;
		
		if(count < index) throw new IndexOutOfBoundsException();
		
		while( current != null && !found){
			if(indexCount == index){
				current.setElement(element);
				found = true;
			}else{
				current = current.getNext();
				indexCount++;
			}
		}
		//count++;
		modCount++;
	}
	

	/**  
	 * Returns a reference to the element at the specified index. 
	 *
	 * @param index  the index to which the reference is to be retrieved from
	 * @return the element at the specified index    
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public T get(int index) {
		LinearNode<T> current = head;
		boolean found = false;
		while(current != null && !found){
			if(current.equals(index)){
				found = true;
			}else{
				current = current.getNext();
			}
		}
		if(!found) throw new IndexOutOfBoundsException("LinkedList");
		return current.getElement();
	}

	/**  
	 * Returns the index of the specified element. 
	 *
	 * @param element  the element for the index is to be retrieved// TODO To be completed as a Programming Project
	 * @return the integer index for this element or -1 if element is not in the list
	 */
	public int indexOf(T element) {
		LinearNode<T> current = head;
		boolean found = false;
		int index = 0;
		while(current != null && !found){
			if(current.getElement() == element){
				return index;
			}else{
				current = current.getNext();
				index++;
		}
		}
		if(!found){
			return -1;
		}else{ 
			return index;
		}
		
		
	}



	/**  
	 * Returns the element at the specified element. 
	 *
	 * @param index the index of the element to be retrieved
	 * @return the element at the given index    
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public T remove(int index) {
		return null;
	}
}