import java.util.Scanner;

public class NodeRd extends Node {
	
	private Scanner scanner;
	private Double value;
	private String string;
	
	public NodeRd(String str){
		this.string = str;
		scanner = new Scanner(System.in);
	}
	
	public double eval(Environment env) throws EvalException {
		value = scanner.nextDouble();
		return env.put(string, value);
	}
}
