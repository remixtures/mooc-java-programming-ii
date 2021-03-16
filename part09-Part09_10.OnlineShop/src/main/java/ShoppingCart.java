/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author miguel
 */
public class ShoppingCart {
    
    private Map<String, Item> bagOfItems;
    
    public ShoppingCart() {
        this.bagOfItems = new HashMap<>();
    }
    
    public void add(String product, int price) {
        this.bagOfItems.putIfAbsent(product, new Item(product, 0, price));
        this.bagOfItems.get(product).increaseQuantity();   
    }
    
    public int price() {
        int sum = 0; 
        for (Item item : this.bagOfItems.values()) {
            sum += item.price();
        }
      
        return sum;
    }
    
    public void print() {
        for (Item item : this.bagOfItems.values()) {
            System.out.println(item);
        }    
    }
    
}
