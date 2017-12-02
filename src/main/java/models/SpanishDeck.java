package models;


public class SpanishDeck extends Deck {


   public void init() {
        for(int i = 2; i < 16; i++){
            deck.add(Card.createCard(i, Suit.Clubs));
            deck.add(Card.createCard(i, Suit.Hearts));
            deck.add(Card.createCard(i, Suit.Diamonds));
            deck.add(Card.createCard(i, Suit.Spades));
        }
        shuffle();
    }








}
