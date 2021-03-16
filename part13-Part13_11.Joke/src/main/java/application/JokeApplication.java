package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        // 1. Create main layout
        BorderPane layout = new BorderPane();

        // 1.1. Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 1.2. Create buttons for menu
        Button first = new Button("Joke");
        Button second = new Button("Answer");
        Button third = new Button("Explanation");

        // 1.3. Add buttons to menu
        menu.getChildren().addAll(first, second, third);

        layout.setTop(menu);


        // 2. Add subviews and add them to the menu buttons
        // 2.1. Create subview layout 
        StackPane firstLayout = createView("What do you call a bear with no teeth?");
        StackPane secondLayout = createView("A gummy bear.");
        StackPane thirdLayout = createView("The soft, red part that your teeth seem to come out of is called your gums.\n" 
                    + "When you lose a tooth your gums will probably bleed a little but it is nothing to worry about.\n" 
                    + "There is also a type of candy (also spelled gummi bear).\n" 
                    + "A bear that has no teeth probably still has gums. This play on words makes him a gummy bear and makes this joke funny.");

        // 2.2. Add subviews to button. Pressing the buttons will change the view
        first.setOnAction((event) -> layout.setCenter(firstLayout));
        second.setOnAction((event) -> layout.setCenter(secondLayout));
        third.setOnAction((event) -> layout.setCenter(thirdLayout));

        // 2.3. Set initial view
        layout.setCenter(firstLayout);


        // 3. Create main scene with layout 
        Scene scene = new Scene(layout);


        // 4. Show the main scene
        window.setScene(scene);
        window.show();
    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
