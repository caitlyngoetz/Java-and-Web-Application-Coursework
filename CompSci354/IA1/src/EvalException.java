// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1

/*
 *This method sets up "exception handling" for the project.
 *So that the output looks fancy 
 */

public class EvalException extends Exception {

	private int pos;
	private String msg;

	public EvalException(int pos, String msg) {
		this.pos=pos;
		this.msg=msg;
	}

	public String toString() {
		return "eval error"
				+", pos="+pos
				+", "+msg;
	}

}