
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();
        while (true) {
            System.out.println("First: " + first.getAmount() + "/100");
            System.out.println("Second: " + second.getAmount() + "/100");    
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            } else {
                String[] parts = input.split(" ");
                String userOptions = parts[0];
                int amount = Integer.valueOf(parts[1]);
                
                switch (userOptions) {
                    case "add":
                        first.addAmount(amount);
                        break;
                    case "move":
                        first.moveAmount(amount, second);
                        break;
                    case "remove":    
                        second.removeAmount(amount);
                        break;
                }
            }

        }
    }

}
