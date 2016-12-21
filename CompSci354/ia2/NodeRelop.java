
public class NodeRelop extends Node{
	private String relop;
	
	public NodeRelop(int pos, String relop){
		this.pos = pos;
		this.relop = relop;
	}
	
	public double eval(double r1, double r2){
		switch(relop){
		case"<":
			if(r1<r2) return 1;
			else 
				return 0;
		case"<=":
			if(r1<=r2) return 1;
			else 
				return 0;
		case">":
			if(r1>r2) return 1;
			else 
				return 0;
		case">=":
			if(r1>=r2) return 1;
			else 
				return 0;
		case"<>":
			if(r1!=r2) return 1;
			else 
				return 0;
		case"==":
			if(r1==r2) return 1;
			else 
				return 0;
		}
		return -1;
	}
}
