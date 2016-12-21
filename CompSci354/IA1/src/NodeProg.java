
public class NodeProg extends Node {
	private NodeBlock block;
	
	public NodeProg(NodeBlock block) {
		this.block = block;
	}
	
	public double eval(Environment env) throws Exception {
		return block.eval(env);
	}
}
