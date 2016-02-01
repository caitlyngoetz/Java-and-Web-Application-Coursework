
/**
 * Manages a pair of dice.
 * 
 * @author mvail
 */
public class PairOfDice {
	private Die die1;
	private Die die2;
	
	/**
	 * Constructor: Creates two default dice
	 */
	public PairOfDice() {
		die1 = new Die();
		die2 = new Die();
	}
	
	/**
	 * Roll both dice and return the total
	 * @return sum of new face values
	 */
	public void roll() {
		die1.roll();
		die2.roll();
	}
	
	/**
	 * @return current face value from first Die
	 */
	public int getFaceValue1() {
		return die1.getFaceValue();
	}
	
	/**
	 * @return current face value from second Die
	 */
	public int getFaceValue2() {
		return die2.getFaceValue();
	}
	
	/**
	 * @return current sum of the two face values
	 */
	public int getTotal() {
		return die1.getFaceValue() + die2.getFaceValue();
	}
}