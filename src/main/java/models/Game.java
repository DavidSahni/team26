package models;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Assignment 1: Students must implement dealFour(), remove(), move(), and columnHasCards() methods
 *
 * The customDeal() method is not present in the Assignment1_Student version since tests (and the test dir) are removed
 * to prevent confusion regarding testing and the use of unit tests; testing is covered more thoroughly in CS362.
 */
public class Game {

    public Deck deck = new Deck();

    public java.util.List<Column> cols = new ArrayList<>();

    //columns patch hasn't been put out yet?
    //public java.util.List<Column> colms = new ArrayList<>();

    public int removeCount = 0;
    public boolean validMove = true;
    public boolean userWon = false;

    public Game(){
        cols.add(new Column(1)); //colms.add(new Column())
        cols.add(new Column(2));
        cols.add(new Column(3));
        cols.add(new Column(3));
        deck.init();
    }



    public void dealFour() {
        for(int i = 0; i < 4; i++){
            cols.get(i).cards.add(deck.dealTop()); //colms.get(i).addCard(deck.dealTop());
        }
    }

    //customDeal to setup game for testing purposes
    //Deprecated
  /*  public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).add(deck.get(c1));
        deck.remove(c1);
        cols.get(1).cards.add(deck.get(c2));
        deck.remove(c2);
        cols.get(2).cards.add(deck.get(c3));
        deck.remove(c3);
        cols.get(3).cards.add(deck.get(c4));
        deck.remove(c4);
    }*/



    public void remove(int columnNumber) {
        if(columnHasCards(columnNumber)) { //colms.get(i).hasCards()
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                removeCount++;
                this.cols.get(columnNumber).cards.remove(this.cols.get(columnNumber).cards.size() - 1);
            }
        }
    }

    public boolean ifWon() {
        int size = deck.returnDeckSize();
        boolean flag = false;
        if(size == 0) {
            for(int i = 0; i < 4; i++) {
                Card temp = getTopCard(i);
                if (temp.getValue() != 14) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean columnHasCards(int columnNumber) {
        if(this.cols.get(columnNumber).cards.size()>0){      //colms.get(i).hasCards();
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).cards.get(this.cols.get(columnNumber).cards.size()-1); //colms.get(i).getTopCard();
    }


    public void move(int columnFrom, int columnTo) {
        Card cardToMove = getTopCard(columnFrom);
        if (this.cols.get(columnTo).cards.size() > 0) {        //if (columnTo.hadCards() == true)
            validMove = false;
        }
        else if (cardToMove.getValue() < 14) {
            validMove = false;
        }
        else {
            validMove = true;
            this.removeCardFromCol(columnFrom);
            this.addCardToCol(columnTo, cardToMove);
        }
        userWon = ifWon();
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).cards.add(cardToMove);  //colms.get(i).addCard(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).cards.remove(this.cols.get(colFrom).cards.size()-1); //colms.get(i).removeTopCard();
    }


}