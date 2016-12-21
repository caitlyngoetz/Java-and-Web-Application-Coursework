
public class NodeStmtIf extends NodeStmt {

	private NodeBoolExpr boolExpr;
	private NodeStmt stmt;

	public NodeStmtIf(NodeBoolExpr boolExpr, NodeStmt stmt) {
		this.boolExpr = boolExpr;
		this.stmt = stmt;
	}

	public double eval(Environment env) throws EvalException {
		double temp = boolExpr.eval(env);
		if (temp == 1)
			return stmt.eval(env);
		return -1;
	}

}
