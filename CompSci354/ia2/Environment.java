import java.util.Hashtable;

// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

public class Environment {

	private Hashtable<String, Double> variables = new Hashtable<String, Double>();

	/**
	 * Stores val into var or updates val with var.
	 * 
	 * @param var
	 * @param val
	 * @return val
	 */
	public double put(String var, double val) {
		if (variables.containsKey(var)) {
			variables.remove(var);
		}
		variables.put(var, val);
		return val;
	}

	/**
	 * If var exists, return val, else return pos.
	 * 
	 * @param pos
	 * @param var
	 * @return value of var or pos
	 * @throws EvalException
	 */
	public double get(int pos, String var) throws EvalException {
		if (variables.containsKey(var))
			return variables.get(var);

		return pos;
	}

}
