import java.util.Scanner;

public class DiceRoller {

	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
	
		PairOfDice pair1 = new PairOfDice(6);
		PairOfDice pair2 = new PairOfDice(6);
		int yourWins = 0;
		int opponentWins = 0;
		int ties = 0;
		String answer = "y";
		
		while (answer.equalsIgnoreCase("y")){
			if (answer.equalsIgnoreCase("y")) {
			int player = pair1.roll();
			int computer = pair2.roll();
			System.out.println("Your roll: " + player + " (" + pair1.getFaceValue1() + " + " + pair1.getFaceValue2() + ")");
			System.out.println("Opponent's roll: " + computer + " (" + pair2.getFaceValue1() + " + " + pair2.getFaceValue2() + ")");
			if (player > computer) {
				System.out.println("You won!!");
				yourWins++;
			}if (computer > player) {
				System.out.println("You lose!");
				opponentWins++;
			}if (player == computer) {
				System.out.println("It was a tie!!");
				ties++;
			}
			System.out.println("Your Wins: " + yourWins + " Opponent wins: " + opponentWins + " Ties: " + ties);
			System.out.println("Do yo want to roll again?");
			answer = scan.nextLine();
			}
		}
	}

}
