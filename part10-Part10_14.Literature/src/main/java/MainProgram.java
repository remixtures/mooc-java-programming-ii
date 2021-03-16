import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String bookTitle = scanner.nextLine();
            if (bookTitle.isEmpty()) {
                break;
            }
            System.out.print("Input the age recommendation: ");
            int ageRecommendation = Integer.valueOf(scanner.nextLine());
            listOfBooks.add(new Book(bookTitle, ageRecommendation));
            System.out.println();
        }
        System.out.println("");
        getLibrarySize(listOfBooks);
        System.out.println("");
        Comparator<Book> comparator = Comparator
              .comparing(Book::getAgeRecommendation)
              .thenComparing(Book::getTitle);
        Collections.sort(listOfBooks, comparator);
        getLibraryContents(listOfBooks);
        
    }
    
    public static void getLibrarySize(ArrayList<Book> listOfBooks) {
         System.out.println(listOfBooks.stream()
                .count() + " books in total.");
    }
    
    public static void getLibraryContents(ArrayList<Book> listOfBooks) {
        System.out.println("Books:");
        listOfBooks.stream().forEach(p -> System.out.println(p));
    }

}
