import java.lang.reflect.Array;

public class HashTable<T> {
	private int probes;
	private int debug;
	private HashObject<T>[] table;
	private int m; //twin primes: m-2 = 95957
	private boolean linearProbe;
	@SuppressWarnings("unchecked")
	public HashTable(int m, boolean hashType, int debug){
		this.m = m;
		this.debug = debug;
		HashObject<T> temp = new HashObject<T>(null);
		table = (HashObject<T>[]) Array.newInstance(temp.getClass(), m);
		probes = 0;
		linearProbe = hashType;
	}
	public int insert(int key, HashObject<T> value){
		probes = 1;
		int i = 0;
		int hash = getIndex(key, i);
		while(i < table.length && table[hash] != null){
			i = i + 1;
			hash = getIndex(key, i);
			probes++;
		}
		if(i >= table.length) return -1;
		table[hash] = value;
		return hash;
	}
	public int find(int key, HashObject<T> value){
		int i = 0;
		int hash = getIndex(key, i);
		while(i < table.length){
			if(table[hash] != null && table[hash].equals(value.getObject())){
				return hash;
			}
			i = i + 1;
			hash = getIndex(key, i);
		}
		return -1;
	}
	private int getIndex(int key, int i){
		int hash1 = key % m;
		if(linearProbe){
			return Math.abs((hash1 + 1) % m);
		}else{
			int hash2 = 1 + (key % (m - 2));
			return Math.abs((hash1 + i*hash2) % m);
		}
	}
	public int getSize(){
		return m;
	}
	public int getProbes(){
		return probes;
	}
	public HashObject<T> getObj(int index){
		if(index < 0 || index >= m) return null;
		return table[index];
	}
	@Override
	public String toString(){
		StringBuilder strbld = new StringBuilder();
		for(int i = 0; i < m; i++){
			if(table[i] != null){
				strbld.append("table[");
				strbld.append(i);
				strbld.append("]: ");
				strbld.append(table[i].toString() + " ");
				if(debug == 2){
					strbld.append(table[i].getCurrentProbes());
				}
				strbld.append("\n");
			}
		}
		return strbld.toString();
	}

}