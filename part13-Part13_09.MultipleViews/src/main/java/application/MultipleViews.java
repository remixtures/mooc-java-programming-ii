package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MultipleViews extends Application {

    @Override
    public void start(Stage stage) {
                
        BorderPane firstLayout = new BorderPane();
        Label firstLabel = new Label("First view!");
        Button fromFirstToSecond = new Button("To the second view!");
        firstLayout.topProperty().set(firstLabel);
        firstLayout.centerProperty().set(fromFirstToSecond);
        Scene first = new Scene(firstLayout);
        
        VBox secondLayout = new VBox();        
        Button fromSecondToThird = new Button("To the third view!");
        Label secondLabel = new Label("Second view!");
        secondLayout.getChildren().addAll(fromSecondToThird, secondLabel);
        Scene second = new Scene(secondLayout);

        GridPane thirdLayout = new GridPane();
        Label thirdLabel = new Label("Third view!");
        Button fromThirdToFirst = new Button("To first view!");
        thirdLayout.add(thirdLabel, 0, 0);
        thirdLayout.add(fromThirdToFirst, 1, 1);
        Scene third = new Scene(thirdLayout);
        
        fromFirstToSecond.setOnAction((event) -> {
            stage.setScene(second);    
        });
        
        fromSecondToThird.setOnAction((event) -> { 
            stage.setScene(third);
        });
        
        fromThirdToFirst.setOnAction((event) -> {
            stage.setScene(first);
        });
        
        stage.setScene(first);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(MultipleViews.class, args);
    }
}
