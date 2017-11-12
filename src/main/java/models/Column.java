package models;
import java.util.ArrayList;

public class Column {
    private java.util.List<Card> stack = new ArrayList<Card>();

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

    public void addCard(Card c){
        stack.add(c);
    }

    public boolean hadCards(){
        if (this.stack.size() > 0){
            return true;
        }
        return false;
    }
}
