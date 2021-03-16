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
import java.util.HashMap;
import java.util.Map;

public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> container;
    
    public StorageFacility() {
        this.container = new HashMap<>();
    }
    
    public void add(String storageUnit, String item) {
       this.container.putIfAbsent(storageUnit, new ArrayList<>());
       
       this.container.get(storageUnit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return this.container.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        if (this.container.containsKey(storageUnit)) { 
           this.container.get(storageUnit).remove(item);
        }
        
        if (this.container.get(storageUnit).isEmpty()) {
            this.container.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> listOfStorageUnits = new ArrayList<>(); 
        for (String unit : this.container.keySet()) {
            listOfStorageUnits.add(unit);
        }    
        
        return listOfStorageUnits;
    }    
}