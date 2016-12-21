
// This class is a scanner for the program
// and programming language being interpreted.

import java.util.*;

public class Scanner {

	private String program; // source program being interpreted
	private int pos; // index of next char in program
	private Token token; // last/current scanned token

	// sets of various characters and lexemes
	private Set<String> whitespace = new HashSet<String>();
	private Set<String> digits = new HashSet<String>();
	private Set<String> letters = new HashSet<String>();
	private Set<String> legits = new HashSet<String>();
	private Set<String> keywords = new HashSet<String>();
	private Set<String> operators = new HashSet<String>();
	private Set<String> comments = new HashSet<String>();
	private Set<String> relops = new HashSet<String>();

	// initializers for previous sets

	/**
	 * Adds chars "lo" to "hi" to Set s
	 * 
	 * @param s
	 * @param lo
	 * @param hi
	 */
	private void fill(Set<String> s, char lo, char hi) {
		for (char c = lo; c <= hi; c++)
			s.add(c + "");
	}

	/**
	 * Adds space, new line, and a tag to Set s
	 * 
	 * @param s
	 */
	private void initWhitespace(Set<String> s) {
		s.add(" ");
		s.add("\n");
		s.add("\t");
	}

	/**
	 * Fills Set s with digits 0-9
	 * 
	 * @param s
	 */
	private void initDigits(Set<String> s) {
		fill(s, '0', '9');
		digits.add(".");
	}

	/**
	 * Fills Set s with letter A-Z and a-z
	 * 
	 * @param s
	 */
	private void initLetters(Set<String> s) {
		fill(s, 'A', 'Z');
		fill(s, 'a', 'z');
	}

	/**
	 * Fills Set s with digits and letters
	 * 
	 * @param s
	 */
	private void initLegits(Set<String> s) {
		s.addAll(letters);
		s.addAll(digits);
	}

	/**
	 * Adds initial operators to Set s
	 * 
	 * @param s
	 */
	private void initOperators(Set<String> s) {
		s.add("=");
		s.add("+");
		s.add("-");
		s.add("*");
		s.add("/");
		s.add("(");
		s.add(")");
		s.add(";");
	}

	/**
	 * Adds keywords to Set s
	 * 
	 * @param s
	 */
	private void initKeywords(Set<String> s) {
		s.add("rd"); //read
		s.add("wr"); //write
		s.add("if");
		s.add("then");
		s.add("else");
		s.add("while");
		s.add("do");
		s.add("begin");
		s.add("end");
	}

	/**
	 * Adds comment symbol to Set s
	 * 
	 * @param s
	 */
	private void initComments(Set<String> s) {
		s.add("#");
	}

	private void initRelops(Set<String> s) {
		s.add("<");
		s.add("<=");
		s.add(">");
		s.add(">=");
		s.add("<>");
		s.add("==");
	}

	// constructor:
	// - squirrel-away source program
	// - initialize sets
	public Scanner(String program) {
		this.program = program;
		pos = 0;
		token = null;
		initWhitespace(whitespace);
		initDigits(digits);
		initLetters(letters);
		initLegits(legits);
		initKeywords(keywords);
		initOperators(operators);
		initComments(comments);
		initRelops(relops);
	}

	// handy string-processing methods

	/**
	 * Compars pos to program length
	 * 
	 * @return true or false
	 */
	public boolean done() {
		return pos >= program.length();
	}

	/**
	 * Moves pos forward if the charAt currPos is not in Set s
	 * 
	 * @param s
	 */
	private void many(Set<String> s) {
		while (!done() && s.contains(program.charAt(pos) + ""))
			pos++;
	}

	/**
	 * Moves pos forward if char c isn't at currPos. Also checks again to see if
	 * next/new pos is c.
	 * 
	 * @param c
	 */
	private void past(char c) {
		while (!done() && c != program.charAt(pos))
			pos++;
		if (!done() && c == program.charAt(pos))
			pos++;
	}

	// scan various kinds of lexeme

	/**
	 * Keeps "old" position and calls the set digits to get length of currNum
	 */
	private void nextNumber() {
		int old = pos;
		many(digits);
		if (program.charAt(pos) == '.') {
			pos++;
			many(digits);
		}

		token = new Token("num", program.substring(old, pos));
	}

	/**
	 * Saves "old" position and calls it with the Sets digits and letters
	 */
	private void nextKwId() {
		int old = pos;
		many(letters);
		many(legits);
		String lexeme = program.substring(old, pos);
		token = new Token((keywords.contains(lexeme) ? lexeme : "id"), lexeme);
	}

	/**
	 * Checks for the next operator Things like "++"
	 */
	private void nextOp() {
		int old = pos;

		// add code to take care of relop
		if (program.charAt(pos) == '=' && program.charAt(pos + 1) == '=') {
			pos += 2;
			token = new Token("relop", program.substring(old, pos));
			return;
		}

		pos = old + 2;
		if (!done()) {
			String lexeme = program.substring(old, pos);
			if (operators.contains(lexeme)) {
				token = new Token(lexeme); // two-char operator
				return;
			}
		}
		pos = old + 1;
		String lexeme = program.substring(old, pos);
		token = new Token(lexeme); // one-char operator
	}

	/**
	 * Checks for end of comments
	 */
	private void endComment() {
		pos++;
		past('#');
	}

	/**
	 * Checks whether a '-' is a subtraction sign or a negative sign
	 */
	private void nextNegative() {
		String pre = program.charAt(pos - 1) + "";
    	String post = program.charAt(pos + 1) + "";
    	int old = 0;
    	
    	if(comments.contains(pre)){
    		pos++;
    		token = new Token("-");
    		return;
    	}
    	
    	if(digits.contains(pre) || letters.contains(pre)){ //checks for a digit before '-'
    		if(digits.contains(post)){							 //checks for a digit after '-' 
    			nextOp();										 //if there are digits on both sides, it's a minus
    		}else if(post.equals("(") || letters.contains(post) || post.equals("-")){	//if there isn't a digit after, check to see if it's a '(', letter, or '-'
    			pos++;
    			token = new Token("-"); //if it is, make it a new token
    		}else{
    			System.err.println("illegal character at position " + pos); 
    			System.exit(1);
    		}
    	}else{ 
    		if(digits.contains(post)){ //if pre wasn't a digit, check if post is a digit
    			old = pos++;
    			nextNumber();	//if it is, get the whole number and include the '-' in the token
    			token = new Token("num", program.substring(old, pos));
    		}else if(comments.contains(post)){ //if post isn't a digit, check if it's a comment
    			pos++;
    			String tmp = program.charAt(pos)+"";
    			if(digits.contains(tmp)){ //checks to see if pos after comment is a digit
    				old = pos; 
    				nextNumber(); //if it is, get the whole number and include the '-' in the token
    				token = new Token("num", "-" + program.substring(old, pos));
    			}else if(letters.contains(tmp) || tmp.equals("(")){	//if post wasn't a comment, check if it's a letter or '('
    				token = new Token("-"); //if it is, make '-' a separate token
    			}else{
    				System.err.println("illegal character at position " + pos);
        			System.exit(1);
    			}
    		}else if(letters.contains(post) || post.equals("(") || post.equals("-")){ //if it wasn't a digit or a comment check to see if it was '(', letter, or '-'
    			pos++;
    			token = new Token("-"); //if so '-' is a separate token. 
    		}else{
    			System.err.println("illegal character at position " + pos); 
    			System.exit(1);
    		}
    	}
	}

	// This method determines the kind of the next token (e.g., "id"),
	// and calls a method to scan that token's lexeme (e.g., "foo").
	public boolean next() {
		if (done())
			return false;
		many(whitespace);
		String c = program.charAt(pos) + "";

		if (c.equals("-"))
			nextNegative();
		else if (digits.contains(c))
			nextNumber();
		else if (letters.contains(c))
			nextKwId();
		else if (operators.contains(c))
			nextOp();
		else if (comments.contains(c)) {
			endComment();
			return next();
		} else if (relops.contains(c))
			nextRelop();
		else {
			System.err.println("illegal character at position " + pos);
			pos++;
			return next();
		}
		return true;
	}

	private void nextRelop() {
		int old = pos;
		pos += 2;
		String lex = program.substring(old, pos);
		if (!relops.contains(lex)) {
			pos--;
			lex = program.substring(old, pos);
		}
		token = new Token("relop", lex);
	}

	// This method scans the next lexeme,
	// if the current token is the expected token.
	public void match(Token t) throws SyntaxException {
		if (!t.equals(curr()))
			throw new SyntaxException(pos, t, curr());
		next();
	}

	/**
	 * Returns the correct token, or if there isn't one, it throws a
	 * syntaxexception
	 * 
	 * @return token
	 * @throws SyntaxException
	 */
	public Token curr() throws SyntaxException {
		if (token == null)
			throw new SyntaxException(pos, new Token("ANY"), new Token("EMPTY"));
		return token;
	}

	/**
	 * Position of scanner
	 * 
	 * @return position of scanner
	 */
	public int pos() {
		return pos;
	}

	// for unit testing
	public static void main(String[] args) {
		StringBuilder stmt = new StringBuilder();
		for (String s : args) {
			stmt.append(s);
		}

		try {
			Scanner scanner = new Scanner(stmt.toString());
			while (scanner.next())
				System.out.println(scanner.curr());
		} catch (SyntaxException e) {
			System.err.println(e);
		}
	}

}
