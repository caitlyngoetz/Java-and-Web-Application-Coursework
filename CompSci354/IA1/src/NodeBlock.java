
public class NodeBlock extends Node {
	private NodeStmt stmt;
	private NodeBlock block;
	
	public NodeBlock(NodeStmt stmt, NodeBlock blockB) {
		this.stmt = stmt;
		this.block = blockB;
	}
	
	public double eval(Environment env) throws Exception {
		if(block != null){
			return block.eval(env);
		}
		return stmt.eval(env);
	}
}
