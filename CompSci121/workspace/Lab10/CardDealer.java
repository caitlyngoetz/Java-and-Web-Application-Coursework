
public class CardDealer {
	
	public static void main(String[] args){
		DeckOfCards test = new DeckOfCards();
		System.out.println("New Deck");
		System.out.println(test.toString());
		
		test.shuffle();
		System.out.println("Shuffle Deck");
		System.out.println(test.toString());
		
		System.out.println("Let's play a simple game!");
		Card card1 = test.draw();
		System.out.println(card1);
		Card card2 = test.draw();
		System.out.println(card2);
		int comp = card1.compareTo(card2);
		if(comp == 0) {
			System.out.println("You tied!");
		}
		else if(comp == 1){
			System.out.println("You won!");
		}
		else{ System.out.println("You lost!");
	}
		test.restoreDeck();
		System.out.println("\nRestored Deck");
		System.out.println(test.toString());

}
}