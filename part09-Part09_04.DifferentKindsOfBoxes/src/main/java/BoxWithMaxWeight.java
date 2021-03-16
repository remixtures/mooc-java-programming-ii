/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    
    private ArrayList<Item> listOfItems;
    private int maxWeight;

    public BoxWithMaxWeight(int capacity) {
        this.maxWeight = capacity;
        this.listOfItems = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (item.getWeight() + getTotalWeight() <= this.maxWeight) {
            this.listOfItems.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        boolean stored = false;
        for (Item element : listOfItems) {
            if (element.getName().equals(item.getName())) {
                stored = true;
            }
        }
        
        return stored;

    }
    
    public int getTotalWeight() {
        int sum = 0;
        for (Item item : listOfItems) {
           sum += item.getWeight(); 
        }
        
        return sum;
    }
    
    
}
