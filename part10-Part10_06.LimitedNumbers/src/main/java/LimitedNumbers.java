
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput == -1) {
                break;
            }
            
            numbers.add(userInput);
        }
        
        numbersInRange(numbers);
        
        
    }
    
    public static void numbersInRange(List<Integer> numbers) {
        ArrayList<Integer> numbersInputted = numbers.stream()
                .filter(number -> number >= 1 && number <= 5)
                .collect(Collectors.toCollection(ArrayList::new));
        
        for (Integer value : numbersInputted) {
            System.out.println(value);
        }
    }
}