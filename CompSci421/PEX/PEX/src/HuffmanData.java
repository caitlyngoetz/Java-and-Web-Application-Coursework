

public class HuffmanData {

	int index;
	int frequency;
	
	public HuffmanData(int frequency){
		this.frequency = frequency;
	}
	
	public HuffmanData(int index, int frequency){
		this.index = index;
		this.frequency = frequency;
	}
	
	public int getIndex(){
		return index;
	}
	
	public int getFreq(){
		return frequency;
	}
	
	public void incrementFreq (){
		frequency ++;
	}
}
