package Rules;

import Grid.Board;

public class Validator {
    public boolean isValidMove(Board board, int row, int col, int value) {
        for (int c = 0; c < 9; c++) {
            if (c != col && board.getCell(row, c).getValue() == value) {
                return false;
            }
        }
        for (int r = 0; r < 9; r++) {
            if (r != row && board.getCell(r, col).getValue() == value) {
                return false;
            }
        }
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int c = boxColStart; c < boxColStart + 3; c++) {
                if (r != row && c != col && board.getCell(r, c).getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isGameFinished(Board board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getCell(i, j).getValue() == 0) return false;
            }
        }
        return true;
    }
}
