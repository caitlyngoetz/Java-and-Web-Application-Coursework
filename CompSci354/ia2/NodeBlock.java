
public class NodeBlock extends Node {
	private NodeStmt stmt;
	private NodeBlock block;

	public NodeBlock() {

	}

	public NodeBlock(NodeStmt stmt, NodeBlock block) {
		this.stmt = stmt;
		this.block = block;
	}

	public Boolean hasAnother() {
		return block != null;
	}

	public NodeBlock getNextBlock() {
		return block;
	}

	public NodeStmt getStmt() {
		return stmt;
	}

	public double eval(Environment env) throws EvalException {
		double temp = stmt.eval(env);
		if (block != null)
			return block.eval(env);
		else
			return temp;
	}

}
