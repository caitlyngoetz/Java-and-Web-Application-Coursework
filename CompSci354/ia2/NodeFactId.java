public class NodeFactId extends NodeFact {

	private String id;

	/**
	 * Constructor
	 * 
	 * @param pos
	 * @param id
	 */
	public NodeFactId(int pos, String id) {
		this.pos = pos;
		this.id = id;
	}

	/**
	 * Gets the value of the id
	 */
	public double eval(Environment env) throws EvalException {
		return env.get(pos, id);
	}

}
