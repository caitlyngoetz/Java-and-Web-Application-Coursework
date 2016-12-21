
public class HuffmanNode {

	HuffmanNode parent;
	HuffmanNode left;
	HuffmanNode right;
	HuffmanData  data;
	//constructor
	public HuffmanNode(HuffmanData newData){
		 data = newData;
		 parent = null;
		 left = null;
		 right= null;
	}
	
	public HuffmanData getData(){
		return data;
	}
	
	public void setParent(HuffmanNode newparent){
		 this.parent = newparent;
	}
	
	public HuffmanNode getRight(){
		return right;	
	}
	
	public void setRight (HuffmanNode right){	
		this.right = right;
	}
	
	public HuffmanNode getLeft(){
		return left;
	}
	
	public void setLeft(HuffmanNode left){
		this.left = left;
	}
}
