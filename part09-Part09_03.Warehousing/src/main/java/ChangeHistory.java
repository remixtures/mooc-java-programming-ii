/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 * 
 */
import java.util.ArrayList;

public class ChangeHistory {
    
    private ArrayList<Double> amountChanges;
    
    public ChangeHistory() {
        this.amountChanges = new ArrayList<>();
    }
    
    public void add(double status) {
        this.amountChanges.add(status);
    }
    
    public void clear() {
        this.amountChanges.clear();
    }
    
    public String toString() {
        return this.amountChanges.toString();
    }
    
    public double maxValue() {
        
        double max = 0.0;
        
        if (!this.amountChanges.isEmpty()) {
            for (Double amount : this.amountChanges) {
                if (amount >= max) {
                    max = amount;
                }
            }
        }
        
        return max;
    }
    
    public double minValue() {
        
        double min = Double.MAX_VALUE;
        
        if (!this.amountChanges.isEmpty()) {
            for (Double amount : this.amountChanges) {
                if (amount <= min) {
                    min = amount;
                }
            }
        } else {
            return 0.0;
        }
        
        return min;
    }
    
    public double average() {
        
        double sum = 0.0;
        double average = 0.0;
        if (!this.amountChanges.isEmpty()) {
            for (Double amount : this.amountChanges) {
                sum += amount;
            }
        }
        
        average = sum / this.amountChanges.size();
        
        return average;
    }
}
