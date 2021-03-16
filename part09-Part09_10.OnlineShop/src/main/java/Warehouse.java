/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author miguel
 */
public class Warehouse {
    
    private Map<String, Integer> listOfPrices;
    private Map<String, Integer> listOfProducts;
    
    public Warehouse() {
        this.listOfProducts = new HashMap<>();
        this.listOfPrices = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.listOfPrices.put(product, price);
        this.listOfProducts.put(product, stock);
    }
    
    public int price(String product) {
        int price = -99;
        
        if (this.listOfPrices.containsKey(product)) {
            price = this.listOfPrices.get(product);
        }
        
        return price;
    }
    
    public int stock(String product) {
        int stockItems = 0;
        if (this.listOfProducts.containsKey(product)) {
            stockItems = this.listOfProducts.get(product);
        }
        
        return stockItems;
    }
    
    public boolean take(String product) {
       boolean inStock = false;
       if (this.listOfProducts.containsKey(product)) {
           if (this.listOfProducts.get(product) >= 1) {
               int items = this.listOfProducts.get(product);
               this.listOfProducts.put(product, items - 1);
               inStock = true;
           }
       }
        
        return inStock;
    }
    
    public Set<String> products() {
        Set<String> setOfProducts = this.listOfProducts.keySet();
        return setOfProducts;
        
    }
    
}
