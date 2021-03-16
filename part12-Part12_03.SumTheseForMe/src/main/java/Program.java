
public class Program {

    public static void main(String[] args) {
        int[] numbers = {8, -2, 3, 1, 1};
        System.out.println(sum(numbers, 0, numbers.length, 0, 999));
    }
    
    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        int sum = 0;
        if (fromWhere < 0) {
            fromWhere = 0;
        }
        
        if (toWhere > array.length) {
            toWhere = array[array.length -1];
        }
        
        for (int i = fromWhere; i < toWhere; i++) {
            if (array[i] >= smallest && array[i] <= largest) {
                sum += array[i];
            } 
        }
        
        return sum;
    }
}
