import java.util.HashSet;

public class RegEx 
{
	private Parser parser;
	private State begin;
	
	public RegEx(String source)
	{
		if(source.length() != 0)
		{
			this.parser = new Parser(source);
			this.begin = this.parser.startState();
		}
		else
		{
			this.parser = null;
			this.begin = null;
		}
	}
	
	public boolean validateString(String check)
	{
		if(this.begin == null) 
			return false;
		
		return validateString(check, this.begin, this.begin);
	}

	private boolean validateString(String remaining, State current, State previous)
	{
		if(remaining.length() == 0)
		{
			if(current.getEnd())
				return true;
			else
				return moveOnEmptyString(remaining, current, previous);
		}

		StringBuilder transition = new StringBuilder();
		transition.append(remaining.charAt(0));
		
		if(moveOnTransition(remaining.substring(1), current.getTransition(transition.toString())) || moveOnEmptyString(remaining, current, previous))
			return true;
		else
			return false;
	}
	
	private boolean moveOnEmptyString(String remaining, State current, State previous)
	{
		HashSet<State> nextStates = current.getTransition("e");
		if(nextStates != null)
		{
			for(State next : nextStates)
			{
				if(!next.equals(previous) && validateString(remaining, next, current))
					return true;
			}
		}
		
		return false;
	}
	
	private boolean moveOnTransition(String remaining, HashSet<State> nextStates)
	{
		if(nextStates != null)
			for(State next: nextStates)
				if(validateString(remaining, next, next))
					return true;
		
		return false;
	}
}