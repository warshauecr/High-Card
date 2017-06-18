
/**
 *
 * @author Casey Warshauer
 */
public class Cards {
    
    public enum Rank { TWO, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    private Rank faceValue;
    private Suit cardType;
   
    
    public Cards(Suit cardType, Rank faceValue)
    {
        this.cardType = cardType;
        this.faceValue = faceValue;
    
    }
    
    public Suit getSuit()
    {
     return cardType;
    }
    
     public Rank getFaceValue()
    {
     return faceValue;
    }
     

  
    
    @Override
    public String toString()
    {
       
        return "Card dealt: " + faceValue + " of " + cardType + "\n";
    }
}
    
