/*
Shoaib Laghari
2/12/21
*/

// this is the player object for
// my blackjack challenge

import java.util.*;

public class Player implements Comparable<Player> {
   
   public String name;
   public int value;
   
   //pre: must be passed string name
   //post: creates player object
   
   public Player(String name){
      this(name, 0);
   }
   
   //pre: must be passed string name and int value
   //post: adds value to given player
   
   public Player(String name, int value){
      this.name = name;
      this.value = value;
   }
   
   //pre: must be passed player other
   //post: returns int; negative if this player is less than  other, 0 if this
   //      player equals other, positive if this player is greater than other
   
   public int compareTo(Player other){
      return value - other.value;
   }
   
}