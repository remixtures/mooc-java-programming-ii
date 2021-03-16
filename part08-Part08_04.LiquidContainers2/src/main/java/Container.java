/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
public class Container {
    
    private int amount;
    
    public Container() {
        this.amount = 0;
    }

    public int contains() {
        return amount;
    }
    
    public void add(int amount) {
        if (this.contains() + amount < 100 && amount > 0) {
            this.amount += amount;
        } else {
            this.amount = 100;
        }
    }
    
    public void move(int amount, Container second) {
        if (this.contains() - amount >= 0 && amount > 0) {
            this.amount -= amount;
            second.add(amount);
        } else if (this.contains() <= amount &&
                second.contains() + amount <= 100 && amount > 0) {
            second.add(this.contains());
            this.amount = 0;
        }    
    }
   
    public void remove(int amount) {
        if (this.contains() - amount > 0) {
            this.amount -= amount;
        } else {
            this.amount = 0;
        }
    }

    @Override
    public String toString() {
        return this.contains() + "/100";
    }
    
    
    
}
