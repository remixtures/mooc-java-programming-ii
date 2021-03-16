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

    public int getAmount() {
        return amount;
    }
    
    public void addAmount(int amount) {
        if (this.getAmount() + amount < 100 && amount > 0) {
            this.amount += amount;
        } else {
            this.amount = 100;
        }
    }
    
    public void moveAmount(int amount, Container second) {
        if (this.getAmount() - amount >= 0 && amount > 0) {
            this.amount -= amount;
            second.addAmount(amount);
        } else if (this.getAmount() <= amount &&
                second.getAmount() + amount <= 100 && amount > 0) {
            second.addAmount(this.getAmount());
            this.amount = 0;
        }    
    }
    
    public void removeAmount(int amount) {
        if (this.getAmount() - amount > 0) {
            this.amount -= amount;
        } else {
            this.amount = 0;
        }
    }
}
