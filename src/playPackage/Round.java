package playPackage;
import java.io.IOException;

import common.ChatIF;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;


public class Round {

	private Poker poker;
	private Player better;
	private int playerNumber;
	private Dealer dealer;
	private LinkedQueue<Card> deck;

	Round(Poker aPoker){
		this.poker = aPoker;
		this.dealer = new Dealer(aPoker);
	}

	private void deal(){
		dealer.deal(deck);
		dealer.deal(deck);
	}

	private void flop(){
		dealer.dealAll(deck);
		dealer.dealAll(deck);
		dealer.dealAll(deck);
	}

	private void turn(){
		dealer.dealAll(deck);
	}

	private void river(){
		dealer.dealAll(deck);

	}

	public void play(){
		while (poker.getNumberOfClients()<2){

		}

		deck = dealer.createDeck();
		dealer.shuffleDeck(deck);
		System.out.println(deck);
		deal();
		flop();
		turn();
		river();


	}


}