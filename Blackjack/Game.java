//**************************************
//Game.java
//By Jordana Mael (jam2350)
//A class that plays the game Blackjack
//**************************************
import java.util.Scanner;

public class Game {

	private Deck deck;
	//The full deck that the cards are dealt from
	private Player player;
	//The user
	private Dealer dealer;
	private Scanner input;
	//Receives user input
	private boolean dealerWin;
	//Whether or not the dealer won
	private boolean playerWin;
	//Whether or not the player won
	private boolean stay;
	//Whether or not the player wants to stay
	private boolean playAgain;
	//Whether or not the player wants to play again

	public Game() {
		//Constructs a game beginning with no winners
		input = new Scanner(System.in);
		dealerWin = false;
		playerWin = false;
		stay = false;
		playAgain = true;
	}
	
	public void play() {
		//plays Blackjack
		while (playAgain == true) {
			//Keeps playing until the user wants to stop
			dealerWin = false;
			playerWin = false;
			stay = false;
			//Resets winners before each game
			playOneRound();
			//Plays one hand of Blackjack
			System.out.println("Type 1 to play again");
			if (input.nextInt() == 0) {
				playAgain = false;
			}
		}
	}
	
	public void playOneRound() {
		//plays one hand of Blackjack
		deck = new Deck();
		//Create a deck for each game
		deck.shuffle();
		//Shuffle the deck before you play
		player = new Player();
		//Creates a Player object
		player.deal(deck.draw());
		player.deal(deck.draw());
		//The player gets dealt two cards
		dealer = new Dealer();
		//Creates a Dealer object
		dealer.deal(deck.draw());
		//Deals the dealer a card
		System.out.println("Your current hand: "+ player.printHand());
		System.out.println("Your current hand total: "+ player.getTotal());
		System.out.println("Dealer's current hand: "+ dealer.printHand());
		//Informs player of his hand, hand total, and dealer's first card
		dealer.deal(deck.draw());
		//Deals the dealer his second card
		if (player.getTotal() == 21 && dealer.getTotal() != 21) {
			//Player got a Blackjack and dealer did not
			playerWin = true;
			System.out.println("You got a Blackjack, you win!");
		}
		else if (player.getTotal() > 21) {
			//Player busted, automatically lost
			dealerWin = true;
			System.out.println("You busted, you lost :(");
		}
		while (dealerWin == false && playerWin == false && stay == false) {
			//As long as no one has won yet, player plays his turn
			playersTurn();
		}
		if (dealer.getTotal() == 21) {
			//Dealer gets Blackjack, automatically wins
			//Even if player also has Blackjack
			dealerWin = true;
			System.out.println("Dealer got a Blackjack, you lose");
		}
		if (dealerWin != true && playerWin != true) {
			//Nobody has won yet
			dealersTurn();
			System.out.println("Dealer's hand: " + dealer.printHand());
			System.out.println("Dealer's hand total: " + dealer.getTotal());
			whoWon();
		}
	}
	
	public void whoWon() {
		if (dealer.getTotal() > 21) {
			playerWin = true;
			System.out.println("Dealer busted, you win!");
		}
		else if (dealer.getTotal() > player.getTotal()) {
			System.out.println("Dealer wins");
		}
		else if (dealer.getTotal() == player.getTotal()) {
			System.out.println("It's a tie");
		}
		else {
			System.out.println("You win!");
		}
	}
	
	public void dealersTurn() {
		while (dealer.getTotal() < 17) {
			//Dealer hits when cards are under 17
			dealer.deal(deck.draw());
		}
	}
	
	public void playersTurn() {
		//Player plays his turn
		System.out.println("Type 1 to hit, 0 to stay");
		int response = input.nextInt();
		if (response == 0) {
			//Player wants to stay
			stay = true;
		}
		else {
			//Player wants to hit
			player.deal(deck.draw());
			//Deal player another card
			System.out.println("Your current hand: "+ player.printHand());
			System.out.println("Your current hand total: "+ player.getTotal());
			if (player.getTotal() > 21) {
				//Player busted
				dealerWin = true;
				System.out.println("You busted, you lost :(");
			}
			
		}
		
	}
		
}
