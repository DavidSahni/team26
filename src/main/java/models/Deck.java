package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    public java.util.List<Card> deck = new ArrayList<>();

    public void init() {
        for(int i = 2; i < 15; i++){
            deck.add(Card.createCard(i, Suit.Clubs));
            deck.add(Card.createCard(i, Suit.Hearts));
            deck.add(Card.createCard(i, Suit.Diamonds));
            deck.add(Card.createCard(i, Suit.Spades));
        }
        shuffle();
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public Card dealTop(){
        if(deck.size() > 0) {
            Card ret = deck.get(deck.size() - 1);
            deck.remove(deck.size() - 1);
            return ret;
        }else{
            return null;
        }
    }

    public int returnDeckSize() {
        return deck.size();
    }

    public boolean isSpanishDeck = false; //testing purposes


}
