public class PairOfDice {
	private Die die1, die2;



	public PairOfDice(int maxFace) {
		die1 = new Die(maxFace);
		die2 = new Die(maxFace);
	}
	
	public int roll() {
		return die1.roll() + die2.roll();
	}
	
	public int getTotal() {
		return die1.getFaceValue() + die2.getFaceValue();
	}
	
	public int getFaceValue1() {
		return die1.getFaceValue();
	}
	
	public int getFaceValue2() {
		return die2.getFaceValue();
	}
	
	
}
		

	


