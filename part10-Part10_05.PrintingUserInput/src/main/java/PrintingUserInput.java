
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                break;
            }
            
            words.add(userInput);
        }
        
        String inputtedWords = words.stream()
                .reduce("", (previousWord, word) -> previousWord + word + "\n");
        
        System.out.println(inputtedWords);

    }
}
