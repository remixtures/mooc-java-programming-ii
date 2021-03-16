package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            
            if (command.equals("x")) {
                break;
            }
            
            switch (Integer.parseInt(command)) {
                case 1:
                    listContents();
                    break;
                case 2:
                    addNewToDos();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    removeTask();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        System.out.println("Thank you!");
    }
    
    public void listContents() throws SQLException {
        System.out.println("Listing the database contents");
        System.out.println(database.list());
    }
    
    public void addNewToDos() throws SQLException {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        String description = scanner.nextLine();
        database.add(new Todo(name, description, false));
    }
    
    public void markTaskAsCompleted() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        int todoCompleted = Integer.parseInt(scanner.nextLine());
        database.markAsDone(todoCompleted);
    }
    
    public void removeTask() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int todoToRemove = Integer.parseInt(scanner.nextLine());
        database.remove(todoToRemove);
    }
}
