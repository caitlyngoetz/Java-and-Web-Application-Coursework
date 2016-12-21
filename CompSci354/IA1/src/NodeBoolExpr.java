
public class NodeBoolExpr extends Node {
	private NodeExpr exprA, exprB;
	private NodeRelop relop;
	
	public NodeBoolExpr(NodeExpr expr1, NodeRelop relop, NodeExpr expr2){
		this.exprA = expr1;
		this.relop = relop;
		this.exprB = expr2;
	}
	public double eval(Environment env) throws Exception {
		return relop.eval(exprA.eval(env), exprB.eval(env));
	}
}
