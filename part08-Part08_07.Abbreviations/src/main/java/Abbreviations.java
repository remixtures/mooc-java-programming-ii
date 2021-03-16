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

public class Abbreviations {
    
    private HashMap<String, String> listOfAbbreviations;
    
    public Abbreviations() {
        this.listOfAbbreviations = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        if (hasAbbreviation(abbreviation)) {
            System.out.println("Sorry. The abbreviation has already been added.");
        } else {
            listOfAbbreviations.put(abbreviation, explanation);
        }
    } 
    
    public boolean hasAbbreviation(String abbreviation) {
        return this.listOfAbbreviations.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        return this.listOfAbbreviations.get(abbreviation);
    }
    
    
}
