package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testDeck {

    @Test
    public void testInit(){
        Deck d = new Deck();
        d.init();
        assertEquals(52,d.returnDeckSize());
    }

    @Test
    public void testDealTop(){
        Deck d = new Deck();
        d.init();
        Card c = d.dealTop();
        assertEquals(51,d.returnDeckSize());
    }


}