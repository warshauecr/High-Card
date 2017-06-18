/**
 *
 * @author Casey Warshauer
 */



public class CardPlayer {
    
    private int playerId;
    private Cards[] playerHand; 
    private double handValue;
    
    public CardPlayer(int playerId)
    {
        this.playerId = playerId;
     
    }
    
    public void setPlayerHand(Cards[] playerArray)
    {
      playerHand = playerArray;
    }
    
    //Calculates value of player's hand
     public double calHandValue(){
     
     for(Cards x : playerHand)
     {
       handValue = handValue + x.getFaceValue().ordinal();
       
     }
         return handValue;
   }
     
     //returns player hand value
      public double getCalHandValue(){
     
          return handValue;    
      
      }
      
     
     public Cards[] getPlayerHand()
    {
        return playerHand;
    }
     
     public int getPlayerId()
     {
         return playerId;
     }
     
     @Override
     public String toString()
     {
       return "Player " + playerId + "\n";  
     }
     
     
}
