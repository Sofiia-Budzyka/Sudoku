package Grid;

public class View {
    public void drawBoard(Board board) {
        for (int row = 0; row < 9; row++) {
            if (row > 0 && row % 3 == 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < 9; col++) {
                if (col > 0 && col % 3 == 0) {
                    System.out.print("| ");
                }
                Cell cell = board.getCell(row, col);
                int value = cell.getValue();
                String displayValue = (value == 0) ? "." : String.valueOf(value);
                System.out.print(displayValue + " ");
                }
                System.out.println();
            }
            System.out.println("--------------------\n");
        }
    }

