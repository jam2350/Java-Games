//*********************************************
//Dealer.java
//By Jordana Mael (jam2350)
//A class that simulates a full deck of cards
//*********************************************

public class Deck {

    private Card[] cards;
    //All the cards in the deck
    private int cardsDrawn;
    //Tracks where top of the deck is
	
    public Deck(){
    	//Constructs a deck of 52 and starts at the top of the deck
    	cards = new Card[52];
    	createDeck();
    	cardsDrawn = 0;
    }
    
    public void createDeck() {
    	//Creates a full deck
    	for (int i = 0; i < 13; i++) {
    		Card card = new Card(i+1, "hearts");
    		cards[i] = card;
    	}
    	for (int i = 13; i < 26; i++) {
    		Card card = new Card(i-12, "diamonds");
    		cards[i] = card;
    	}
    	for (int i = 26; i < 39; i++) {
    		Card card = new Card(i-25, "clubs");
    		cards[i] = card;
    	}
    	for (int i = 39; i < 52; i++) {
    		Card card = new Card(i-38, "spades");
    		cards[i] = card;
    	}
    }
	
    public Card draw() {
    	Card nextCard = cards[cardsDrawn];
    	//Stores card at top of deck
    	cardsDrawn++;
    	//Moves top of deck to the next card in deck
    	return nextCard;
    }
	
    public void shuffle() {
    	for (int i = 0; i < 1000; i++) {
    		//Shuffles by randomly switching cards many times
    		int indexOne;
    		int indexTwo;
    		indexOne = (int) (Math.random() * 52);
    		do {
    			indexTwo = (int) (Math.random() * 52);
    		}
    		while (indexTwo == indexOne);
    		Card temp = cards[indexOne];
    		cards[indexOne] = cards[indexTwo];
    		cards[indexTwo] = temp;
    	}
	}
	
    public int getCardsDrawn(){
	return cardsDrawn;
    }

    public String toString() {
    	//Prints String of all cards in deck
    	String totalCards = "";
    	for (Card element : cards) {
    		String cardName = element.toString();
    		totalCards += cardName + "\n";
    	}
    	return totalCards;
    }

}
