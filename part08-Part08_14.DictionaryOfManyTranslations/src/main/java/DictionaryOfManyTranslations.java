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

public class DictionaryOfManyTranslations {
    
    private HashMap<String, ArrayList<String>> dictionary;
    
    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }
    
    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, new ArrayList<>());
        
        this.dictionary.get(word).add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        ArrayList<String> translations = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : dictionary.entrySet()) {
            if (entry.getKey().equals(word)) {
                translations = entry.getValue();
            }
        }
        return translations;
    }
    
    public void remove(String word) {
        this.dictionary.remove(word);
    }
    
}
