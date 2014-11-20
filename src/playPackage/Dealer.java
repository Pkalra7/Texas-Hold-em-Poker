package playPackage;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4678 modeling language!*/


import java.util.*;

import ocsf.server.ConnectionToClient;

// line 2 "model.ump"
// line 75 "model.ump"
public class Dealer
{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//Dealer Associations
	private LinkedQueue<Card> cards;
	private Poker poker;
	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Dealer(Poker aPoker)
	{
		this.poker = aPoker;
		cards = new LinkedQueue<Card>();
	}

	public LinkedQueue<Card> createDeck(){
		for (int i =0; i<52; i++){
			cards.enqueue(new Card());
			
		}
		return cards;
	}

	public int numberOfCards()
	{
		int number = cards.size();
		return number;
	}

	public boolean hasCards()
	{
		boolean has = cards.size() > 0;
		return has;
	}
	public static int minimumNumberOfCards()
	{
		return 0;
	}

	public static int maximumNumberOfCards()
	{
		return 52;
	}
/**
 * Sends a card to the shared hand of all players
 */
	public void dealAll(LinkedQueue<Card> deck){
		Card c = deck.dequeue();
		for(int i =0; i<poker.getClientConnections().length; i++)				{ 
			((ConnectionToClient) poker.getClientConnections()[i]).getHand().addSharedCard(c);
				}

	}
	/**
	 * Sends a unique card to every player
	 * 
	 */
	public void deal(LinkedQueue<Card> deck){
			for(int i =0; i<poker.getClientConnections().length; i++)
		((ConnectionToClient)poker.getClientConnections()[i]).getHand().addIndividualCard(deck.dequeue());
	}
	
	
	// line 5 "model.ump"
	public LinkedQueue<Card> shuffleDeck(LinkedQueue<Card> cards){
		int n = cards.size();
		int j=0;
		Card[] array = new Card[n];
			while (cards.peek()!=null){
				array[j]=cards.dequeue();
				j++;
			}
			
		Random random = new Random();
		random.nextInt();
		for (int i = 0; i < n; i++) {
			int change = i + random.nextInt(n - i);
			swap(array, i, change);
		}
		for (int i =0; i<n; i++)
			cards.enqueue(array[i]);
		return cards;
	}
	 private static void swap(Card[] a, int i, int change) {
		    Card helper = a[i];
		    a[i] = a[change];
		    a[change] = helper;
	 }
	// line 6 "model.ump"
	public void receiveScoreFromConnectionToClient(){

	}

	// line 7 "model.ump"

	

}