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

public class TodoList {
    
    private ArrayList<String> listOfTasks;
     
    public TodoList() {
        listOfTasks = new ArrayList<>();
    }
    
    public void add(String task) {
        listOfTasks.add(task);
    }
    
    public void print() {
        int index = 1;
        for (String task : listOfTasks) {
            System.out.println(index + ": " + task);
            index++;
        }
    }
    
    public void remove(int number) {
        listOfTasks.remove(number - 1);
    } 
}
