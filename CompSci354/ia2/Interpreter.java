// This is the main class/method for the interpreter.
// Each command-line argument is a complete program,
// which is scanned, parsed, and evaluated.
// All evaluations share the same environment,
// so they can share variables.

public class Interpreter {

	public static void main(String[] args) {
		Parser parser = new Parser();
		Environment env = new Environment();

		StringBuilder stmt = new StringBuilder();
		for (String s : args)
			try {
				NodeBlock n = (NodeBlock) parser.parse(s.trim());
				n.eval(env);
			} catch (SyntaxException e) {
				System.err.println(e);
			} catch (EvalException e) {
				System.err.println(e);
			}
	}

}
