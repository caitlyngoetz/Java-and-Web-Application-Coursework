import java.util.Random;

public class Die {
	private int faceValue;
	private int maxFace;
	private Random rand = new Random();
	
	public Die(int maxFace)
	{ 
		this.maxFace = maxFace;
		faceValue = rand.nextInt(maxFace)+1;
	}
	 public int roll() {
		 faceValue = rand.nextInt(maxFace)+1;
		 return faceValue;
	 }
	 public int getFaceValue() {
		 return faceValue;
	 }

}
