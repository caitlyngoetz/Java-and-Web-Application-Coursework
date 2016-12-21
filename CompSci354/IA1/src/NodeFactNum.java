// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1


/*
 * Creates nodes for the parse tree 
 * so that each node can be eval()-ulated
 */
public class NodeFactNum extends NodeFact {

	private String num;

	public NodeFactNum(String num) {
		this.num=num;
	}

	public double eval(Environment env) throws EvalException {
		return Double.parseDouble(num);
	}

}
