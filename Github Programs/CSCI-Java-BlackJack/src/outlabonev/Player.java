// class for the player playing the game
package outlabonev;

/**
 *
 * @author josiah
 */
public class Player {
    
    //players names 
    
    private String name;
    // how many cards we are going to have, we'll never have 
    // more than 10 cards (rare)
    
    private Card[] hand = new Card[10];
    
    // number of cards in the hand
    
    private int numCards;
    
    //player constructor with the name of the player
    
    public Player(String aName){
        this.name = aName;
        
        
        this.emptyHand();
        
    }
    // testss for an empty hand
    public void emptyHand(){
        for(int c = 0; c < 10; c++){
            this.hand[c] = null;
        }
        this.numCards = 0;
    }
    
    //adds a card to the players hand
    //returns if the sum of the hand is greater than 31
    
    public boolean addCard(Card aCard){
        
        //print error if you have max numbers of card (very rare)
        
        if (this.numCards == 10){
            System.err.printf("%s's hand already has "
                    + "10 cards; " + "cannot add another card\n", this.name);
            
            System.exit(1);
            
            
        }
        
        this.hand[this.numCards] = aCard;
        this.numCards++;
        
        return(this.getHandSum() <= 31);
        
        
    
    }
    
    
    //get hand some method that checks the values of the cards
    // in the given hand (make sure it's not 31)
    
    public int getHandSum(){
        int handSum = 0;
        
        int cardNum;
        int numAces = 0;
        
        
        //calc each card and add them together with the hand sum
        
        for (int c = 0; c < this.numCards; c++){
            //gets the number of current cards
            cardNum = this.hand[c].getNumber();
            
            if(cardNum == 1){
                numAces++;
                handSum += 11;       
            } else if (cardNum > 10){
                handSum += 10; 
            } else {
                handSum += cardNum;
            }
            
        }
        
        // checking if aces will make us bust or not 
        // (checking if aces should be one)
        
        while(handSum > 31 && numAces > 0){
            handSum -= 10;
            numAces--;
        }
        
        
        return handSum;
        
                
    }
    
    // show first card if the first card is not showing
    public void printHand(boolean showFirstCard){
        System.out.printf("%s's cards:\n", this.name);
        for (int c = 0; c < this.numCards; c++){
            if((c == 0 || c ==1)&& !showFirstCard){
                System.out.println("    [hidden]");
 
            } else{
                System.out.printf("  %s\n", this.hand[c].toString());
            }
            
        }
    }
}
