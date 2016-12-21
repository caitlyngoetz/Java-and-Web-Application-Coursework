
public class NodeFactExpr extends NodeFact {

	private NodeExpr expr;

	public NodeFactExpr(NodeExpr expr) {
		this.expr = expr;
	}

	/**
	 * Evaluates expr and returns the result
	 */
	public double eval(Environment env) throws EvalException {
		return expr.eval(env);
	}

}
