
public class NodeBegin extends Node {
	private NodeBlock nodeBlock;
	
	public NodeBegin(NodeBlock nb){
		this.nodeBlock = nb;
	}
	
	public double eva (Environment env) throws Exception {
		return nodeBlock.eval(env);
	}
}
