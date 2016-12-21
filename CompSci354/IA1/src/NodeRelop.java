
public class NodeRelop {
	private String relop;
	private int pos;
	
	public NodeRelop(int pos, String relop) {
		this.pos = pos;
		this.relop = relop;
	}
	
	public double eval(double expr1, double expr2) throws Exception {
		if(relop.equals("<")) {
			return (expr1 < expr2) ? 1.0 : 0.0;
		}
		else if(relop.equals(">")) {
			return (expr1 > expr2) ? 1.0 : 0.0;
		}
		else if(relop.equals("==")) {
			return (expr1 == expr2) ? 1.0 : 0.0;
		}
		else if(relop.equals(">=")) {
			return ((expr1 >= expr2) || (expr1 == expr2)) ? 1.0 : 0.0;
		}
		else if(relop.equals(">=")) {
			return ((expr1 >= expr2) || (expr1 == expr2)) ? 1.0 : 0.0;
		}
		else if(relop.equals("<>")) {
			return (expr1 != expr2) ? 1.0 : 0.0;
		}
		throw new EvalException(pos, relop);
	}
}
