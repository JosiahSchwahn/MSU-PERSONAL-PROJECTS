/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/


package outlabonev;

import java.util.Random;

/**
 *
 * @author josiah
 */
public class Deck {
    // The array of cards in the deck, where the top card 
    // is the first card
    private Card[] myCards;
    
    // number of cards in the deck currently
    private int numCards;
    
    //blank constuctor that defines values if nothing 
    // is passed in
    public Deck(){
        this(1,false);
    
    }
    
    //constuctor the defindes the number of the decks 
    // and if you want to shuffle or not
    
    public Deck(int numDecks, boolean shuffle){
        
        this.numCards = numDecks * 52;
        this.myCards = new Card[this.numCards];
        
        //index for a card 
        
        int c = 0;
        
        // for each deck
        
        for(int d = 0; d < numDecks; d++){
            // for each suit
            for (int s = 0; s < 4; s ++){
                //for each number
                for(int n = 1; n <=13 ; n++){
                    // add a new card to the deck
                    this.myCards[c] = new Card(Suit.values()[s], n);
                    c++;
                }
            }
        }
        
      if(shuffle){
          this.shuffle();
      }  
      
      
        
    }
    //method to shuffle the deck of cards
    public void shuffle()
    
    {
        //shuffles the deck of cards
        // uses random number generator to shuffle
        Random rng = new Random();
        
        Card temp;
        
        int j;
        for(int i = 0; i < this.numCards; i++){
            // get a random card to swap values with
            j = rng.nextInt(this.numCards);
            
            // swap 
            
            temp = this.myCards[i];
            this.myCards[i] = this.myCards[j];
            this.myCards[j] = temp;
        }
    }
    // deals the next top card created in the deck 
    public Card dealNextCard(){
        // gets the next top card
        
        Card top = this.myCards[0];
        
        //shifts cards so the new top card is back at postion 0
        
        for(int c = 1; c < this.numCards; c++){
            this.myCards[c-1] = this.myCards[c];
            
        }
        this.myCards[this.numCards - 1] = null;
        
        //decremnts the number of cards in out deck
        
        this.numCards--;
        
        
        return top;
        
    }
    //method to print the top cards in the deck
    public void printDeck(int numToPrint){
        for(int c = 0; c < numToPrint; c++){
            System.out.printf("% 3d/%d %s\n", c + 1, this.numCards,
                    this.myCards[c].toString());
            
        }
        
        System.out.printf("\t\t[%d other]", this.numCards-numToPrint);
        
        
    }
}
