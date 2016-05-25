package com.capitalone.coffeeclub.casino;

import com.capitalone.coffeeclub.casino.Card;
import java.util.List;
import java.util.LinkedList;

public class Hand {
    
    List<Card> cards = new LinkedList<Card>();
    
    public List<Card> getCards() {
        return cards;
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public int getTotal() {
        int total = 0;
        for(Card card : cards) {
            total += card.getValue();
        }
        return total;
    }
}