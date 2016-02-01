import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {
	private Card[] deck;
	private int numOfCardsLeft, nextCard;
	
	public DeckOfCards() {
		deck = new Card[52];
		restoreDeck();
	}
	
	public  void restoreDeck() {
		int index = 0;
		for(Suit suit : Suit.values())
		{
			for(FaceValue face : FaceValue.values())
			{ 
				deck[index++] = new Card(suit, face);
			}
		}
		numOfCardsLeft = 52;
		nextCard = 0;
	}

	public void shuffle()
	{
		Random generator = new Random();
		
		for (int i=0; i<deck.length; i++) {
			int j = generator.nextInt(deck.length);
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
		numOfCardsLeft = deck.length;
		nextCard = 0;
	}
	
	public Card draw() {
		if(nextCard>51) {
			return null;
		}
			numOfCardsLeft--;
			return deck[nextCard++];
	}
	
	public int numCardsRemeaining() {
		return deck.length - (nextCard);
		}
	
	public int numCardsDealt() {
		return nextCard;
	}
	
	public Card[] dealtCards(){
		Card[] dealt = new Card[nextCard];
		for(int i=0; i<nextCard; i++) {
			dealt[i] = deck[i];
		}
		return dealt;
	}
	
	public Card[] remainingCards(){
		Card[] remaining = new Card[numOfCardsLeft];
		for(int i=nextCard; i>deck.length; i++) {
			remaining[i-nextCard] = deck[i];
		}
		return remaining;
	}
	
	public String toString(){
		String ret = "";
		for(Card i: deck){
			ret += i + " \n";
		}
		return ret;
	}
		
}
