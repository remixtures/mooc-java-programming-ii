
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<LiteracyRates> literacies = new ArrayList<>();
        try (Scanner input = new Scanner(new File("literacy.csv"))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] pieces = line.split(",");
                String countryName = pieces[3];
                int year = Integer.valueOf(pieces[4]);
                String[] genderField = pieces[2].split(" ");
                String gender = genderField[1];
                double literacyPercentage = Double.valueOf(pieces[5]);
                literacies.add(new LiteracyRates(gender, countryName, year, literacyPercentage));                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }    

        literacies.stream().sorted((country1, country2) -> {
            return Double.valueOf(country1.getLiteracyLevel()).compareTo(Double.valueOf(country2.getLiteracyLevel()));
        }).forEach(country -> System.out.println(country));
    }
}
