import java.util.ArrayList;

/**
*
* @author scrabtre
* @author cgoetz
*
*/

public class BTreeNode {
	public ArrayList<TreeObject> keys;
	public ArrayList<Integer> children;
	public int parent;
	public int index;
	public int maxNumKeys;
	public boolean root;
	public boolean leaf;
	public int degree;
	
	public BTreeNode(int degree, boolean root, boolean leaf, int index){
		this.degree = degree;
		this.index = index;
		this.root = root;
		this.leaf = leaf;
		if(this.root)
			parent = -1;
		
		maxNumKeys = (degree - 1) * 2;
		keys = new ArrayList<TreeObject>(maxNumKeys);
		children = new ArrayList<Integer>(maxNumKeys + 1);
	}
	
	public boolean isFull(){
		return keys.size() == maxNumKeys;
	}
	
	public int compareTo(BTreeNode tObj){
		return index - tObj.index;
	}
}