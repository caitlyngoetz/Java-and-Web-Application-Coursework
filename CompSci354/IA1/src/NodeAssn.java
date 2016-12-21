// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1


/*
 * Creates nodes for the parse tree 
 * so that each node can be eval()-ulated
 */
public class NodeAssn extends Node {

	private String id;
	private NodeExpr expr;

	public NodeAssn(String id, NodeExpr expr) {
		this.id=id;
		this.expr=expr;
	}

	public double eval(Environment env) throws Exception {
		return env.put(id,expr.eval(env));
	}

}