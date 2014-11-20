package playPackage;

import java.io.Serializable;

public class Card implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4065576703406281511L;
	//Card Attributes
	private static int suitNumber = 0;
	private static int valueNumber = 0;
	private String [] suits = {"Spades", "Diamonds", "Hearts", "Clubs"};
	private String [] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private String suit;
	private String value;

	//Card Associations
	//	private Dealer dealer;
	private Player player;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Card(String aSuit, String aValue) throws IllegalArgumentException{
		if(contains(suits,suit) && contains(values,value)){
			suit = aSuit;
			value = aValue;
		}
		throw new IllegalArgumentException("Unable to create card due to wrong value or suit");
	}

	public Card()	{
		suitNumber =(suitNumber+1)%4;
		String aValue = values[((valueNumber++)%13)];

		switch (suitNumber){
		case 0:
			this.suit = "spades";
			this.value = aValue;
			break;
		case 1:
			this.suit = "hearts";
			this.value = aValue;
			break;
		case 2:
			this.suit = "diamonds";
			this.value = aValue;
			break;
		case 3:
			this.suit = "clubs";
			this.value = aValue;
			break;
		default:

		}


	}


	private boolean contains (String[] array, String key){
		for (int i=0; i<suits.length; i++){
			if(array[i].equals(key))
				return true;
		}
		return false;
	}
	public String getSuit()
	{
		return suit;
	}

	public String getValue()
	{
		return value;
	}


	public Player getPlayer()
	{
		return player;
	}

	public boolean hasPlayer()
	{
		boolean has = player != null;
		return has;
	}

	
	public String toString()
	{

		return  ""+ "["+ "suit" + ":" + getSuit()+ "," +
				"value" + ":" + getValue()+ "]" ;
	}
}








