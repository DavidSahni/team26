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
        g.init(1);
        int rem = g.removeCount;
        g.remove(0);
        assertEquals(g.removeCount, rem); //no cards should have been removed

        g.cols.get(0).cards.add(new Card(2, Suit.Bastos));
        g.cols.get(1).cards.add(new Card(12, Suit.Bastos));

        g.remove(1);
        assertEquals(g.removeCount, rem); //no cards should have been removed

        g.remove(0);
        assertEquals(g.removeCount, rem+1);
        assertEquals(g.cols.get(0).cards.size(), 0);

        g.cols.get(2).cards.add(new Card(14, Suit.Comodines));
        rem = g.removeCount;

        g.remove(1);
        assertEquals(g.removeCount, rem+2);
        assertEquals(g.cols.get(1).cards.size(), 0);
        assertEquals(g.cols.get(2).cards.size(), 0);

        g.remove(5);
        assertEquals(g.removeCount, rem+2); //shouldn't have increased no column 5

    }

    @Test
    public void testMove(){
        g = new Game();
        g.init(1);
        g.cols.get(0).cards.add(new Card(0, Suit.Comodines));
        g.move(0, 1);
        assertEquals(g.validMove, false);
        assertEquals(g.cols.get(0).cards.size(), 1);
        assertEquals(g.cols.get(1).cards.size(), 0);

        g.cols.get(1).cards.add(new Card(12, Suit.Bastos));
        g.move(1, 0);
        assertEquals(g.validMove, false);
        assertEquals(g.cols.get(0).cards.size(), 1);
        assertEquals(g.cols.get(1).cards.size(), 1);

        g.move(1,2);
        assertEquals(g.validMove, true);
        assertEquals(g.cols.get(1).cards.size(), 0);
        assertEquals(g.cols.get(2).cards.size(), 1);
        assertEquals(g.cols.get(2).cards.get(0).value, 12);
    }
}
