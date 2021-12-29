/*
An enum represetning the four possible card values, hearts
diamonds, spades and clubs
 */
package outlabonev;

/**
 *
 * @author josiah
 */
public class Card {
    // one of four valid suits for a deck of 52 cards
    private Suit mySuit;
    
    // possible values for a card, 1, 2, ace, king, etc...
    private int myNumber;
    
    // a constuctor for for giving a card a suit and number
    public Card(Suit aSuit, int aNumber){
        this.mySuit = aSuit;
        this.myNumber = aNumber;
        
        if(aNumber >=1 && aNumber <=13){
            this.myNumber = aNumber;
        } else {
            System.err.println(aNumber + "is not a valid Card Number");
            System.exit(1);
                    
        }
        
    }
    //returns the number on the card @returns the number
    public int getNumber(){
        return myNumber;
    }
    //uses the enum class to combine a card value to it's rank
    public String toString(){
       
        String numStr = "Ace";
        
        switch(this.myNumber){
            
            case 2:
                numStr = "Two";
                break;
            case 3:
                numStr = "Three";
                break;
            case 4:
                numStr = "Four";
                break;
            case 5:
                numStr = "Five";
                break;
            case 6:
                numStr = "Six";
                break;
            case 7:
                numStr = "Seven";
                break;
            case 8:
                numStr = "Eight";
                break;
            case 9:
                numStr = "Nine";
                break;
            case 10:
                numStr = "Ten";
                break;
            case 11:
                numStr = "Jack";
                break;
            case 12:
                numStr = "Queen";
            case 13:
                numStr = "King";
                break;
            case 14:
                numStr = "Ace";
                break;             
        }
        return numStr + " of " + mySuit.toString();
    }
    
    
    
    
    
    
    
}
