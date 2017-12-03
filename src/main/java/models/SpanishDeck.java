package models;


public class SpanishDeck extends Deck {


   public void init() {
       
       for(int i = 1; i < 13; i++){
       		deck.add(Card.createCard(i, Suit.Bastos));
       		deck.add(Card.createCard(i, Suit.Oros));
       		deck.add(Card.createCard(i, Suit.Copas));
       		deck.add(Card.createCard(i, Suit.Espadas));
       }
       deck.add(Card.createCard(14, Suit.Comodines));
       deck.add(Card.createCard(14, Suit.Comodines));
       shuffle();
       isSpanishDeck = true; //testing purposes
    }










}
