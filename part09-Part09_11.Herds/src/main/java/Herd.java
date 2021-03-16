/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author miguel
 */
public class Herd implements Movable {
    
    private ArrayList<Movable> herdList;
    
    public Herd() {
        this.herdList = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "";
        for (Movable movable : this.herdList) {
            result += movable + "\n";
        }
        
        return result;
    }
    
    public void addToHerd(Movable movable) {
        this.herdList.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : this.herdList) {
            movable.move(dx, dy);
        }
    }   
}
