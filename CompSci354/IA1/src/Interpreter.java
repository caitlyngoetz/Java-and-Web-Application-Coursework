// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1

//This is the main class/method for the interpreter.
//Each command-line argument is a complete program,
//which is scanned, parsed, and evaluated.
//All evaluations share the same environment,
//so they can share variables.

public class Interpreter {

	public static void main(String[] args) throws Exception {
		Parser parser=new Parser();
		Environment env=new Environment();
		for (String stmt: args)
			try {
				System.out.println(parser.parse(stmt).eval(env));
			} catch (SyntaxException e) {
				System.err.println(e);
			} catch (EvalException e) {
				System.err.println(e);
			}
	}

}
