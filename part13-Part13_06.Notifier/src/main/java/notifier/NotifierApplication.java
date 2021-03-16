package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application {

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) {
        TextField topText = new TextField();
        Button middleButton = new Button("Update");
        Label bottomLabel = new Label();
        middleButton.setOnAction((event) -> {
            bottomLabel.setText(topText.getText());
        });
        
        VBox verticalBox = new VBox();
        verticalBox.setSpacing(20);
        verticalBox.getChildren().addAll(topText, middleButton, bottomLabel);
        
        Scene scene = new Scene(verticalBox);
        window.setScene(scene);
        window.show();
    }
}
