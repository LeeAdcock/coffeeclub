package com.capitalone.casino;

import com.capitalone.casino.Card;
import com.capitalone.casino.Hand;

public class Blackjack { 
 
   public static void main(String[] args) { 

        Card queenDiamonds = new Card(10);
        Card aceSpades = new Card(11);

        Card fiveHearts = new Card(5);
        Card sevenClubs = new Card(7);

        Hand mattHand = new Hand();
        mattHand.addCard(queenDiamonds);
        mattHand.addCard(aceSpades);
        
        Hand leeHand = new Hand();
        leeHand.addCard(fiveHearts);
        leeHand.addCard(sevenClubs);
        
        System.out.println("Matt: "+mattHand.getTotal());
        System.out.println("Lee: "+leeHand.getTotal());
        
        if(mattHand.getTotal() > leeHand.getTotal()) {
            System.out.println("Matt wins!");
        } else 
            System.out.println("Lee wins!");
   }        

   }
   