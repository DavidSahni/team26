package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StandardDeck extends Deck {



    public void init() {
        for(int i = 2; i < 15; i++){
            deck.add(Card.createCard(i, Suit.Clubs));
            deck.add(Card.createCard(i, Suit.Hearts));
            deck.add(Card.createCard(i, Suit.Diamonds));
            deck.add(Card.createCard(i, Suit.Spades));
        }
        shuffle();
    }






}
