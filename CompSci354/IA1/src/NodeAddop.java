// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1


/*
 * Creates nodes for the parse tree 
 * so that each node can be eval()-ulated
 */
public class NodeAddop extends Node {

	private String addop;

	public NodeAddop(int pos, String addop) {
		this.pos=pos;
		this.addop=addop;
	}

	public double op(double o1, double o2) throws EvalException {
		if (addop.equals("+"))
			return o1+o2;
		if (addop.equals("-"))
			return o1-o2;
		throw new EvalException(pos,"bogus addop: "+addop);
	}

}