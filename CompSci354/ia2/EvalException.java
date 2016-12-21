public class EvalException extends Exception {

	private int pos;
	private String msg;

	/**
	 * If something is evaluated incorrectly, throw exception.
	 * 
	 * @param pos
	 * @param msg
	 */
	public EvalException(int pos, String msg) {
		this.pos = pos;
		this.msg = msg;
	}

	public String toString() {
		return "eval error" + ", pos=" + pos + ", " + msg;
	}

}
