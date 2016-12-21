// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1


/*
 * Creates multiplication or division nodes for the parse tree 
 * so that each node can be eval()-ulated
 */
public class NodeMulop extends Node {

	private String mulop;

	public NodeMulop(int pos, String mulop) {
		this.pos=pos;
		this.mulop=mulop;
	}

	public double op(double o1, double o2) throws EvalException {
		if (mulop.equals("*"))
			return o1*o2;
		if (mulop.equals("/"))
			return o1/o2;
		throw new EvalException(pos,"bogus mulop: "+mulop);
	}

}