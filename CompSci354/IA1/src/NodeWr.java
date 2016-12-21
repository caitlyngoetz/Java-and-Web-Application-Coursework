
public class NodeWr extends Node {
	private NodeExpr expr;
	
	public NodeWr(NodeExpr expr){
		this.expr = expr;
	}
	
	public double eval(Environment env) throws Exception {
		System.out.println(expr.eval(env));
		return 0.0;
	}
}
