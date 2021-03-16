package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        System.out.println("Give a title:");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        Application.launch(UserTitle.class, 
                "--title=" + userInput);
    }

}
