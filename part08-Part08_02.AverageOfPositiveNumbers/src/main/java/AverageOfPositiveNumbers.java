
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        int count = 0;
        while (true) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                break;
            }
            if (number > 0) {
                sum += number;
                count++;
            }
        }
        
        if (sum > 0) {
            System.out.println(calculateAverage(sum, count));
        } else {
            System.out.println("Cannot calculate the average");
        }
    }
    
    public static double calculateAverage(int sum, int count) {
        return (double) sum / count;
    }
}
