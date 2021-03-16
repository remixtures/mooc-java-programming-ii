
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    
    public static List<Book> readBooks(String file) {
        List<Book> library = new ArrayList<>();
        
        try {
            Files.lines(Paths.get(file))
                    .map(title -> title.split(","))
                    .map(title -> new Book(title[0], Integer.valueOf(title[1]), Integer.valueOf(title[2]), title[3]))
                    .forEach(title -> library.add(title));
        } catch(Exception e) {
            System.out.println("Could not read file. " + e.getMessage());
        }
        
        return library;
    }

}
