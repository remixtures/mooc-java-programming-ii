/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
import java.util.Scanner;

public class UserInterface {
    
    private final Scanner input;
    private TodoList list;
    
    public UserInterface(TodoList list, Scanner input) {
        this.list = list;
        this.input = input;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String userCommand = input.nextLine();
            switch (userCommand) {
                case "add":
                    addTask();
                    break;
                case "list":
                    listTasks();
                    break;
                case "remove":
                    removeTask();
                    break;
                case "stop":
                    return;
            }
        }
    }
    
    public void addTask() {
        System.out.print("To add: ");
        String taskToAdd = input.nextLine();
        list.add(taskToAdd);
    }
    
    public void listTasks() {
        list.print();
    }
    
    public void removeTask() {
        System.out.print("Which one is removed? ");
        int taskIndex = input.nextInt();
        list.remove(taskIndex);
    }   
}
