import java.util.HashSet;
import java.util.Hashtable;

public class State 
{
	private int name;
	private boolean begin, end;
	private Hashtable<String, HashSet<State>> transitions;
	
	public State(int stateName)
	{
		this(stateName, false, false);
	}
	
	public State(int stateName, boolean begin, boolean end)
	{
		this.name = stateName;
		this.begin = begin;
		this.end = end;
		this.setTransitions(new Hashtable<String, HashSet<State>>());
	}
	
	public int getStateName()
	{
		return this.name;
	}
	
	public void setStateName(int stateName)
	{
		this.name = stateName;
	}
	
	public boolean getStart()
	{
		return this.begin;
	}
	
	public void setStart(boolean start)
	{
		this.begin = start;
	}
	
	public boolean getEnd()
	{
		return this.end;
	}
	
	public void setEnd(boolean end)
	{
		this.end = end;
	}

	public Hashtable<String, HashSet<State>> getTransitions() {
		return transitions;
	}

	public void setTransitions(Hashtable<String, HashSet<State>> transitions) {
		this.transitions = transitions;
	}
	
	public void addTransition(String transition, State nextState)
	{
		if(this.transitions.containsKey(transition)) //if table has the transition
		{
			this.transitions.get(transition).add(nextState);
		}else{
			HashSet<State> newSet = new HashSet<State>();
			newSet.add(nextState);
			this.transitions.put(transition, newSet);
		}
	}
	
	public HashSet<State> getTransition(String transition)
	{
		if(this.transitions.containsKey(transition)) //if table has the transition
			return this.transitions.get(transition);
		
		return null;
	}
	
	public boolean equals(State s)
	{
		return this.name == s.getStateName();
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("q" + name + ": ");
		if(begin)
		{
			str.append("Start");
			if(end)
				str.append("/Final");
		}
		else if(end)
			str.append("Final");
		
		str.append("\n");
		for(String key : transitions.keySet())
		{
			str.append("\t" + key + ":");
			
			HashSet<State> set = transitions.get(key);
			
			int i = set.size() - 1; 
			for(State s : set){
				str.append(" q" + s.getStateName());
				
				if(--i == 0)
					str.append(",");
			}
			
			str.append("\n");
		}
		
		return str.toString();
	}
	
}
