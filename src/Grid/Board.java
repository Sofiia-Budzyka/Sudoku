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
            return cells[row][col];
        }
        public void setInitialDigit(int row, int col, int value) {
            cells[row][col] = new Cell(value, true);
        }
}