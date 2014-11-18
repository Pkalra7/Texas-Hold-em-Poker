/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4678 modeling language!*/


import java.util.*;

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
		cards = new LinkedQueue<Card>();
		this.poker = aPoker;
		cards = createDeck();
	}



	//------------------------
	// INTERFACE
	//------------------------
	/*
  public Card getCard(int index)
  {
    Card aCard = cards.get(index);
    return aCard;
  }

  public List<Card> getCards()
  {
    List<Card> newCards = Collections.unmodifiableList(cards);
    return newCards;
  }
	 */
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
	/*
  public int indexOfCard(Card aCard)
  {
    int index = cards.indexOf(aCard);
    return index;
  }
	 */

	public static int minimumNumberOfCards()
	{
		return 0;
	}

	public static int maximumNumberOfCards()
	{
		return 52;
	}
	/*
  public boolean addCard(Card aCard)
  {
    boolean wasAdded = false;
    if (cards.contains(aCard)) { return false; }
    if (numberOfCards() >= maximumNumberOfCards())
    {
      return wasAdded;
    }

    Dealer existingDealer = aCard.getDealer();
    if (existingDealer == null)
    {
      aCard.setDealer(this);
    }
    else if (!this.equals(existingDealer))
    {
      existingDealer.removeCard(aCard);
      addCard(aCard);
    }
    else
    {
      cards.add(aCard);
    }
    wasAdded = true;
    return wasAdded;
  }
	 */
	/*

  public boolean removeCard(Card aCard)
  {
    boolean wasRemoved = false;
    if (cards.contains(aCard))
    {
      cards.remove(aCard);
      aCard.setDealer(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }


  public boolean addCardAt(Card aCard, int index)
  {  
    boolean wasAdded = false;
    if(addCard(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCardAt(Card aCard, int index)
  {
    boolean wasAdded = false;
    if(cards.contains(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCardAt(aCard, index);
    }
    return wasAdded;
  }


  public void delete()
  {
    while( !cards.isEmpty() )
    {
      cards.get(0).setDealer(null);
    }
    Round existingRound = round;
    round = null;
    if (existingRound != null)
    {
      existingRound.delete();
    }
  }
	 */
	// line 4 "model.ump"
	public Card deal(){
	return	cards.dequeue();
	}

	// line 5 "model.ump"
	public void shuffleDeck(){
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
	}
	 private static void swap(Card[] a, int i, int change) {
		    Card helper = a[i];
		    a[i] = a[change];
		    a[change] = helper;
	 }
	// line 6 "model.ump"
	public void receiveScoreFromPlayer(){

	}

	// line 7 "model.ump"

	

}