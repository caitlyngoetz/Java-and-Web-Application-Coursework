import java.util.Scanner;


public class Pig {
	private int playerScore, computerScore, round;
	private int playerRoundScore, playerCurrentRoundScore, computerRoundScore, computerCurrentRoundScore;
	private Scanner scan;
	private PairOfDice dice;

	public Pig(Scanner scan2) {
		scan = scan2;
		dice = new PairOfDice();
		
	}

	public void play() {
		playerScore = 0;
		computerScore = 0;
		round = 1;
		while(computerScore < 100 && playerScore < 100)
		{	System.out.print(toString());
			if(round%2 ==0)  //round is even
			{
				computerTurn();
			}
			else  //round is odd
			{
				playerTurn();
			}
			System.out.println();
			round++;
		}
		if(computerScore >= 100)
			System.out.println("Computer Wins!!");
		else
			System.out.println("You Win!!!");
	}
	private void computerTurn(){
		int computerRoundScore = 0;
		boolean go = true;
		while(go == true && computerScore < 100){
			dice.roll();
			if(dice.getFaceValue1() == 1 && dice.getFaceValue2() ==1){
				computerScore = 0;
				computerRoundScore = 0;
				go = false;
				System.out.println("The computer has rolled two 1's so computer score is " + computerScore);
			}else if(dice.getFaceValue1() == 1 || dice.getFaceValue2() == 1){
				computerScore = computerScore - computerRoundScore;
				computerRoundScore = 0;
				go = false;
				System.out.println("The computer has rolled one 1 so the computer score is " + computerScore);
			}else{
				computerRoundScore = dice.getTotal();
				computerScore += dice.getTotal();
				System.out.println("Computer Rolled " + dice.getFaceValue1()+ " & " + dice.getFaceValue2() + " - round score is " + computerRoundScore +
						 " and total score is " + computerScore);
				
				if(computerRoundScore >= 20 || computerScore + computerRoundScore >= 100)
					go = false;
			}
			
		}
		System.out.println("The computer has decided that it is done and its total score is " + computerScore);
			
	
	}
	private void playerTurn() {
		int playerRoundScore = 0;
		char play;
		boolean y = true;
		while(y == true && playerScore < 100) {
			dice.roll();
			if(dice.getFaceValue1() == 1 && dice.getFaceValue2() == 1){
				playerScore = 0;
				playerRoundScore = 0;
				y = false;
				System.out.println("You rolled two 1's so your total score is " + playerScore);
			}else if(dice.getFaceValue1() == 1 || dice.getFaceValue2() == 1){
				playerScore = playerScore - playerRoundScore;
				playerRoundScore = 0;
				y = false;
				System.out.println("You rolled one 1 so your total score is " + playerScore);
			}else{
				playerRoundScore += dice.getTotal();
	
//				playerRoundScore = playerRoundScore + playerCurrentRoundScore;
				playerScore += dice.getTotal();
				System.out.println("Player Rolled " + dice.getFaceValue1() + " & " + dice.getFaceValue2() + " - round score is " + playerRoundScore +
						" and total score is " + playerScore);
				//System.out.println("Do you want to play again? (y/n): ");
				play = scan.next().toLowerCase().charAt(0);
				if(play == 'n'){
					y = false;
				}
			}
			//System.out.println("Player Rolled " + dice.getFaceValue1() + " & " + dice.getFaceValue2() + " - round score is " + playerRoundScore +
			//		" and total score is " + playerScore);		
			}
	}
		public String toString(){
			return ("--==Round: " + round +  "    Player Score: " + playerScore + "     ComputerScore: " + computerScore +"==--\n");
		}
}
