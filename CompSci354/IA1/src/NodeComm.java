// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1


/*
 * Creates comment nodes for the parse tree 
 * so that each node can be eval()-ulated
 */
public class NodeComm extends Node {

	private String comm;

	public NodeComm(int pos, String comm) {
		this.pos=pos;
		this.comm=comm;
	}

}