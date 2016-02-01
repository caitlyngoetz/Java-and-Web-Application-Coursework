import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> {
	private LinearNode<T> head, tail, current;
	private int size, modCount;

	public DoubleLinkedList() {
		head = tail = null;
		size = 0;
	}

	@Override
	public void addToFront(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}
		modCount++;
		size++;

	}

	@Override
	public void addToRear(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;

		}
		modCount++;
		size++;
	}

	@Override
	public void addAfter(T element, T target) {
		LinearNode<T> current = head;
		boolean found = false;
		while (current != null && !found) {
			if (current.getElement().equals(target)) {
				found = true;
			} else {
				current = current.getNext();
			}
		}
		if (!found)
			throw new ElementNotFoundException("DoubleLinkedList");
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (tail == current) {
			newNode.setPrevious(tail);
			tail.setNext(newNode);
			tail = newNode;

		} else {
			newNode.setNext(current.getNext());
			current.getNext().setPrevious(newNode);
			current.setNext(newNode);
			newNode.setPrevious(current);
		}
		size++;
		modCount++;

	}

	@Override
	public T removeFirst() {
		if (isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");

		LinearNode<T> oldHead = head;

		if (size == 1) {
			head = tail = null;
		} else {
			head = head.getNext();
			head.setPrevious(null);
		}
		modCount++;
		size--;
		return oldHead.getElement();
	}

	@Override
	public T removeLast() {
		if (isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");

		LinearNode<T> oldTail = tail;

		if (size == 1) {
			head = tail = null;
		} else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}

		modCount++;
		size--;
		return oldTail.getElement();
	}

	@Override
	public T remove(T element) {
		if (isEmpty())
			throw new ElementNotFoundException("DoubleLinkedList");
		if (element == null) {
			return null;
		}

		boolean found = false;
		LinearNode<T> current = head;
		LinearNode<T> currentPrevious = null;
		LinearNode<T> currentNext = null;

		while (current != null && !found)
			if (element.equals(current.getElement()))
				found = true;
			else {
				current = current.getNext();
			}

		if (!found)
			throw new ElementNotFoundException("DoubleLinkedList");

		currentNext = current.getNext();
		currentPrevious = current.getPrevious();

		if (size() == 1) { // only one element in the list
			head = tail = null;
		} else if (current.getElement().equals(head.getElement())) { // target
			// is at
			// the
			// head
			head = current.getNext();
			current.setPrevious(head);
		} else if (current.getElement().equals(tail.getElement())) // target is
			// at the
			// tail
		{
			tail.setPrevious(tail.getPrevious());
			tail.setNext(null);
		} else { // target is in the middle
			currentPrevious.setNext(currentNext);
			currentNext.setPrevious(current.getPrevious());
		}
		size--;
		modCount++;

		return current.getElement();
	}

	@Override
	public T first() {
		if (isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");
		return head.getElement();
	}

	@Override
	public T last() {
		if (isEmpty())
			throw new EmptyCollectionException("DoubleLinkedList");
		return tail.getElement();
	}

	@Override
	public boolean contains(T target) {

		boolean found = false;
		LinearNode<T> current = head;

		while (current != null && !found)
			if (target.equals(current.getElement()))
				found = true;
			else {
				current = current.getNext();
			}
		return found;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder strBld = new StringBuilder();
		strBld.append("[");

		LinearNode<T> current = head;
		while (current != null) {
			strBld.append(current.getElement());
			strBld.append(", ");
			current = current.getNext();
		}

		if (size() > 0) {
			strBld.delete(strBld.length() - 2, strBld.length());
		}

		strBld.append("]");
		return strBld.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}

	private class DoubleLinkedListIterator implements ListIterator<T> {
		private int iteratorModCount = modCount;
		private LinearNode<T> current;
		private LinearNode<T> previous = null;
		private boolean flag;

		public DoubleLinkedListIterator() {
			current = head;

			flag = false;
		}

		public DoubleLinkedListIterator(int startingIndex) {
			int index = 0;
			current = head;
			while (index != startingIndex) {
				current = current.getNext();
				index++;
			}
			flag = false;
		}

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public boolean hasPrevious() {
			if (current == null)
				return false;
			return (current.needsPrevious() == false);
		}

		@Override
		public T previous() {

			if (!hasPrevious())
				throw new NoSuchElementException("DoubleLinkedList");
			previous = current.getPrevious();
			flag = true;
			if (previous != null) {
				current = current.getPrevious();
				return previous.getElement();
			} else {
				return null;
			}

		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException("DoubleLinkedList");

			previous = current;
			current = current.getNext();

			flag = true;
			return previous.getElement();
		}

		@Override
		public int nextIndex() {
			int index = 0;
			if (size == 0) {
				return index;
			} else if (current.getNext() == null) {
				return size;
			} else {
				LinearNode<T> inspector = head;
				LinearNode<T> target = current.getNext();
				while (inspector != target) {
					inspector = inspector.getNext();
					index++;
				}
			}
			return index;
		}

		@Override
		public int previousIndex() {
			int index = 0;
			if (size == 0) {
				return index;
			} else if (current.getPrevious() == null) {
				return -1;
			} else {
				LinearNode<T> inspector = head;
				LinearNode<T> target = current.getPrevious();
				while (inspector != target) {
					inspector = inspector.getNext();
					index++;
				}
				return index;
			}
		}

		@Override
		public void remove() {
			if (flag == false) {
				throw new IllegalStateException();
			}
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException("DoubleLinkedList");

			if (previous == null) {
				throw new NoSuchElementException();
			}

			LinearNode<T> forward = previous.getNext();
			LinearNode<T> backward = previous.getPrevious();
			if (previous == tail) {
				tail = backward;
			}
			if (previous == head) {
				head = forward;
				previous = forward;
			}
			if (forward != null) {
				forward.setPrevious(backward);
			}
			if (backward != null) {
				backward.setNext(forward);
				previous = backward;
			}

			iteratorModCount++;
			modCount++;
			flag = false;
			size--;

		}

		@Override
		public void set(T e) {
			if (flag == false) {
				throw new IllegalStateException();
			}
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException("DoubleLinkedList");
			}
			previous.setElement(e);
			flag = false;

			iteratorModCount++;
			modCount++;

		}

		@Override
		public void add(T e) {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException("DoubleLinkedList");
			}
			LinearNode<T> newNode = new LinearNode<T>(e);
			if (size == 1) {
				newNode.setPrevious(current);
				newNode = tail;
			} else if (current == head) {
				head = newNode;
				current = head;
			} else if (current == tail) {
				newNode.setPrevious(current);
				current.setNext(newNode);
				tail = newNode;
			} else {

				newNode.setPrevious(current);
				newNode.setNext(current.getNext());
				current.setNext(newNode);
			}

			size++;
			iteratorModCount++;
			modCount++;
			flag = false;
		}

	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		LinearNode<T> current = head;
		int wantIndex = 0;
		LinearNode<T> newNode = new LinearNode<T>(element);
		boolean found = false;
		if (size == 0) {
			head = tail = newNode;

		} else {
			while (current != null && !found) {
				if (wantIndex == index) {
					found = true;
				} else if (current.getNext() != null) {
					current = current.getNext();
					wantIndex++;
				} else {
					newNode.setPrevious(tail);
					tail.setNext(newNode);
					tail = newNode;
					found = true;
				}
			}
			LinearNode<T> next1 = current.getNext();
			newNode.setNext(next1);
			next1.setPrevious(newNode);
			current.setNext(newNode);
			newNode.setPrevious(current);

		}
		size++;
		modCount++;

	}

	@Override
	public void set(int index, T element) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		LinearNode<T> current = head;
		int count = 1;
		boolean found = false;
		while (current != null && !found) {
			if (count == index) {
				current.setElement(element);
				found = true;
			} else {
				current = current.getNext();
				count++;
			}
		}
		modCount++;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		LinearNode<T> current = head;
		int count = 1;
		boolean found = false;
		while (current != null && !found) {
			if (count == index) {
				return current.getElement();
			} else {
				current = current.getNext();
				count++;
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		if (size == 0) {
			return -1;
		}
		int index = 0;
		LinearNode<T> current = head;
		// int retVal = 0;
		boolean found = false;
		while (current != null && !found) {
			if (current.getElement().equals(element)) {
				found = true;
			} else {
				current = current.getNext();
				index++;
			}
		}
		if (!found) {
			return -1;
		}

		return index;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("DoubleLinkedList");

		boolean found = false;
		LinearNode<T> current = head;
		LinearNode<T> currentPrevious = null;
		LinearNode<T> currentNext = null;
		int index1 = 0;

		while (current != null && !found)
			if (index1 == index) {
				found = true;
			} else {
				current = current.getNext();
				index1++;
			}

		currentNext = current.getNext();
		currentPrevious = current.getPrevious();

		if (size() == 1) { // only one element in the list
			head = tail = null;
		} else if (current.equals(head)) { // target is at the head
			head = current.getNext();
			current.setPrevious(head);
		} else if (current.equals(tail)) // target is at the tail
		{
			tail.setPrevious(tail.getPrevious());
			tail.setNext(null);
		} else { // target is in the middle
			currentPrevious.setNext(currentNext);
			currentNext.setPrevious(current.getPrevious());
		}
		size--;
		modCount++;

		return current.getElement();
	}

	@Override
	public ListIterator<T> listIterator() {

		return new DoubleLinkedListIterator();
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		if (startingIndex > size || startingIndex < 0) {
			return null;
		}
		return new DoubleLinkedListIterator(startingIndex);
	}

	@Override
	public void add(T element) {
		addToRear(element);
	}

}