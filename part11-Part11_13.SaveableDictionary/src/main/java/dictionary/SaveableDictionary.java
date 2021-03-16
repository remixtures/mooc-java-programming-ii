/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class SaveableDictionary {
    
    private File file;
    private HashMap<String, String> firstToSecondDictionary; 
    private HashMap<String, String> secondToFirstDictionary;  

    
    public SaveableDictionary() {
        this.firstToSecondDictionary = new HashMap<>();
        this.secondToFirstDictionary = new HashMap<>();
    }
    
    public SaveableDictionary(String file) {
        this();
        this.file = new File(file);
    }    
    
    public void add(String words, String translation) {
        this.firstToSecondDictionary.putIfAbsent(words, translation);
        this.secondToFirstDictionary.putIfAbsent(translation, words);
    }
    
    
    public String translate(String word) {
        String translation = null;
        
        if (this.firstToSecondDictionary.containsKey(word)){
            translation = this.firstToSecondDictionary.get(word);
        }
        
        if (this.secondToFirstDictionary.containsKey(word)){
            translation = this.secondToFirstDictionary.get(word);
        }
        
        return translation;
    }
    
    public void delete(String word) {
        String translation = "";
        
        if (this.firstToSecondDictionary.containsKey(word)){
            translation = this.firstToSecondDictionary.get(word);
            this.firstToSecondDictionary.remove(word);
            this.secondToFirstDictionary.remove(translation);
            
        } else if (this.secondToFirstDictionary.containsKey(word)){
            translation = this.secondToFirstDictionary.get(word);
            this.secondToFirstDictionary.remove(word);
            this.firstToSecondDictionary.remove(translation);
        }
    }
    
    public boolean load() {
        try (Scanner fileReader = new Scanner(this.file)) {
            
            while (fileReader.hasNextLine()) {
               String line = fileReader.nextLine();
               String[] pieces = line.split(":");                       //Splitting line by ":" as we are saving translation in word:translation format
               this.firstToSecondDictionary.put(pieces[1], pieces[0]);         
               this.secondToFirstDictionary.put(pieces[0], pieces[1]);
           }
           return true;
        } catch (Exception e) {
            return false;
        }
    }     
    
    public boolean save() {
        try (PrintWriter writer = new PrintWriter(this.file)) {
            for (String key : this.firstToSecondDictionary.keySet()) {      
                writer.append(key + ":" + this.firstToSecondDictionary.get(key) + "\n");
            }
            
            return true;
        } catch (Exception e){
            return false;
        }
    }    
}
