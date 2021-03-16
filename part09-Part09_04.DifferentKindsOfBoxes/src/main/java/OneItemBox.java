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

public class OneItemBox extends Box {
    
    private ArrayList<Item> listOfItems;
    private int maxWeight;
    
    public OneItemBox() {
        this.maxWeight = 1;
        this.listOfItems = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (listOfItems.isEmpty()) {
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
    
}
