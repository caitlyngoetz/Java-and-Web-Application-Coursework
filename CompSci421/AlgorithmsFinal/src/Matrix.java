
public class Matrix {
	private Integer[][] A;
	public Matrix(Integer[][] A){
		this.A = A;
	}
	public Matrix(int size){
		this.A = new Integer[size][size];
	}
	public int Length() { 
		return A.length; 
	}
	public Integer Get(int i, int j) { 
		return A[i][j];
	}
	public void Set(int i, int j, Integer val){
		A[i][j] = val;
	}
	@Override
	public String toString(){
		StringBuilder val = new StringBuilder("   ");
		
		for(int i = 1; i <= A.length; i++){
			if(i+1 != A.length)
				val.append(String.format("%4s", (i+",")));
			else
				val.append(String.format("%4d", i));
		}
		
		val.append("\n  ");
		
		StringBuilder lines = new StringBuilder();
		for(int i = 0; i < (A.length+1)*4; i++)
			lines.append("-");
		
		val.append(lines.toString() + "\n");
		for(int i = 0; i < A.length; i++){
			val.append((i+1) + " |");
			
			for(int j = 0; j < A[0].length; j++){
				Integer tmp = (A[i][j] == null) ? 99 : A[i][j];
				
				if(j+1 != A[0].length)
					val.append(String.format("%4s", (tmp+",")));
				else
					val.append(String.format("%4d", tmp));
			}
			val.append("\n");
		}
		val.append("  " + lines.toString());
		
		return val.toString();
	}
}