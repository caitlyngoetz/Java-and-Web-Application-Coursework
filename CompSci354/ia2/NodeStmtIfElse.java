
public class NodeStmtIfElse extends NodeStmt {

	private NodeBoolExpr boolExpr;
	private NodeStmt ifStmt, elseStmt;

	public NodeStmtIfElse(NodeBoolExpr boolExpr, NodeStmt ifStmt, NodeStmt elseStmt) {
		this.boolExpr = boolExpr;
		this.ifStmt = ifStmt;
		this.elseStmt = elseStmt;
	}

	public double eval(Environment env) throws EvalException {
		double temp = boolExpr.eval(env);
		if (temp == 1)
			return ifStmt.eval(env);
		else
			return elseStmt.eval(env);
	}

}
