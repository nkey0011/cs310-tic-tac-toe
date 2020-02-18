package keywords;

import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
    private TicTacToeModel board;

    public void startNew3x3Game() {
        board = new TicTacToeModel();
    }

    public void startNew5x5Game() {
        board = new TicTacToeModel(5);
    }

    public void startNew7x7Game() {
        board = new TicTacToeModel(7);
    }

    public void markLocation(int row, int col) {
        board.makeMark(row, col);
    }

    public String getMark(int row, int col) {
        return board.getMark(row, col).toString();
    }

    public String getWinner() {
        return board.getResult().toString().toUpperCase();
    }

}