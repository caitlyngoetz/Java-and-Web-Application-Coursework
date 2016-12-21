
public class NodeStmtAssn extends NodeStmt {
	
	private String id;
	private NodeExpr expr;
	
	public NodeStmtAssn(String id, NodeExpr expr){
		this.id = id;
		this.expr = expr;
	}
	
	/**
	 * Evaluates the expr and assigns it to the id
	 */
	public double eval(Environment env) throws EvalException {
		return env.put(id, expr.eval(env));
	}

}
