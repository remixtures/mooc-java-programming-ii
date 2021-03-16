/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {
    
    private ChangeHistory changeHistory;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.changeHistory = new ChangeHistory();
        this.changeHistory.add(initialBalance);
        super.setBalance(initialBalance);
    }
    
    public String history() {
        return this.changeHistory.toString();
    }
    
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.changeHistory.add(getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        this.changeHistory.add(getBalance());
        return amountTaken;
    }
    
    public void printAnalysis() {
        System.out.printf("Product: %s %nHistory: %s %n"
                + "Largest amount of product: %.1f%n"
                + "Smallest amount of product: %.1f%n"
                + "Average: %.1f%n", 
                super.getName(), this.changeHistory, this.changeHistory.maxValue(), 
                this.changeHistory.minValue(), this.changeHistory.average());
    }
    
    
}
