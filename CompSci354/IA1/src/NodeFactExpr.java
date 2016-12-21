// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1

/*
 * Creates nodes for the parse tree 
 * so that each node can be eval()-ulated
 */
public class NodeFactExpr extends NodeFact {

	private NodeExpr expr;

	public NodeFactExpr(NodeExpr expr) {
		this.expr=expr;
	}

	public double eval(Environment env) throws Exception {
		return expr.eval(env);
	}

}
