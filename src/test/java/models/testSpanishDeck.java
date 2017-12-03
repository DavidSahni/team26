package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testSpanishDeck {
    @Test
    public void testifSpanish(){
        SpanishDeck de = new SpanishDeck;
        de.init();
        assertEquals(true, de.isSpanishDeck);
    }

    @Test
    public void testSpanishDeckSize(){
        SpanishDeck de = new SpanishDeck;
        de.init();
        assertEquals(50, de.returnDeckSize());
    }

    @Test
    public void testSpanishDealTop(){
        SpanishDeck de = new SpanishDeck;
        de.init();
        Card c = de.dealTop();
        assertEquals(49,de.returnDeckSize());
    }

    @Test
    public void testJoker(){
        Card ce = new Card(14, Suit.Comodines);
        assertEquals("14Comodines",ce.toString());
    }

}