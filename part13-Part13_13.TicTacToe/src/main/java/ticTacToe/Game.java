/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.Objects;

/**
 *
 * @author miguel
 */
public class Game {
    
    private Player player = Player.X;
    private GameStatus state = GameStatus.ONGOING;

    private Player[][] matrix = new Player[3][3];

    public boolean move(int row, int column) {
        if (state != GameStatus.ONGOING) {
            return false;
        }
        if (!Objects.isNull(matrix[row][column])) {
            return false;
        }

        matrix[row][column] = player;
        update(row, column);

        return true;
    }

    private void update(int row, int col) {
        if (hasWon(row, col)) {
            state = (player == Player.X) ? GameStatus.X_WINS : GameStatus.O_WINS;
        } else if (isDraw()) {
            state = GameStatus.DRAW;
        }

        changeTurn();
    }

    public boolean hasWon(int currentRow, int currentColumn) {
        return (matrix[currentRow][0] == player // 3 row
                && matrix[currentRow][1] == player
                && matrix[currentRow][2] == player
                //3 column
                || matrix[0][currentColumn] == player
                && matrix[1][currentColumn] == player
                && matrix[2][currentColumn] == player
                //3 diagonal
                || currentRow == currentColumn
                && matrix[0][0] == player
                && matrix[1][1] == player
                && matrix[2][2] == player
                //3 opposite diagonal
                || currentRow + currentColumn == 2
                && matrix[0][2] == player
                && matrix[1][1] == player
                && matrix[2][0] == player);
    }

    private boolean isDraw() {
        for (Player[] players : matrix) {
            for (Player player : players) {
                if (player == null) {
                    return false;
                }
            }
        }

        return true;
    }

    private void changeTurn() {
        player = (player == Player.X) ? Player.O : Player.X;
    }

    public boolean isFinished() {
        return (state == GameStatus.DRAW || state == GameStatus.O_WINS || state == GameStatus.X_WINS);
    }

    public Player getPlayer() {
        return player;
    }

    public Player getCell(int row, int column) {
        return matrix[row][column];
    }
    
}
