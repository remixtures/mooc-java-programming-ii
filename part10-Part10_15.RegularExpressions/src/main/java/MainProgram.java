
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Scanner input = new Scanner(System.in);
        Checker checker = new Checker();
        System.out.print("Enter a string: ");
        String word = input.nextLine();
        checker.isDayOfWeek(word);
        checker.allVowels(word);
        checker.timeOfDay(word);
    }
}
