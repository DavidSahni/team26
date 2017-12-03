package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testSpanishDeck {
    @Test
    public void testifSpanish(){
        assertEquals(true, isSpanishDeck);
    }

    public void testSpanishDeckSize(){
        Deck de = new Deck;
        assertEquals(50, de.returnDeckSize());
    }

    public void testSpanishDealTop(){
        Deck de = new Deck;
        Card c = de.dealTop();
        assertEquals(49,de.returnDeckSize());
    }

    public void testJoker(){
        Card ce = new Card(14, Suit.Comodines);
        assertEquals("14Comodines",ce.toString());
    }

}