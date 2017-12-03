package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testDeck {

    @Test
    public void testInit(){
        Deck d = new Deck;
        assertEquals(56,d.returnDeckSize());
    }

    @Test
    public void testDealTop(){
        Deck d = new Deck;
        Card c = d.dealTop();
        assertEquals(55,d.returnDeckSize());
    }


}