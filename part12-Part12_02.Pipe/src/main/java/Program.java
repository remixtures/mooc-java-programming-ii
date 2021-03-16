
public class Program {

    public static void main(String[] args) {
        // you may try out your class here
        Pipe<Integer> numberPipe = new Pipe<>();
        numberPipe.putIntoPipe(1);
        numberPipe.putIntoPipe(2);
        numberPipe.putIntoPipe(3);

        int sum = 0;
        while (numberPipe.isInPipe()) {
            sum = sum + numberPipe.takeFromPipe();
        }
        
        System.out.println(sum);
        System.out.println(numberPipe.takeFromPipe());
    }
}
