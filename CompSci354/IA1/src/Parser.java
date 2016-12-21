// Name: Caitlyn Goetz
// Class: CS 354 Programming Languages
// Assignment: IA1

//This class is a recursive-descent parser,
//modeled after the programming language's grammar.
//It constructs and has-a Scanner for the program 
//being parsed.

import java.util.*;

public class Parser 
{

	private Scanner scanner;

	private void match(String s) throws SyntaxException 
	{
		scanner.match(new Token(s));
	}

	private Token curr() throws SyntaxException 
	{    
		return scanner.curr();
	}

	private int pos() 
	{
		return scanner.pos();
	}


	//sets up for multiplication or division
	private NodeMulop parseMulop() throws SyntaxException 
	{
		if (curr().equals(new Token("*"))) 
		{
			match("*");
			return new NodeMulop(pos(),"*");
		}

		if (curr().equals(new Token("/"))) 
		{
			match("/");
			return new NodeMulop(pos(),"/");
		}
		return null;
	}

	//Sets up for addition or subtraction
	private NodeAddop parseAddop() throws SyntaxException 
	{
		if (curr().equals(new Token("+"))) 
		{
			match("+");
			return new NodeAddop(pos(),"+");
		}
		if (curr().equals(new Token("-"))) 
		{
			match("-");
			return new NodeAddop(pos(),"-");
		}
		return null;
	}

	private NodeFact parseFact() throws SyntaxException 
	{
		if (curr().equals(new Token("("))) 
		{
			match("(");
			NodeExpr expr=parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}
		if (curr().equals(new Token("id"))) 
		{
			Token id=curr();
			match("id");
			return new NodeFactId(pos(),id.lex());
		}
		Token num=curr();
		match("num");
		return new NodeFactNum(num.lex());
	}

	private NodeTerm parseTerm() throws SyntaxException 
	{
		if(curr().equals(new Token("-")))
		{
			NodeFactNum negativeOne= new NodeFactNum("-1");
			NodeMulop negativeMulop = new NodeMulop(scanner.pos(),"*");
			NodeTerm unary = new NodeTerm(negativeOne, negativeMulop, null);
			match("-");
			NodeTerm term = parseTerm();
			term.append(unary);
			return term;
		}
		
		NodeFact fact=parseFact();
		NodeMulop mulop=parseMulop();
		if (mulop==null)
			return new NodeTerm(fact,null,null);
		NodeTerm term=parseTerm();
		term.append(new NodeTerm(fact,mulop,null));
		return term;
	}

	private NodeExpr parseExpr() throws SyntaxException 
	{
		NodeTerm term=parseTerm();
		NodeAddop addop=parseAddop();
		if (addop==null)
			return new NodeExpr(term,null,null);
		NodeExpr expr=parseExpr();
		expr.append(new NodeExpr(term,addop,null));
		return expr;
	}

	public Node parse(String program) throws SyntaxException 
	{
		scanner=new Scanner(program);
		scanner.next();
		return parseStmt();
	}
	
	private NodeAssn parseAssn() throws SyntaxException {
        Token id = curr();
        match("id");
        match("=");
        NodeExpr expr = parseExpr();
        NodeAssn assn = new NodeAssn(id.lex(), expr);
        return assn;
}

private NodeRd parseRd() throws SyntaxException {
        match("rd");
        Token id = curr();
        match("id");
        NodeRd rd = new NodeRd(id.lex());
        return rd;
}

private NodeWr parseWr() throws SyntaxException {
        match("wr");
        NodeExpr expr = parseExpr();
        NodeWr wr = new NodeWr(expr);
        return wr;
}

private NodeFactIFT parseIFT() throws SyntaxException {
        match("if");
        NodeBoolExpr be = parseBoolExpr();
        match("then");
        NodeStmt stmt = parseStmt();
        if (curr().equals(new Token("else"))) {
                match("else");
                NodeStmt stmt2 = parseStmt();
                NodeFactIFT ift = new NodeFactIFT(be, stmt, stmt2);
                return ift;
        }
        NodeFactIFT ift = new NodeFactIFT(be, stmt, null);
        return ift;
}

private NodeBoolExpr parseBoolExpr() throws SyntaxException {
        NodeExpr expr = parseExpr();
        NodeRelop relop = parseRelop();
        NodeExpr expr2 = parseExpr();
        NodeBoolExpr be = new NodeBoolExpr(expr, relop, expr2);
        return be;
}
private NodeRelop parseRelop() throws SyntaxException {
    if (curr().equals(new Token("<"))) {
            match("<");
            return new NodeRelop(pos(), "<");
    } else if (curr().equals(new Token(">"))) {
            match(">");
            return new NodeRelop(pos(), ">");
    } else if (curr().equals(new Token("<="))) {
            match("<=");
            return new NodeRelop(pos(), "<=");
    } else if (curr().equals(new Token(">="))) {
            match(">=");
            return new NodeRelop(pos(), ">=");
    } else if (curr().equals(new Token("<>"))) {
            match("<>");
            return new NodeRelop(pos(), "<>");
    } else if (curr().equals(new Token("=="))) {
            match("==");
            return new NodeRelop(pos(), "==");
    } else
            return null;
}

private NodeWhile parseWhile() throws SyntaxException {
    match("while");
    NodeBoolExpr be = parseBoolExpr();
    match("do");
    NodeStmt stmt = parseStmt();
    NodeWhile wh = new NodeWhile(be, stmt);
    return wh;
}

private NodeBegin parseBegin() throws SyntaxException {
    match("begin");
    NodeBlock block = parseBlock();
    match("end");
    NodeBegin beg = new NodeBegin(block);
    return beg;
}
private NodeStmt parseStmt() throws SyntaxException {

    if (curr().equals(new Token("rd"))) {
            NodeRd rd = parseRd();
            //match(";");
            NodeStmt stmt = new NodeStmt(rd);
            return stmt;
    } else if (curr().equals(new Token("wr"))) {
            NodeWr input = parseWr();
            //match(";");
            NodeStmt stmt = new NodeStmt(input);
            return stmt;
    } else if (curr().equals(new Token("if"))) {
            NodeFactIFT ifThen = parseIFT();
            NodeStmt stmt = new NodeStmt(ifThen);
            return stmt;
    } else if (curr().equals(new Token("while"))) {
            NodeWhile wh = parseWhile();
            NodeStmt stmt = new NodeStmt(wh);
            return stmt;
    } else if (curr().equals(new Token("begin"))) {
            NodeBegin beg = parseBegin();
            NodeStmt stmt = new NodeStmt(beg);
            return stmt;
    }

    NodeAssn assn = parseAssn();
    match(";"); // not sure if needed
    NodeStmt stmt = new NodeStmt(assn);
    return stmt;
}

/**
* First approach took, but it was not properly working
* 
* @return
* @throws SyntaxException
*/
private NodeBlock parseBlock() throws SyntaxException {
    NodeStmt stmt = parseStmt();
    System.out.println(curr());
    if(curr().equals(new Token(";"))){
            System.out.println("Next -> block");
            match(";");
            NodeBlock block1 = parseBlock();
            NodeBlock block2 = new NodeBlock(stmt, block1);
            return block2;
    }
    NodeBlock block2 = new NodeBlock(stmt, null);
    return block2;
}


}