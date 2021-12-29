/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlabonev;
import java.util.Scanner;
/** 
 *
 * @author josiah
 */
public class GameRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // starting points for each player
        int startingPoints = 500;
        
        //creates the scanner, taking in user inpurs for the blackjack game
        Scanner sc = new Scanner(System.in);

        //plays the blackjack game until the user stops or runs out of points
        
        while (startingPoints  > 0) {
            boolean betGood = false;
            int bet;
            int tryBet = 0;
            
            //prints out starting points 
            while (betGood == false) {
                System.out.println("Points remaining: " + startingPoints);
               
                //takes in the value from the user of how many points they want to bet
                System.out.println("How many points do you want to bet: ");
                tryBet = sc.nextInt();
                //makes sure the user has the enough points to make a bet
                if (tryBet <= startingPoints) {
                    betGood = true;
                } else {
                    //stops the user from playing when he/she points run out
                    System.out.println("You cannot bet more points than you have. Try again.");
                }
            }
            bet = tryBet;
            
            //makes the number of decks, only using one from this game (only 2 players)
            Deck theDeck = new Deck(1,true);
            
            //makes the players and dealer
            Player me = new Player("Josiah");
            Player dealer = new Player("Dealer");
            
            //gives three cards to both the player and dealer
            me.addCard(theDeck.dealNextCard());
            dealer.addCard(theDeck.dealNextCard());
            me.addCard(theDeck.dealNextCard());
            dealer.addCard(theDeck.dealNextCard());
            me.addCard(theDeck.dealNextCard());
            dealer.addCard(theDeck.dealNextCard());

            //format for showing the players hand but not the dealers
            System.out.println("Cards are dealt:\n");
            me.printHand(true);
            dealer.printHand(false);
            System.out.println("\n");


         
            // sets the user and dealer to play at least one hand
            boolean meDone = false;
            boolean dealerDone = false;
            String ans;

            //takes in if the user wants to take a card or not
            while(meDone == false && dealerDone == false){
                //players turn
                System.out.println("Hit or stay (enter H or S): ");
                ans = sc.next(); 
                System.out.println();
                // if the player hits 

                //adds card and prints deck for the player who wants another card
                if (ans.equals("H")) {
                    meDone = !me.addCard(theDeck.dealNextCard());

                    me.printHand(true);

                } else {
                    meDone = true;

                }

                //dealer's turn

                if(!dealerDone){
                    if(dealer.getHandSum() < 26) {
                        System.out.println("The dealer hits\n");
                        dealerDone = !dealer.addCard(theDeck.dealNextCard());
                        dealer.printHand(false);

                    } else{
                        System.out.println("The dealer stays\n");
                        dealerDone = true;

                    }


                }
            }
           

            //format 
            System.out.println();
              


            //shows the hands of both the player and dealer
            me.printHand(true);
            dealer.printHand(true);
            //adds up all the values of the cards of both the dealers and players hand
            int mySum = me.getHandSum();
            int dealerSum = dealer.getHandSum();
            //tests to see who won the game
            if (mySum > dealerSum && mySum <= 31 || dealerSum  > 31){
                //prints out the player wins in good format
                System.out.println("");
                System.out.println("You Win!!\n");
                // adds the bet points to the starting points value since the user won\
                startingPoints += bet;
                System.out.println("Points remaining: " + (startingPoints));
                
            } else {
                 //takes away from the users points since they lost
                 startingPoints -= bet;

                 //prints out if the dealer wins in a nice format
                 System.out.println("");
                 System.out.println("Dealer wins\n");
                 System.out.println("Points remaining: " + (startingPoints));
                 if (startingPoints <= 0) {
                     System.out.println("You are broke and lose.");
                     break;
                 }



            }
        }
        //closes scanner
        sc.close();
        
        
    }
    
}
