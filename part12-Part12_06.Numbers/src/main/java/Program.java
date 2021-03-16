
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers should be printed?");
        int size = Integer.valueOf(input.nextLine());
        
        Random randomValue = new Random();
        
        for (int i = 0; i < size; i++) {
            System.out.println(randomValue.nextInt(11));
        }
    }

}
