
public class AlgorithmsMain {

	
	public static void Floyd_Warshall(){
		Algorithms cs = new Algorithms(false);
		
		
		Integer[][] A = {{0,2300,null,3300,null,null,null,null,null,null,null},
						 {2300,0,1200,null,null,null,null,null,null,null,null},
						 {null,1200,0,null,4000,null,null,null,null,null,null},
						 {3300,null,null,0,6000,1500,4000,null,null,null,null},
						 {null,null,4000,6000,0,null,null,null,null,null,null},
						 {null,null,null,1500,null,0,3000,null,3500,null,null},
						 {null,null,null,4000,null,3000,0,2400,null,null,null},
						 {null,null,null,null,null,null,2400,0,null,null,null},
						 {null,null,null,null,null,3500,null,null,0,6400,2400},
						 {null,null,null,null,null,null,null,null,6400,0,4400},
						 {null,null,null,null,null,null,null,null,2400,4400,0}};
		

		String value = cs.Floyd_Warshall(new Matrix(A));
		System.out.println(value + "Complete");
	}
	
	public static void main(String[] args) {
		Floyd_Warshall();
	}
}
