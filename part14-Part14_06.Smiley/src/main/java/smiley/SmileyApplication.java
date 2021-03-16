package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        painter.setFill(Color.BLACK);
        painter.fillRect(120, 40, 50, 50);
        painter.fillRect(310, 40, 50, 50);
        painter.fillRect(80, 200, 50, 50);
        painter.fillRect(350, 200, 50, 50);
        painter.fillRect(130, 250, 220, 50); 
       
        BorderPane layout = new BorderPane();
        layout.setCenter(paintingCanvas);
        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
        
    }

}
