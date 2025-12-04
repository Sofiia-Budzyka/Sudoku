package Grid;

public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new Cell(0, false);
            }
        }
    }
    public Cell getCell(int row, int col) {
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
            return cells[row][col];
        }
        return null;
    }
    public void setInitialDigit(int row, int col, int value) {
        Cell cell = cells[row][col];
        cell.setFixed(false);
        cell.setValue(value);
        cell.setFixed(true);
    }
}