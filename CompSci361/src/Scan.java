
public class Scan {

	private char[] letters;
	private int position;
	private String previous;

	public Scan(String source)
	{
		this.letters = source.toCharArray();
		this.position = 0;
		this.previous = "";
	}

	public boolean hasNext()
	{
		return position < letters.length;
	}

	private String parsePar()
	{
		StringBuilder str = new StringBuilder();

		char curr = letters[position++];
		str.append(curr);

		while(hasNext() && curr != ')')
		{
			curr = letters[position];
			if(curr == '(')
			{
				str.append(next());
				curr = letters[position];
				if(curr == ')')
				{
					str.append(')');
					position++;
				}
			}
			else
			{
				str.append(curr);
				position++;
			}
		}

		return str.toString();
	}

	public String prev()
	{
		position -= previous.length();
		return previous;
	}


	public String next()
	{
		StringBuilder str = new StringBuilder();

		char current = letters[position];
		switch(current)
		{
		case '|':
			position++;
			str.append(current);
			break;

		case '(':
			str.append(parsePar());

			if(hasNext())
			{
				current = letters[position];
				if(current == '*' || current == '+')
				{
					str.append(current);
					position++;
				}
			}
			break;

		default:
			str.append(current);
			position++;
			if(hasNext())
			{
				char next = letters[position];
				if(next == '+' || next == '*')
				{
					position++;
					str.append(next);
				}
			}
			break;
		}

		this.previous = str.toString();

		return str.toString();
	}

	public static String convert(String str)
	{
		StringBuilder result = new StringBuilder();
		result.append("(");

		for(char c : str.toCharArray())
		{
			switch(c)
			{
				case '(':
					result.append("((");
					break;
				case ')':
					result.append("))");
					break;
				case '|':
					result.append(")|(");
					break;
				default:
					result.append(c);
					break;
			}
		}

		return result.append(")").toString();
	}

}
