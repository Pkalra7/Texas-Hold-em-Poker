public class Card
{


	//Card Attributes
	private static int suitNumber = -1;
	private static int valueNumber = -1;
	private String [] suits = {"Spades", "Diamonds", "Hearts", "Clubs"};
	private String [] values = {"1","2","3","4","5","6","7","8","9","J","Q","K","A"};
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
		suitNumber =(suitNumber+1)%3;
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
/*
	public Dealer getDealer()
	{
		return dealer;
	}

	public boolean hasDealer()
	{
		boolean has = dealer != null;
		return has;
	}*/

	public Player getPlayer()
	{
		return player;
	}

	public boolean hasPlayer()
	{
		boolean has = player != null;
		return has;
	}

/*	public boolean setDealer(Dealer aDealer)
	{
		boolean wasSet = false;
		if (aDealer != null && aDealer.numberOfCards() >= Dealer.maximumNumberOfCards())
		{
			return wasSet;
		}

		Dealer existingDealer = dealer;
		dealer = aDealer;
		if (existingDealer != null && !existingDealer.equals(aDealer))
		{
			existingDealer.removeCard(this);
		}
		if (aDealer != null)
		{
			aDealer.addCard(this);
		}
		wasSet = true;
		return wasSet;
	}*/

	/*public boolean setPlayer(Player aPlayer)
	{
		boolean wasSet = false;
		if (aPlayer != null && aPlayer.numberOfCards() >= Player.maximumNumberOfCards())
		{
			return wasSet;
		}

		Player existingPlayer = player;
		player = aPlayer;
		if (existingPlayer != null && !existingPlayer.equals(aPlayer))
		{
			existingPlayer.removeCard(this);
		}
		if (aPlayer != null)
		{
			aPlayer.addCard(this);
		}
		wasSet = true;
		return wasSet;
	}
*/



	public String toString()
	{
		String outputString = "";
		return super.toString() + "["+
		"suit" + ":" + getSuit()+ "," +
		"value" + ":" + getValue()+ "]" + System.getProperties().getProperty("line.separator") +
		//"  " + "dealer = "+(getDealer()!=null?Integer.toHexString(System.identityHashCode(getDealer())):"null") + System.getProperties().getProperty("line.separator") +
		"  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null")
		+ outputString;
	}
}








