package playPackage;
import java.io.IOException;
import java.util.ArrayList;

import ocsf.server.ConnectionToClient;


public class Hand {
ConnectionToClient player;
	private ArrayList individualCards = new ArrayList();
	private ArrayList sharedCards = new ArrayList();
	
	public Hand(ConnectionToClient p){
		this.player = p;
	
	}
	
	public void addIndividualCard(Card card){
		individualCards.add(card);
		try {
			player.sendToClient(card);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addSharedCard(Card card){
		sharedCards.add(card);
		try {
			player.sendToClient(card);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Hand getHand(){
		return this;
	}
}
	
	

