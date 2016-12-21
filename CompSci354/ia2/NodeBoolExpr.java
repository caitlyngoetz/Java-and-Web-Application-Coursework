
public class NodeBoolExpr extends Node{
	private NodeExpr one, two;
	private NodeRelop relop;
	
	public NodeBoolExpr(NodeExpr one, NodeRelop relop, NodeExpr two){
		this.one = one;
		this.relop = relop;
		this.two = two;
	}
	
	public double eval(Environment env) throws EvalException {
		return relop.eval(one.eval(env), two.eval(env));
	}
}
