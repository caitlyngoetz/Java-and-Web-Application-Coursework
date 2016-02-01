import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * Represents a BTree
 * @author scrabtre
 * @author cgoetz
 *
 */

public class BTree {
	private int degree;
	private BTreeNode root, cur, next;
	private BTreeIO fileIO;
	private int seqLength; 
	private int debugLevel;
	private int numOfNodes; 

	
	
	public static final int SIZE_OF_INT = 4;
	public static final int SIZE_OF_LONG = 8;
	public static final int SIZE_OF_BOOLEAN = 4;
	public static final int SIZE_OF_META_DATA = SIZE_OF_INT * 3;
	
	public BTree(int degree, int length, String fname, String sequence, int cache_size, int debug) throws FileNotFoundException {
		debugLevel = debug;
		fileIO = new BTreeIO(fname, degree, length, cache_size, debug);
		
		if(degree == 0){
			this.degree = findOptDegree();
		}else{
			this.degree = degree;
		}
		
		seqLength = length;
		
		File f = new File(fname);
		f.delete();
		
		TreeObject key = new TreeObject(sequence);
		root = new BTreeNode(this.degree, true, true, 0);
		root.keys.add(0, key);
		numOfNodes = 1;
		
		printOut("Created BTree with a root node: " + root.index + " Sequence: " + sequence);
	}
	
	public BTree(File f, int degree, int seqLength, int cache_size, int debug) throws FileNotFoundException, IllegalArgumentException, IOException {
		debugLevel = debug;
		
		fileIO = new BTreeIO(f.getName(), degree, seqLength, cache_size, debug);
		if(degree == 0)
			degree = findOptDegree();
		
		this.degree = fileIO.readMetaDegree();
		int indexOfRoot = fileIO.readMetaIndex();
		this.seqLength = fileIO.readMetaSeqLength();
		
		if(degree != this.degree && seqLength != this.seqLength)
			throw new IllegalArgumentException();
		
		root = fileIO.readIn(indexOfRoot, degree);
		root.root = true;
	}
	
	private void printOut(String dbgMessage){
		if(debugLevel == 0){
			System.err.println(dbgMessage);
		}
	}
	
	//Finds the optimal degree for the BTree (on the premise that the disk is 4096
	private int findOptDegree(){
		int optDegree = 0;
		int sizeOfNode = 0;
		
		while(sizeOfNode <= 4096){
			sizeOfNode = fileIO.sizeOfBTreeNode(++optDegree);
		}
		
		optDegree--;
		printOut("Calculated optimal degree equals " + optDegree);
		return optDegree;
	}
	
	public void insert(String sequence) throws IOException {
		if(root.isFull()){
			next = root;
			root = new BTreeNode(degree, true, false, numOfNodes++);
			root.children.add(0, next.index);
			next.parent = root.index;
			next.root = false;
			
			printOut("New root node created at index: " + root.index);
			
			split(root, next, 0);
			insertNonFull(new TreeObject(sequence));
			}else{
				insertNonFull(new TreeObject(sequence));
		}
	}
	
	public void split(BTreeNode parent, BTreeNode toSplit, int i) throws IllegalStateException, IOException {
		if(parent.isFull() || !toSplit.isFull()) throw new IllegalStateException();
		
		printOut("Child was split with parent node at index: " + parent.index + " Indexes where split: " + toSplit.index + " and " + i);
		
		BTreeNode newChild = new BTreeNode(degree, false, toSplit.leaf, numOfNodes);
		numOfNodes++;
		
		printOut("New child node created at: " + newChild.index + " Parent Node: " + parent.index);
		
		for(int j = toSplit.keys.size() - 1; j > degree - 1; j--){
			newChild.keys.add(0, toSplit.keys.remove(j));
		}
		
		if(!toSplit.leaf){
			for(int j = toSplit.children.size() - 1; j >= degree; j--){
				newChild.children.add(0, toSplit.children.remove(j));
			}
		}
		
		parent.children.add(i + 1, newChild.index);
		newChild.parent = parent.index;
		parent.keys.add(i, toSplit.keys.remove(degree -1));
		
		fileIO.writeIntoFile(parent, false);
		fileIO.writeIntoFile(toSplit, false);
		fileIO.writeIntoFile(newChild, false);
	}
	
	private void insertNonFull(TreeObject key) throws IOException {
		boolean searching = true;
		cur = root;
		
		while(searching){
			int i = cur.keys.size() - 1;
			if(cur.leaf){
				while(i >= 0 && key.compareTo(cur.keys.get(i)) <= 0){
					if(key.compareTo(cur.keys.get(i)) == 0){
						cur.keys.get(i).incFreq();
						fileIO.writeIntoFile(cur, false);
						printOut("Sequence: " + TreeObject.bitsToGene(key.sequence, seqLength) + " Node: " + cur.index + " Frequency++");
						return;
					}
					i--;
				}
				
				cur.keys.add(i + 1, key);
				printOut("Sequence: " + TreeObject.bitsToGene(key.sequence, seqLength) + " Node: " + cur.index + " Frequency++");
				fileIO.writeIntoFile(cur, false);
				searching = false;
			}else{
				while(i >= 0 && key.compareTo(cur.keys.get(i)) <= 0){
					if(key.compareTo(cur.keys.get(i)) == 0){
						cur.keys.get(i).incFreq();
						fileIO.writeIntoFile(cur, false);
						printOut("Sequence: " + TreeObject.bitsToGene(key.sequence, seqLength) + " Node: " + cur.index + " Frequency++");
						return;
					}
					i--;
				}
				i++;
				
				next = fileIO.readIn(cur.children.get(i), degree);
				if(next.isFull()){
					split(cur, next, i);
					
					if(key.compareTo(cur.keys.get(i)) == 0){
						cur.keys.get(i).incFreq();
						fileIO.writeIntoFile(cur, false);
						printOut("Sequence: " + TreeObject.bitsToGene(key.sequence, seqLength) + " Node: " + cur.index + " Frequency++");
						return;
					}else if(key.compareTo(cur.keys.get(i)) > 0){
						next = fileIO.readIn(cur.children.get(i + 1), degree);
					}
				}
				cur = next;
			}
		}
	}
	
	public int search(String sequence) throws IOException {
		return searchNodeGetFreq(root, new TreeObject(sequence));
	}
	
	private int searchNodeGetFreq(BTreeNode node, TreeObject searchK) throws IOException {
		cur = node;
		boolean searching = true;
		
		while(searching){
			int i = 0;
			
			while(i < cur.keys.size() && searchK.compareTo(cur.keys.get(i)) > 0){
				i++;
			}
			
			if(i < cur.keys.size() && searchK.compareTo(cur.keys.get(i)) == 0){
				return cur.keys.get(i).getFrequency();
			}
			
			if(cur.leaf){
				return 0;
			}else{
				cur = fileIO.readIn(cur.children.get(i), degree);
			}
		}
		
		return -1;
		
	}
	
	public void inOrderTraversal(File dumpFile, String fname) throws IOException {
		FileOutputStream outputFileStream = new FileOutputStream(dumpFile);
		PrintWriter outputStream = new PrintWriter(outputFileStream);
		Stack<Integer> nodes = new Stack<Integer>();
		Stack<Integer> children = new Stack<Integer>();
		
		outputStream.println("Contents inside BTree are from: " + fname);
		outputStream.println("The degree of the BTree is: " + degree);
		outputStream.println("The DNE sequence length is: " + seqLength);
		outputStream.println("The key values are shown is ascending order.");
		outputStream.println();
		outputStream.println("<Freq>\t<DNA Sequence>");
		outputStream.println("------------------------");
		
		boolean traverse = true;
		cur = root;
		int child = 0;
		
		while(traverse){
			if(child == cur.children.size() && !cur.leaf){
				if(nodes.empty() && children.empty()){
					traverse = false;
					continue;
				}else{
					cur = fileIO.readIn(nodes.pop(), degree);
					child = children.pop();
					
					if(child < cur.keys.size()){
						dumpWriteTreeObject(cur.keys.get(child), outputStream);
					}
					child++;
					continue;
				}
			}
			
			if(cur.leaf){
				for(int k = 0; k < cur.keys.size(); k++){
					dumpWriteTreeObject(cur.keys.get(k), outputStream);
				}
				
				if(cur == root)
					break;

				cur = fileIO.readIn(nodes.pop(), degree);
				child = children.pop();
				
				if(child < cur.keys.size()){
					dumpWriteTreeObject(cur.keys.get(child), outputStream);
				}
				child++;
			}else{
				nodes.push(cur.index);
				children.push(child);
				
				cur = fileIO.readIn(cur.children.get(child), degree);
				child = 0;
			}
		}
		outputStream.close();
	}

	private void dumpWriteTreeObject(TreeObject obj, PrintWriter outputStream) throws IOException {
		outputStream.write(obj.getFrequency() + "\t" + TreeObject.bitsToGene(obj.sequence, seqLength));
		outputStream.println();
	}
	
	public void dumpTree() throws IOException {
		fileIO.dumpTree(cur, next, root); 
	}
}