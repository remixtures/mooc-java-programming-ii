
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
public class MisplacingBox extends Box {
    
    private ArrayList<Item> listOfItems;
    
    public MisplacingBox() {
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
        return false;
    }   
    
}
