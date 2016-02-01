import java.util.LinkedList;

public class Cache<T> {

	private LinkedList<T> list;
	private int maxSize;
	
	public Cache(int maxSize){
		if(maxSize < 1) return;
		
		this.list = new LinkedList<T>();
		this.maxSize = maxSize;
	}
	/*
	 * If there is a hit in the cache then object is returned
	 * else null is returned
	 */
	public T searchCache(T object){
		if(object == null) return null;
		if(removeObject(object)) {
			addObject(object);
			return object;
		}
		addObject(object);
		return null;
	}
	
	public T getObject(int index){
		if(index < 0 || index >= maxSize) return null;
		return list.get(index);
	}
	
	public void addObject(T object){
		if(object == null) return;
		list.addFirst(object);
		
		if(isFull())
			list.removeLast();
	}
	
	public Boolean removeObject(T object){
		if(object == null) return null;
		return list.remove(object);
	}
	
	public void clearCache(){
		list.clear();
	}
	
	public Boolean isFull(){
		return list.size() >= maxSize;
	}
	
	public int size(){
		return list.size();
	}

}