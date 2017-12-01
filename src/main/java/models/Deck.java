package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class Deck {

    public java.util.List<Card> deck = new ArrayList<>();
    public abstract void init();

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public Card dealTop(){
        Card ret = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return ret;
    }

    public int returnDeckSize() {
        return deck.size();
    }


}
