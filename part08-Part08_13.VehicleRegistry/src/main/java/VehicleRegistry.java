/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class VehicleRegistry {
    
    private HashMap<LicensePlate, String> listOfLicensePlates;
    
    public VehicleRegistry() {
        this.listOfLicensePlates = new HashMap<>();
    }
    
    public boolean add(LicensePlate licenseNumber, String owner) {
        if (this.listOfLicensePlates.containsKey(licenseNumber)) {
            return false;
        } else {
            this.listOfLicensePlates.put(licenseNumber, owner);
            return true;
        }
    }
    
    public String get(LicensePlate licensePlate) {
        for (Map.Entry<LicensePlate, String> plate : listOfLicensePlates.entrySet()) {
            if (plate.getKey().equals(licensePlate)) {
                return plate.getValue();
            }
        }
        
        return null;
    }
    
    public boolean remove(LicensePlate licensePlate) {
       if (!this.listOfLicensePlates.containsKey(licensePlate)) {
            return false;
        } else {
            this.listOfLicensePlates.remove(licensePlate);
            return true;
        } 
    }
    
    public void printLicensePlates() {
        for (LicensePlate licensePlate : this.listOfLicensePlates.keySet()) {
            System.out.println(licensePlate.toString());
        }
    }    
    
    public void printOwners() {
         for (String owner : new HashSet<>(listOfLicensePlates.values())) {
            System.out.println(owner);            
        }
    }
}
