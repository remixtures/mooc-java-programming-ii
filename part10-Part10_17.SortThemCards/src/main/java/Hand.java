/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author miguel
 */
public class Hand implements Comparable<Hand> {
    
    private List<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        this.cards.stream()
            .forEach(card -> {
                System.out.println(card);
            });
    }
    
    public int getSumOfValues() {
        return cards.stream()
                .mapToInt(card -> card.getValue()).sum();
    }
    
    public void sort() {
        Collections.sort(this.cards);
    }

    @Override
    public int compareTo(Hand hand) {
        return this.getSumOfValues() - hand.getSumOfValues();
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());

    }
    
}
