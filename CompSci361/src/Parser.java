import java.util.HashSet;
import java.util.Hashtable;

public class Parser 
{
	private final String EMPTY = "e";
	
	private Scan scan;
	private State start, current;
	private int count;

	public Parser(String source)
	{	
		this(Scan.convert(source), 0);
	}
	
	public Parser(String source, int count)
	{
		this.count = count;
		switch(source.length())
		{
			case 0: 
				this.start = new State(this.count++, true, false);
				break;
			case 1: 
				this.start = new State(this.count++, true, false);
				this.current  = new State(this.count++, false, true);
				this.start.addTransition(source, current);
				break;
			default: 
				this.scan = new Scan(source);
				this.start = new State(this.count++, true, true);
				this.current = this.start;
				this.parse();
				break;
		}
	}

	public State startState()
	{
		return this.start;
	}
	
	public int currentStateNumber()
	{
		return this.count;
	}
	
 	private void parse()
	{
		while(scan.hasNext())
		{
			String token = scan.next();
			
			if(token.startsWith("("))
			{
				NFA nfa = parseInnerNFA(token);
				current.addTransition(EMPTY, nfa.start);
				current.setEnd(false);
				nfa.start.setStart(false);
				current = nfa.end;
			}
			else if(token.length() == 1)
				addSingleState(token);
			else 
				addRepeatedSingleState(token);
		}
	}
 	
	private void move(HashSet<State> states, State s)
	{
		Hashtable<String, HashSet<State>> transitions = s.getTransitions();
		for(String key : transitions.keySet())
		{
			for(State state : transitions.get(key))
			{
				if(!states.contains(state))
				{
					states.add(state);
					move(states, state);
				}
			}
		}
	}
	
	private void addSingleState(String tok)
	{
		State q = new State(count++, false, true);
		current.addTransition(tok, q);
		current.setEnd(false);
		current = q;
	}
	
	private void addRepeatedSingleState(String tok)
	{
		String transition = "" + tok.charAt(0);
		String repeater   = "" + tok.charAt(1);
		
		if(repeater.equals("+"))
		{
			State q = new State(count++, false, true);
			q.addTransition(transition, q);
			
			current.addTransition(transition, q);
			current.setEnd(false);
			current = q;
		}
		else
		{
			current.addTransition(transition, current);
		}
	}

	public String toString()
	{
		HashSet<State> states = new HashSet<State>();
		states.add(start);
		move(states, start);
		
		StringBuilder str = new StringBuilder();
		for(State s : states)
			str.append(s.toString() + "\n");
		
		return str.toString();
	}
	
	private NFA parseInnerNFA(String token)
	{
		String sub = null;
		String repeater = null;
		
		if(token.endsWith(")"))
			sub = token.substring(1, token.length() - 1);
		else{
			sub = token.substring(1, token.length() - 2);
			repeater = token.substring(token.length() - 1);
		}
		
		Parser p = new Parser(sub, count);
		count = p.currentStateNumber();
		
		NFA nfa = p.getNFA();
		
		if(repeater != null)
		{
			switch(repeater)
			{
				case "*":
					nfa.start.addTransition(EMPTY, nfa.end);
					nfa.end.addTransition(EMPTY, nfa.start);
					break;
				case "+": 
					nfa.end.addTransition(EMPTY, nfa.start);
					break;
			}
		}
		
		if(scan.hasNext()){
			String next = scan.next();
			if(next.equals("|"))
				nfa = connectOrOpp(nfa, parseInnerNFA(scan.next()));	
			else
				scan.prev();
		}
		
		return nfa;
	}
		
	private NFA connectOrOpp(NFA left, NFA right)
	{
		State newBegin = new State(count++, true, false);
		State newEnd   = new State(count++, false, true);
		
		State oldLeftBegin  = left.start;
		oldLeftBegin.setStart(false);
		
		State oldRightBegin = right.start;
		oldRightBegin.setStart(false);
		
		State oldLeftEnd  = left.end;
		oldLeftEnd.setEnd(false);
		oldLeftEnd.addTransition(EMPTY, newEnd);
		
		State oldRightEnd = right.end;
		oldRightEnd.setEnd(false);
		oldRightEnd.addTransition(EMPTY, newEnd);
		
		newBegin.addTransition(EMPTY, oldLeftBegin);
		newBegin.addTransition(EMPTY, oldRightBegin);
		
		return new NFA(newBegin, newEnd);
	}

	private NFA getNFA()
	{
		return new NFA(start, current);
	}
	
	private class NFA
	{
		public State start, end;
		public NFA(State start, State end)
		{
			this.start = start;
			this.end = end;
		}
	}
}
