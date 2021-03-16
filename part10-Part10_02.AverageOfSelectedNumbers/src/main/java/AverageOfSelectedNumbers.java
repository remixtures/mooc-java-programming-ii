
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while (true) {
            String number = scanner.nextLine();
            if (number.equals("end")) {
                break;
            }
            
            
            numbers.add(number);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String userOption = scanner.nextLine();
        
        switch (userOption) {
            case "n":
                System.out.println("Average of the negative numbers: " 
                        + averageOfNegativeNumbers(numbers));
                break;
            case "p":
                System.out.println("Average of the positive numbers: " 
                        + averageOfPositiveNumbers(numbers));
                break;
            default: 
                System.out.println("Invalid option");
                break;
        }                
    }
     
    public static double averageOfNegativeNumbers(List<String> nums) {
        return nums.stream()
            .mapToInt(value -> Integer.valueOf(value))
            .filter(number -> number < 0) 
            .average()
            .getAsDouble(); 
    } 
    
    public static double averageOfPositiveNumbers(List<String> nums) {
        return nums.stream()
            .mapToInt(value -> Integer.valueOf(value))
            .filter(number -> number >= 0) 
            .average()
            .getAsDouble(); 
    } 
}
