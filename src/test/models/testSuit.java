package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testSuit {
    @Test
    public void testBastos(){
        Card c = new Card(13, Suit.Bastos);
        assertEquals("13Bastos",c.toString());
    }

    public void testOros(){
        Card c = new Card(13, Suit.Oros);
        assertEquals("13Oros",c.toString());
    }

    public void testCopas(){
        Card c = new Card(13, Suit.Copas);
        assertEquals("13Copas",c.toString());
    }

    public void testEspadas(){
        Card c = new Card(13, Suit.Espadas);
        assertEquals("13Espadas",c.toString());
    }


}