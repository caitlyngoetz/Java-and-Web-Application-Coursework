
public class NodeStmtWhile extends NodeStmt {
	
	private NodeBoolExpr boolExpr;
	private NodeStmt stmt;
	
	public NodeStmtWhile(NodeBoolExpr boolExpr, NodeStmt stmt){
		this.boolExpr = boolExpr;
		this.stmt = stmt;
	}
	
	public double eval(Environment env) throws EvalException {
		double temp = 0;
		
		while(boolExpr.eval(env) == 1){
			temp = stmt.eval(env);
		}
		
		return temp;
	}

}
