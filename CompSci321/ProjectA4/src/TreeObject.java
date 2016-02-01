import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * Stores a DNA subsequence inside of BTree structure.
 * @author scrabtre
 * @author cgoetz
 *
 */

public class TreeObject implements Comparable<TreeObject> {
	private int freq; 
	protected long sequence;
	
	public TreeObject() {
		freq = 0;
		sequence = 0;
	}
	
	public TreeObject(ByteBuffer buffer) throws IOException {
		freq = buffer.getInt();
		sequence = buffer.getLong();
	}
	
	public TreeObject(String seq){
		sequence = geneToBits(seq);
		freq = 1;
	}

	@Override
	public int compareTo(TreeObject obj){
		if(this.sequence > obj.sequence)
			return 1;
		else if(this.sequence < obj.sequence)
			return -1;
		else
			return 0;
	}
	public void incFreq(){
		freq++;
	}
	public int getFrequency(){
		return freq;
	}
	@Override
	public String toString(){
		return String.format("%d %s", freq, bitsToGene(sequence, GeneBankCreateBTree.seqLength));
	}
	
	public static String bitsToGene(long key, int seqLength){
		StringBuffer output = new StringBuffer(seqLength);
		output.setLength(seqLength);
		for(int i = 0; i < seqLength; i++){
			int val = (int) (key % 4);
			key = key >> 2;
		switch(val){
		case 0: 
			output.setCharAt(seqLength - i - 1, 'A');
			break;
		case 1: 
			output.setCharAt(seqLength - i - 1, 'C');
			break;
		case 2: 
			output.setCharAt(seqLength - i - 1, 'G');
			break;
		case 3: 
			output.setCharAt(seqLength - i - 1, 'T');
			break;
		}
		}
		return output.toString();
	}
	
	private static long parseLong(String string){
		return new BigInteger(string, 2).longValue();
	}
	
	public static long geneToBits(String seq){
		seq = seq.toUpperCase();
		StringBuilder output = new StringBuilder();
		Character c;
		for(int i = 0; i < seq.length(); i++){
			c = seq.charAt(i);
			switch(c){
			case 'A':
				output.append("00");
				break;
			case 'T':
				output.append("11");
				break;
			case 'C':
				output.append("01");
				break;
			case 'G':
				output.append("10");
				break;
			}
		}
		return parseLong(output.toString());
	}
}