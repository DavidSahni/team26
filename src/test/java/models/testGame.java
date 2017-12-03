package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testGame {

    Game g;

    @Test
    public void testNewGame(){
        g = new Game();
        assertEquals(g.cols.size(), 4); // make sure correct num
        for (int i = 0; i < 4; i++){
            assertEquals(g.cols.get(i).id, i+1); //check to see they are properly arranged and id'd
        }
    }

    @Test
    public void testInit(){
        g = new Game();
        g.init(0);
        assertEquals(g.key, 0);
        assert(g.deck != null); //deck should be initialized
        assert(!g.deck.isSpanishDeck);
        g = new Game();
        g.init(1);
        assertEquals(g.key, 1);
        assert(g.deck != null);
        assert(g.deck.isSpanishDeck);
    }

    @Test
    public void testdealFour(){
        g = new Game();
        g.init(0);
        g.dealFour();
        for(int i = 0; i < 4; i++){
            assertEquals(g.cols.get(i).cards.size(), 1);
        }
        assertEquals(g.deck.returnDeckSize(), 48);
    }

    @Test
    public void testRemove(){
        g = new Game();
        g.init(0);
        int rem = g.removeCount;
        g.remove(0);
        assertEquals(g.removeCount, rem); //no cards should have been removed
        g.dealFour();

        g.remove(0);
        assertEquals(g.removeCount, rem+1);
        assertEquals(g.cols.get(0).cards.size(), 0);

        g.remove(5);
        assertEquals(g.removeCount, rem+1); //shouldn't have increased no column 5

    }

    public void testMove(){
        g = new Game();
        g.cols.get(0).cards.add(new Card(0, Suit.Comodines));
    }
}
