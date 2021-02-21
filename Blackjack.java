/*
Shoaib Laghari
2/12/21
*/

// lets see if i can program a simple game
// of blackjack before my flight lands in nashville


import java.util.*;
import java.io.*;

//updates to make: 
//allow multiple players
//show dealers process
//graphics in panel
//introduce aces

public class Blackjack {
   
   //pre: 
   //post: gives player 2 cards,
   //      asks to hit or stay, responds correctly
   //      plays until player stays, wins, or busts
   public static void main(String[] args){
      Random r = new Random();
      readIntro();
      
      //ask name and create player object
      Scanner console = new Scanner(System.in);
      System.out.print("What's your name? ");
      String name = console.nextLine();
      
      Player playerOne = new Player(name);
      
      //generate two initial cards for player, measured in player data
      playerOne.value = dealHand(r);
      System.out.println("Your starting value is " + playerOne.value);
      
      //boolean letsPlay = askHitOrStay
      String choice = askHitOrStay(console);
      
      boolean letsPlay = false;
      letsPlay = updateChoice(choice);
      
      //while letsPlay, give card and ask again
      while (letsPlay){
         int num = r.nextInt(10) + 1;
         playerOne.value += num;
         System.out.println("You picked up " + num);
         
         if (playerOne.value < 21){
            System.out.println("Your value is now " + playerOne.value);
            choice = askHitOrStay(console);
            letsPlay = updateChoice(choice);
         } else if (playerOne.value == 21){
            System.out.println("Your value is now 21.");
            System.out.println("Winner winner chicken dinner.");
            letsPlay = false;
         } else {
            System.out.println("Bust.");
            letsPlay = false;
         }
      }
      
      //generate hand for dealer
      if (playerOne.value < 21){
         Player dealer = new Player("dealer");
         dealer.value = dealHand(r);
         System.out.println();
         System.out.println("Dealer starts with " + dealer.value);
         
         int num = r.nextInt(10) + 1;
         while (dealer.value + num < 22){
            dealer.value += num;
            num = r.nextInt(11);
         }
         
         System.out.println();
         System.out.println("Dealer finished with " + dealer.value);
         
         //see who won
         if (playerOne.value < dealer.value){
            System.out.println("You lost.");
         } else if (playerOne.value > dealer.value){
            System.out.println("You win.");
         } else {
            System.out.println("Draw.");
         }
      }
   }
   
   //post: reads intro message
   public static void readIntro(){
      System.out.println("Welcome to Shoaib's Blackjack Challenge.");
      System.out.println("I hope you know how to play, because");
      System.out.println("I won't bother explaining it to you.");
      System.out.println();
      System.out.println("Good luck");
      System.out.println();
   }
   
   //pre: must be passed scanner console
   //post: asks hit or stay and returns answer as string
   public static String askHitOrStay(Scanner console){
      System.out.println();
      System.out.println("Hit or stay?");
      return console.nextLine();
   }
   
   //pre: must be passed string choice
   //post: returns true/false depending on choice
   public static boolean updateChoice(String choice){
      if (choice.equalsIgnoreCase("hit")){
         return true;
      } else {
         return false;
      }
   }
   
   //pre: must be passed random r
   //post: gives starting hand to players
   public static int dealHand(Random r){
      int firstCard = r.nextInt(10) + 1;
      int secondCard = r.nextInt(10) + 1;
      return firstCard + secondCard;
   }
}