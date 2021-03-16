
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();
        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);    
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            } else {
                String[] parts = input.split(" ");
                String userOptions = parts[0];
                int amount = Integer.valueOf(parts[1]);
                
                switch (userOptions) {
                    case "add":
                        first.add(amount);
                        break;
                    case "move":
                        first.move(amount, second);
                        break;    
                    case "remove":    
                        second.remove(amount);
                        break;
                }
            }

        }
    }    
}
