package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
 
public class TextStatisticsApplication extends Application {
 
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
 
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        TextArea topText = new TextArea();
        Label length = new Label();
        Label wordNumber = new Label();
        Label longestWord = new Label();
        
        topText.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
            length.setText("Letters: " + String.valueOf(characters));
            wordNumber.setText("Words: " + String.valueOf(words));
            longestWord.setText("The longest word is: " + longest);
        });        
        layout.setCenter(topText);
        
        HBox rows = new HBox();
        rows.setSpacing(20);
        rows.getChildren().add(length);
        rows.getChildren().add(wordNumber);
        rows.getChildren().add(longestWord);
        
        layout.setBottom(rows);
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }
}
