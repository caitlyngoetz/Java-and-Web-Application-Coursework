public class NodeExpr extends Node {

    private NodeTerm term;
    private NodeAddop addop;
    private NodeExpr expr;

    public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) {
		this.term = term;
		this.addop = addop;
		this.expr = expr;
    }

    /**
     * Adds an expr and addop to the current term
     * or if there's already an expr, it appends it to the original expr.
     * @param expr
     */
    public void append(NodeExpr expr) {
    	if (this.expr==null) {
    		this.addop=expr.addop;
    		this.expr=expr;
    		expr.addop=null;
    	} else
    		this.expr.append(expr);
    }

    /**
     * If the expr is null, evaluate the term. If it isn't, evaluate the expr and term for the addop.
     */
    public double eval(Environment env) throws EvalException {
    	if(expr == null)
    		return term.eval(env);
    	else
    		return addop.op(expr.eval(env),term.eval(env));
    }

}
