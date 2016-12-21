
public class Algorithms {

	public boolean debug;
	
	public Algorithms(boolean debug){
		this.debug = debug;
	}
	
	public String Floyd_Warshall(Matrix W){
		int n = W.Length();
		Matrix[] D = new Matrix[n+1];
		D[0] = W;
		
		for(int k = 1; k <= n; k++){
			Matrix d = new Matrix(n);
			
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++){
					Integer ik = D[k-1].Get(i, k-1);
					Integer kj = D[k-1].Get(k-1, j);
					Integer sum = (ik == null || kj == null) ? null : ik + kj;
					
					d.Set(i, j, min(D[k-1].Get(i, j), sum));
				}
			
			D[k] = d;
		}
		
		StringBuilder val = new StringBuilder();
		for(int k = 0; k < D.length; k++)
			val.append(String.format("*k=%d*\n%s\n\n", k, D[k].toString()));
		
		return val.toString();
	}
	
	public Integer min(Integer x, Integer y){
		if(x == null) return y;	
		if(y == null) return x;
		return x < y ? x : y;
	}
}
