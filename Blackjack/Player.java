//*********************************************
//Dealer.java
//By Jordana Mael (jam2350)
//A class that simulates a player in Blackjack
//*********************************************
import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    //Players cards in his hand
    private int handTotal;
    //Numerical total of cards in hand
    //private Scanner input;
	
    public Player() {
    	hand = new ArrayList<Card>();
    	handTotal = 0;
    }

    public int getTotal(){
        return handTotal;
    }
	
    public void deal (Card nextCard) {
    	//Deals a card
    	hand.add(nextCard);
    	//Adds a card to player's ArrayList of cards in his hand
    	calculateHandTotal();
    }
   
    public void calculateHandTotal() {
    	//Calculates numerical total of cards in hand
    	handTotal = 0;
    	//Reset hand total to 0 and recheck all values of cards
    	int cardPoints;
    	//Stores value of card that's being evaluated
    	for (Card handCard : hand) {
    		//Assesses value of all non-aces in hand
    		//And adds values together
    		if (handCard.getValue() > 1 && handCard.getValue() < 11) {
    			cardPoints = handCard.getValue();
    		}
    		else if (handCard.getValue() != 1){
    			//Face cards are all 10
    			cardPoints = 10;
    		}
    		else {
    			cardPoints = 0;
    		}
    		handTotal += cardPoints;
    	}
    	for (Card handCard : hand) {
    		//Assesses appropriate value of ace and adds to total value
    		if (handCard.getValue() == 1 && handTotal<11) {
    			//Ace will be 11 unless that will cause a bust
    			cardPoints = 11;
    		}
    		else if (handCard.getValue() == 1 && handTotal>10) { 
    			cardPoints = 1;
    		}
    		else {
    			cardPoints = 0;
    		}
    	    handTotal += cardPoints;
    	}
    }
    
    public String printHand() {
    	//Prints cards in hand in a String
    	String totalCards = "";
    	//Stores String of all cards
    	for (Card element : hand) {
    		//Converts every card in ArrayList to a String
    		String cardName = element.toString();
    		totalCards += cardName + "\n";
    	}
    	return totalCards;
    }

}
	

