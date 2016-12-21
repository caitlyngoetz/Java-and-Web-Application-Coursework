public class NodeAddop extends Node {

	private String addop;

	public NodeAddop(int pos, String addop) {
		this.pos = pos;
		this.addop = addop;
	}

	/**
	 * Adds or subtracts the given doubles depending on the val of the addop
	 * 
	 * @param o1
	 * @param o2
	 * @return result
	 * @throws EvalException
	 */
	public double op(double o1, double o2) throws EvalException {
		if (addop.equals("+"))
			return o1 + o2;
		if (addop.equals("-"))
			return o1 - o2;
		throw new EvalException(pos, "bogus addop: " + addop);
	}

}
