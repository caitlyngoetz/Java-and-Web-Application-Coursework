import java.util.Scanner;

public class NodeStmtRd extends NodeStmt {

	private String id;
	private int pos;

	public NodeStmtRd(String id, int pos) {
		this.id = id;
		this.pos = pos;
	}

	public double eval(Environment env) throws EvalException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print(id + "=");
		String read = scanner.nextLine();

		try {
			double result = Double.parseDouble(read);
			return env.put(id, result);
		} catch (NumberFormatException e) {
			throw new EvalException(pos, read);
		}
	}
}
