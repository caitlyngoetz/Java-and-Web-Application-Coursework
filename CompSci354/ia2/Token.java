// This class models a token, which has two parts:
// either the token itself (e.g., "id" or "+")
// or the token's lexeme (e.g., "foo")

public class Token {

	private String token;
	private String lex;

	public Token(String token, String lexeme) {
		this.token = token;
		this.lex = lexeme;
	}

	/**
	 * 
	 * @param token
	 */
	public Token(String token) {
		this(token, token);
	}

	/**
	 * 
	 * @return token type
	 */
	public String tok() {
		return token;
	}

	/**
	 * 
	 * @return token
	 */
	public String lex() {
		return lex;
	}

	/**
	 * Compares token against the param token t
	 * @param t
	 * @return true (if equal) otherwise false
	 */
	public boolean equals(Token t) {
		return token.equals(t.token);
	}

	public String toString() {
		return "<" + tok() + "," + lex() + ">";
	}

}
