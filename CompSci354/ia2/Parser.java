
// This class is a recursive-descent parser,
// modeled after the programming language's grammar.
// It constructs and has-a Scanner for the program
// being parsed.

import java.util.*;

public class Parser {

	private Scanner scanner;

	/**
	 * Checks string against current token
	 * 
	 * @param s
	 * @throws SyntaxException
	 */
	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

	/**
	 * Gets the current token
	 * 
	 * @return current token
	 * @throws SyntaxException
	 */
	private Token curr() throws SyntaxException {
		return scanner.curr();
	}

	/**
	 * Scanner's position
	 * 
	 * @return scanner's current position
	 */
	private int pos() {
		return scanner.pos();
	}

	/**
	 * Sets up mulop part of the grammar. Could be multiplication or division.
	 * 
	 * @return mulop of grammar
	 * @throws SyntaxException
	 */
	private NodeMulop parseMulop() throws SyntaxException {
		if (curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(pos(), "*");
		}
		if (curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(pos(), "/");
		}
		return null;
	}

	/**
	 * Sets up the addop part of the grammar. Could be addition or subtraction
	 * 
	 * @return addop of grammar
	 * @throws SyntaxException
	 */
	private NodeAddop parseAddop() throws SyntaxException {
		if (curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(pos(), "+");
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(pos(), "-");
		}
		return null;
	}

	/**
	 * Sets up fact part of grammar. Could be an id, num, expr, or '-' fact
	 * 
	 * @return fact part of grammar
	 * @throws SyntaxException
	 */
	private NodeFact parseFact() throws SyntaxException {
		if (curr().equals(new Token("("))) {
			match("(");
			NodeExpr expr = parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}

		if (curr().equals(new Token("-"))) {
			match("-");
			NodeFact fact = parseFact();
			return new NodeFactNeg(fact);
		}

		if (curr().equals(new Token("id"))) {
			Token id = curr();
			match("id");
			return new NodeFactId(pos(), id.lex());
		}
		Token num = curr();
		match("num");
		return new NodeFactNum(num.lex());
	}

	/**
	 * Sets up term part of grammar Could be a fact, or fact mulop term
	 * 
	 * @return term part of grammar
	 * @throws SyntaxException
	 */
	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact = parseFact();
		NodeMulop mulop = parseMulop();
		if (mulop == null)
			return new NodeTerm(fact, null, null);
		NodeTerm term = parseTerm();
		term.append(new NodeTerm(fact, mulop, null));
		return term;
	}

	/**
	 * Sets up expr part of grammar Could be a term, or term addop expr
	 * 
	 * @return expr part of grammar
	 * @throws SyntaxException
	 */
	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
			return new NodeExpr(term, null, null);
		NodeExpr expr = parseExpr();
		expr.append(new NodeExpr(term, addop, null));
		return expr;
	}

	/**
	 * Gets current token and makes sure the id and sign match each other.
	 * 
	 * @return
	 * @throws SyntaxException
	 */
	private NodeStmtAssn parseAssn() throws SyntaxException {
		Token id = curr();
		match("id");
		match("=");
		NodeExpr expr = parseExpr();
		NodeStmtAssn assn = new NodeStmtAssn(id.lex(), expr);
		return assn;
	}

	/**
	 * Calls parseAssn() and checks to see if line ends in ; by calling match().
	 * 
	 * @return stmt
	 * @throws SyntaxException
	 */
	private NodeStmt parseStmt() throws SyntaxException {

		if (curr().equals(new Token("rd"))) {
			scanner.next();
			NodeStmtRd rd = new NodeStmtRd(curr().lex(), pos() - 1);
			scanner.next();
			return rd;
		}

		if (curr().equals(new Token("wr"))) {
			scanner.next();
			return new NodeStmtWr(parseExpr());
		}

		if (curr().equals(new Token("if"))) {
			scanner.next();
			NodeBoolExpr boolexpr = parseBoolExpr();
			match("then");
			NodeStmt ifStmt = parseStmt();

			if (curr().equals(new Token("else"))) {
				scanner.next();
				NodeStmt elseStmt = parseStmt();
				return new NodeStmtIfElse(boolexpr, ifStmt, elseStmt);
			} else {
				return new NodeStmtIf(boolexpr, ifStmt);
			}
		}

		if (curr().equals(new Token("while"))) {
			scanner.next();
			NodeBoolExpr boolexpr = parseBoolExpr();
			match("do");
			NodeStmt stmt = parseStmt();
			return new NodeStmtWhile(boolexpr, stmt);
		}

		if (curr().equals(new Token("begin"))) {
			scanner.next();
			NodeBlock block = parseBlock();
			NodeStmtBegin begin = new NodeStmtBegin(block);
			match("end");
			return begin;
		}

		return parseAssn();
	}

	private NodeBoolExpr parseBoolExpr() throws SyntaxException{
		NodeExpr one = parseExpr();
		NodeRelop relop = parseRelop();
		NodeExpr two = parseExpr();
		return new NodeBoolExpr(one, relop, two);
	}

	private NodeRelop parseRelop() throws SyntaxException{
		NodeRelop relop = new NodeRelop(scanner.pos(), curr().lex());
		scanner.next();
		return relop;
	}

	private NodeBlock parseBlock() throws SyntaxException {
		NodeBlock mainBlock = null;
		NodeStmt stmt = parseStmt();

		if (curr().equals(new Token(";"))) {
			if (!scanner.done())
				scanner.next();
			else
				throw new SyntaxException(scanner.pos(), new Token("stmt"), new Token("Program end."));

			NodeBlock block = parseBlock();
			mainBlock = new NodeBlock(stmt, block);
		} else {
			mainBlock = new NodeBlock(stmt, null);
		}
		return mainBlock;
	}

	/**
	 * Takes in program, sets scanner on first word/token and calls parseStmt().
	 * 
	 * @param program
	 * @return
	 * @throws SyntaxException
	 */
	public Node parse(String program) throws SyntaxException {
		scanner = new Scanner(program);
		scanner.next();
		return parseBlock();
	}

}
