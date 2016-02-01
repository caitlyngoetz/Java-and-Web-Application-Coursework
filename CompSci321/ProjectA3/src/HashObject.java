public class HashObject<T> {
	private int frequency, currentProbes;
	private T obj;
	public HashObject(T obj) {
		this.obj = obj;
		frequency = 0;
	}
	public T getObject(){
		return obj;
	}
	public int getKey(){
		return Math.abs(obj.hashCode());
	}
	@Override
	public boolean equals(Object o2){
		return obj.equals(o2);
	}
	public void found(){
		frequency++;
	}
	public void setCurrentProbes(int probes){
		currentProbes = probes;
	}
	public int getCurrentProbes(){
		return currentProbes;
	}
	public int getFrequency(){
		return frequency;
	}
	@Override
	public String toString(){
		return obj.toString() + " " + frequency;
	}
}