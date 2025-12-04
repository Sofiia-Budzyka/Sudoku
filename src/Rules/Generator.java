package Rules;

import Grid.Board;
import Grid.Cell;

import java.util.Random;

public class Generator {
    private Random random = new Random();
    private int[][] solvedGrid = new int[9][9];

    public void generateNewGame(Board board) {
        clearBoard(board);
        fillBoard(board, 0, 0);
        saveSolution(board);
        removeNumbers(board, 27);
        ensureCoverage(board);
    }
    private boolean fillBoard(Board board, int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            return true;
        }
        if (board.getCell(row, col).getValue() != 0) {
            return fillBoard(board, row, col + 1);
        }
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(numbers);
        for (int num : numbers) {
            if (isSafe(board, row, col, num)) {
                board.setInitialDigit(row, col, num);
                if (fillBoard(board, row, col + 1)) {
                    return true;
                }
                board.getCell(row, col).setValue(0);
            }
        }
        return false;
    }
    private boolean isSafe(Board board, int row, int col, int num) {
        for (int i = 0; i <9; i++) {
            if (board.getCell(row, i).getValue() == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board.getCell(i, col).getValue() == num) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i + startRow, j + startCol).getValue() == num) {
                    return false;
                }
            }
        }
        return true;
    }
    private void removeNumbers(Board board, int countToRemove) {
        int count = countToRemove;
        while (count > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            Cell cell = board.getCell(row, col);
            if (cell.getValue() != 0) {
                cell.setFixed(false);
                cell.setValue(0);
                count--;
            }
        }
    }
    private void ensureCoverage(Board board) {
        for (int i = 0; i < 9; i++) {
            if (isRowEmpty(board, i)) restoreRandomCellInRow(board, i);
            if (isColEmpty(board, i)) restoreRandomCellInCol(board, i);
        }
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (isBlockEmpty(board, r, c)) restoreRandomCellInBlock(board, r, c);
            }
        }
    }
    private void restoreRandomCellInRow(Board board, int row) {
        int randomCol = random.nextInt(9);
        board.getCell(row, randomCol).setValue(solvedGrid[row][randomCol]);
    }
    private void restoreRandomCellInCol(Board board, int col) {
        int randomRow = random.nextInt(9);
        board.getCell(randomRow, col).setValue(solvedGrid[randomRow][col]);
    }
    private void restoreRandomCellInBlock(Board board, int startRow, int startCol) {
        int r = startRow + random.nextInt(3);
        int c = startCol + random.nextInt(3);
        board.getCell(r, c).setValue(solvedGrid[r][c]);
    }
    private boolean isRowEmpty(Board board, int row) {
        for (int c = 0; c < 9; c++) if (board.getCell(row, c).getValue() != 0) return false;
        return true;
    }
    private boolean isColEmpty(Board board, int col) {
        for (int r = 0; r < 9; r++) if (board.getCell(r, col).getValue() != 0) return false;
        return true;
    }
    private boolean isBlockEmpty(Board board, int startRow, int startCol) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(startRow + i, startCol + j).getValue() != 0) return false;
            }
        }
        return true;
    }
    private void saveSolution(Board board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                solvedGrid[r][c] = board.getCell(r, c).getValue();
            }
        }
    }
    private void clearBoard(Board board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                board.getCell(r, c).setValue(0);
            }
        }
    }

    private void shuffleArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}