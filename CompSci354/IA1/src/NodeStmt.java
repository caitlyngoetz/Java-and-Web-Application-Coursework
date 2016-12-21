// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1

public class NodeStmt extends Node {

	private Node assn;

	public NodeStmt(Node assn) {
		this.assn=assn;
	}

	public double eval(Environment env) throws Exception {
		return assn.eval(env);
	}

}
