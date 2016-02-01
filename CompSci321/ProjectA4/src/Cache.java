import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author scrabtre
 * @author cgoetz
 *
 */
public class Cache<T extends Comparable<T>> implements Iterable<T>{
	int cap;
	LinkedList<T> data;
	
	public Cache(int CacheSize){
		data = new LinkedList<T>();
		cap = CacheSize;
	}
	
	public boolean check(T checkCache){
		return data.contains(checkCache);
	}
	
	@SuppressWarnings("unchecked")
	public T remove(BTreeNode newNode){
		T out = null;
		T cur = null;
		for(Iterator<T> i = data.iterator(); i.hasNext();){
			cur = i.next();
			if(cur.compareTo((T) newNode) == 0){
				out = cur;
				i.remove();
				break;
			}
		}
		return out;
	}
	
	@SuppressWarnings("unchecked")
	public T add(BTreeNode newNode){
		data.push((T) newNode);
		if(data.size() > cap){
			return data.removeLast();
		}
		return null;
	}
	
	public Iterator<T> iterator(){
		return data.iterator();
	}
}