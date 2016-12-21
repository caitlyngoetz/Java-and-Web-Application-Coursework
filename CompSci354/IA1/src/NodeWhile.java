
public class NodeWhile extends Node {
	private NodeBoolExpr bool;
	private NodeStmt stmt;
	
	public NodeWhile(NodeBoolExpr be, NodeStmt stmt){
		this.bool = be;
		this.stmt = stmt;
	}
	
	public double eval(Environment env) throws Exception {
		while(bool.eval(env) == 1.0){
			stmt.eval(env);
		}
		return 1.0;
	}
}
