public class NodeFactNum extends NodeFact {

	private String num;

	public NodeFactNum(String num) {
		this.num = num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Node#eval(Environment)
	 * 
	 * Parses the string num into a double
	 */
	public double eval(Environment env) throws EvalException {
		return Double.parseDouble(num);
	}

}
