
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
public class Pipe<T> {
    
    private ArrayList<T> tubes;
    
    public Pipe() {
        this.tubes = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.tubes.add(value);
    }
    
    public T takeFromPipe() {
        T item = null;
        if (!this.tubes.isEmpty()) {
            item = this.tubes.get(0);
            this.tubes.remove(0);           
        }
        
        return item;
    }
    
    public boolean isInPipe() {
        return !this.tubes.isEmpty();
    }
    
}
