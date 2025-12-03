import Grid.Board;
import Grid.View;
import Rules.Game;

public class Main {
        public static void main(String[] args) {
            Board board = new Board();
            board.setInitialDigit(0, 0, 5);
            board.setInitialDigit(0, 1, 3);
            board.setInitialDigit(4, 4, 7);
            board.setInitialDigit(8, 8, 9);
            View view = new View();
            Game controller = new Game(board, view);
            controller.start();
        }
    }