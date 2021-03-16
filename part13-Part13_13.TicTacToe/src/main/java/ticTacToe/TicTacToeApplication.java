package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {
    
    private Game game;
    
    public TicTacToeApplication() {
        game = new Game();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        Label turnInfo = new Label("Turn: X");
        turnInfo.setFont(Font.font("Monospaced", 40));

        layout.setTop(turnInfo);
        
        GridPane matrixPane = new GridPane();
        matrixPane.setPadding(new Insets(10));
        matrixPane.setHgap(10);
        matrixPane.setVgap(10);
        
        layout.setCenter(matrixPane);
        
        Button[][] cellButtons = new Button[3][3];
        
        for (int row = 0; row < cellButtons.length; row++) {
            for (int column = 0; column < cellButtons[row].length; column++) {
                Button gameButton = new Button(" ");
                cellButtons[row][column] = gameButton;
                gameButton.setFont(Font.font("Monospaced", 40));
                matrixPane.add(gameButton, column, row);
                
                gameButton.setOnAction((t) -> {
                    int rowIndex = GridPane.getRowIndex(gameButton);
                    int columnIndex = GridPane.getColumnIndex(gameButton);
                    if (game.move(rowIndex, columnIndex)) {
                        gameButton.setText(game.getCell(rowIndex, columnIndex).name());
                    }

                    if (game.isFinished()) {
                        turnInfo.setText("The end!");
                    } else {
                        turnInfo.setText("Turn: " + game.getPlayer().name());
                    }
                });
            }  
        }    
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}
