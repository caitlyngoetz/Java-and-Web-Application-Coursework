
public class NodeStmtWr extends NodeStmt {

	private NodeExpr expr;

	public NodeStmtWr(NodeExpr expr) {
		this.expr = expr;
	}

	public double eval(Environment env) throws EvalException {
		double temp = expr.eval(env);
		System.out.print(temp);
		return temp;
	}
}
