import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.shuffle;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javafx.scene.control.TextArea;
/**
 *
 * @author Casey Warshauer
 */
public class Deck  {
    
  private List<Cards> cardsList = new ArrayList<>(); 
  private ArrayList<CardPlayer> playerList = new ArrayList<>();
  public static final int PLAYERTOTAL = 2;
  public static final int HAND = 5; 
  private ListIterator<Cards> cardsIter;
  
    public Deck() 
    {
       buildDeck();
       shuffleCards();
       createPlayer();
           
    } 
   
    private void buildDeck()
    {
        for (Cards.Rank value : Cards.Rank.values())
            for(Cards.Suit type : Cards.Suit.values())  
            {
               cardsList.add(new Cards(type, value));
                
            }
       
    }
    
    private void createPlayer()
    {
        for (int i =0; i < PLAYERTOTAL; i++)
        {
            playerList.add(new CardPlayer(i + 1));
        }
    }
    
    
    public void shuffleCards()
    {
        shuffle(cardsList);
       
    }
   
    
    public final void dealCards(TextArea p1, TextArea p2) throws NoSuchElementException 
    {
   
       cardsIter = cardsList.listIterator();
       
      for(CardPlayer i : playerList) 
    {
        Cards[] array = new Cards[HAND]; 
        for (int j =0; j < HAND; j++)
        {
            array[j] = cardsIter.next();
                       cardsIter.remove();
        }
        i.setPlayerHand(array);
        
    }
      
      showCards(p1, p2);
    }
    
    
       
    public void showCards(TextArea p1, TextArea p2)
    {
       double player1= 0;
       double player2= 0;
          p1.clear();
          p2.clear(); //Clear text fields 
       
          for(CardPlayer i : playerList)
        { 
             Cards[] array = i.getPlayerHand();
             
            for(int j = 0; j < i.getPlayerHand().length; j++)
            {
              if(i.getPlayerId() == 1)  
                 p1.appendText(array[j].toString());
              
              else
                 p2.appendText(array[j].toString()); 
            }
            i.calHandValue();
    }
      checkWinner(p1, p2);
          
    }
     public void checkWinner(TextArea p1, TextArea p2){
       if(playerList.get(0).getCalHandValue() > playerList.get(1).getCalHandValue()){
        p1.appendText("\n" + "Player 1 has the highest" + "\n" + "value of cards." + " You win!");
   
       }
       else if(playerList.get(0).getCalHandValue() == playerList.get(1).getCalHandValue()){
       
       }
       else{
           p2.appendText("\n" + "Player 2 has the highest" + "\n" + "value of cards." + " You win!"); 
              
       }
              
          }

}
