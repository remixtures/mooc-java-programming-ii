
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
public class Hideout<T> {
    
    private ArrayList<T> objects;
    
    public Hideout() {
        this.objects = new ArrayList<>();
    }
    
    public void putIntoHideout(T toHide) {
        if (!objects.contains(toHide)) {
           objects.clear(); 
           objects.add(toHide);
        } else {
            objects.remove(toHide);
        }
    }
    
    public T takeFromHideout() {
        T item = objects.get(0);
        objects.clear();
        return item;
                
    }
    
    public boolean isInHideout() {
        boolean hidden = false;
        
        if (!objects.isEmpty()) {
            hidden = true; 
        } 
        
        return hidden;
    }
    
}
