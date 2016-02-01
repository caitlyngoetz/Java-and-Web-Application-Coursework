import java.util.*;

/**
 * Class for sorting DoubleLinkedLists using either natural order
 * or a Comparator.
 *
 * @author spanter, mvail, cgoetz
 */
public class MergeSort{	
	
	/**
	 * Sorts a list that implements the DoubleLinkedListADT using the
	 * natural ordering of list elements.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The data type in the list must extend Comparable
	 * @param list
	 *            The list that will be sorted
	 * @see DoubleLinkedListADT 
	 */
	public static <T extends Comparable<T>> void sort(DoubleLinkedListADT<T> list){
		if(list.size() < 2)	return;
		
		DoubleLinkedListADT<T> left = new WrappedDLL<T>();
		split(list, left, 0);
		
		DoubleLinkedListADT<T> right = new WrappedDLL<T>();
		split(list, right, 1);
		
		sort(left);
		sort(right);
		merge(list, left, right);
	}
	
	/**
	 * Splits the given list into two separate ones by dividing them in the middle
	 * @param list
	 * @param flag
	 * @return 
	 * @return separate half of the list
	 */
	private static <T> void split(DoubleLinkedListADT<T> list, DoubleLinkedListADT<T> part, int flag){
		int start = 0;
		int end = list.size()/2;
	
		if(flag == 1){
			start = end;
			end = list.size();
		}
		
		ListIterator<T> it = list.listIterator(start);
		while(it.hasNext() && start++ < end){
			part.add(it.next());
		}
	}
	
	/**
	 * Merges two sorted list of the specified array.
	 *
	 * @param data the array to be sorted
	 * @param first the beginning index of the first list
	 * @param mid the ending index of the first list
	 * @param last the ending index of the second list
	 */
	private static <T extends Comparable<T>> void merge(DoubleLinkedListADT<T> list, DoubleLinkedListADT<T> left, DoubleLinkedListADT<T> right){
		ListIterator<T> mainIt = list.listIterator();
		ListIterator<T> leftIt = left.listIterator();
		ListIterator<T> rightIt = right.listIterator();
		
		while(mainIt.hasNext()){
			if(leftIt.hasNext() && rightIt.hasNext()){
				mainIt.next();
				
				T l = leftIt.next();
				T r = rightIt.next();
				
				if(l.compareTo(r) < 0){
					mainIt.set(l);
					rightIt.previous();
				}else{
					 mainIt.set(r);
					 leftIt.previous();
				}
				
			}else{
				break;
			}
		}


		if(mainIt.hasNext()){
			
			if(leftIt.hasNext()){
				
				while(leftIt.hasNext() && mainIt.hasNext()){
					mainIt.next();
					mainIt.set(leftIt.next());
				}					
			
			}else{
				
				while(rightIt.hasNext() && mainIt.hasNext()){
					mainIt.next();
					mainIt.set(rightIt.next());
				}
			}
			
		}
	}

	/**
	 * Sorts a DoubleLinkedListADT with the provided Comparator.
         * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of list to sort
	 * @param list
	 *            The list to sort
	 * @param c
	 *            The Comparator to use
	 * @see DoubleLinkedListADT
	 */
	public static <T> void sort(DoubleLinkedListADT<T> list, Comparator<T> c){
		if(list.size() < 2)	return;
		
		DoubleLinkedListADT<T> left = new WrappedDLL<T>();
		split(list, left, 0);
		
		DoubleLinkedListADT<T> right = new WrappedDLL<T>();
		split(list, right, 1);
		
		sort(left, c);
		sort(right, c);
		merge(list, c, left, right);
	}
	
	/**
	 * Merges two sorted lists of the specified array.
	 *
	 * @param data the array to be sorted
	 * @param first the beginning index of the first list
	 * @param mid the ending index of the first list
	 * @param last the ending index of the second list
	 */
	private static <T> void merge(DoubleLinkedListADT<T> list, Comparator<T> c, DoubleLinkedListADT<T> left, DoubleLinkedListADT<T> right){
		ListIterator<T> mainIt = list.listIterator();
		ListIterator<T> leftIt = left.listIterator();
		ListIterator<T> rightIt = right.listIterator();
		
		while(mainIt.hasNext()){
			if(leftIt.hasNext() && rightIt.hasNext()){
				mainIt.next();
				
				T l = leftIt.next();
				T r = rightIt.next();
				
				if(c.compare(l, r) < 0){
					mainIt.set(l);
					rightIt.previous();
				}else{
					 mainIt.set(r);
					 leftIt.previous();
				}
				
			}else{
				break;
			}
		}


		if(mainIt.hasNext()){
			
			if(leftIt.hasNext()){
				
				while(leftIt.hasNext() && mainIt.hasNext()){
					mainIt.next();
					mainIt.set(leftIt.next());
				}					
			
			}else{
				
				while(rightIt.hasNext() && mainIt.hasNext()){
					mainIt.next();
					mainIt.set(rightIt.next());
				}
			}
			
		}
	}

	/**
	 * Finds the smallest element in a list according to the natural ordering of 
	 * list elements. Does not alter the order of list elements.
         * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @return The smallest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> T findSmallest(DoubleLinkedListADT<T> list){
		if(list.isEmpty()) return null;
		return myFindSmallest(list, list.first());
	}
	
	private static <T extends Comparable<T>> T myFindSmallest(DoubleLinkedListADT<T> list, T smallest){
		if(list.isEmpty()) return smallest;
		
		T temp = list.removeFirst();
		
		if(temp.compareTo(smallest) < 0)
			smallest = temp;
		
		smallest = myFindSmallest(list, smallest);
		
		list.addToFront(temp);
			
		return smallest;
	}

	/**
	 * Finds the smallest element in a list with a Custom comparator. Does not
	 * alter the order of list elements.
         * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @param c
	 *            The comparator to use
	 * @return The smallest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T> T findSmallest(DoubleLinkedListADT<T> list, Comparator<T> c){
		if(list.isEmpty()) return null;
		return myFindSmallest(list, c, list.last());
	}
	
	public static <T> T myFindSmallest(DoubleLinkedListADT<T> list, Comparator<T> c, T smallest){
		if(list.isEmpty()) return smallest;
		
		T temp = list.removeFirst();
		
		if(c.compare(temp, smallest) < 0)
			smallest = temp;
		
		smallest = myFindSmallest(list, c, smallest);
		
		list.addToFront(temp);
			
		return smallest;
	}

	/**
	 * Finds the largest element in a list according to the natural ordering of
	 * list elements. Does not alter the order of list elements.
         * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @return The largest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> T findLargest(DoubleLinkedListADT<T> list){
		if(list.isEmpty()) return null;
		return myFindLargest(list, list.first());
	}
	
	public static <T extends Comparable<T>> T myFindLargest(DoubleLinkedListADT<T> list, T largest){
		if(list.isEmpty()) return largest;
		
		T temp = list.removeFirst();
		
		if(temp.compareTo(largest) > 0)
			largest = temp;
		
		largest = myFindLargest(list, largest);
		
		list.addToFront(temp);
			
		return largest;
	}

	/**
	 * Finds the largest element in a list with a Custom comparator. Does not
	 * alter the order of list elements.
         * DO NOT MODIFY THIS METHOD SIGNATURE
	 * @param <T>
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @param c
	 *            The comparator to use
	 * @return The largest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T> T findLargest(DoubleLinkedListADT<T> list, Comparator<T> c){
		if(list.isEmpty()) return null;
		return myFindLargest(list, c, list.first());
	}
	
	public static <T> T myFindLargest(DoubleLinkedListADT<T> list, Comparator<T> c, T largest){
		if(list.isEmpty()) return largest;
		
		T temp = list.removeFirst();
		
		if(c.compare(temp, largest) > 0)
			largest = temp;
		
		largest = myFindLargest(list,c, largest);
		
		list.addToFront(temp);
			
		return largest;
	}
}