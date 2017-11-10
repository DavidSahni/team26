package models;
import java.util.ArrayList;

public class Column {
    public java.util.List<Card> stack = new ArrayList<Card>();

    public Card getTopCard(){
            return this.stack.get(stack.size()-1);
        }

    public void removeTopCard(){
        this.stack.remove((this.stack.size()-1));
    }

    public Card returnTopCard(){
        Card c = this.getTopCard();
        this.removeTopCard();
        return c;
    }
}
