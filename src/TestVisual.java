import Grid.Board;
import Grid.View;
public class TestVisual {
    public static void main(String[] args) {
        Board board = new Board();
        View view = new View();
            System.out.println("Порожня дошка:");
            view.drawBoard(board);
            board.setInitialDigit(0, 0, 5);
            board.setInitialDigit(0, 1, 3);
            board.setInitialDigit(1, 3, 6);
            board.setInitialDigit(2, 7, 9);
            board.setInitialDigit(4, 4, 1);
            board.setInitialDigit(8, 8, 2);
            board.getCell(1, 1).setValue(7);
            board.getCell(5, 5).setValue(4);
            System.out.println("Дошка з даними:");
            view.drawBoard(board);
        }
}
