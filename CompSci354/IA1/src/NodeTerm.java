// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1


/*
 * Creates nodes for the parse tree 
 * so that each node can be eval()-ulated
 */
public class NodeTerm extends Node {

	private NodeFact fact;
	private NodeMulop mulop;
	private NodeTerm term;

	public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
		this.fact=fact;
		this.mulop=mulop;
		this.term=term;
	}

	public void append(NodeTerm term) {
		if (this.term==null) {
			this.mulop=term.mulop;
			this.term=term;
			term.mulop=null;
		} else
			this.term.append(term);
	}

	public double eval(Environment env) throws Exception {
		return term==null
				? fact.eval(env)
						: mulop.op(term.eval(env),fact.eval(env));
	}

}