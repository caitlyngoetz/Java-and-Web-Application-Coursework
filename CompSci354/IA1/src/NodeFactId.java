// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1


/*
 * Creates nodes for the parse tree 
 * so that each node can be eval()-ulated
 */
public class NodeFactId extends NodeFact {

	private String id;

	public NodeFactId(int pos, String id) {
		this.pos=pos;
		this.id=id;
	}

	public double eval(Environment env) throws EvalException {
		return env.get(pos,id);
	}

}
