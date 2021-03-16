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

public class Box implements Packable {
    
    private ArrayList<Packable> listOfPackables;
    private double maxCapacity;
    
    public Box(double maxCapacity) {
        this.listOfPackables = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }
    
    public void add(Packable packable) {
        if (packable.weight() + weight() <= this.maxCapacity) {
            this.listOfPackables.add(packable);
        }
    }
    
    public double weight() {
        double actualCapacity = 0;
        for (Packable packable : this.listOfPackables) {
            actualCapacity += packable.weight();
        }
        return actualCapacity;
    }

    @Override
    public String toString() {
        return "Box: " + this.listOfPackables.size() + " items, total weight " + weight() + " kg";
    }
    
    
    
}
