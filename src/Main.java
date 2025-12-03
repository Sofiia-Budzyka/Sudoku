import Grid.Board;
import Grid.View;
import Rules.Game;

public class Main {
        public static void main(String[] args) {
            Board board = new Board();
            board.setInitialDigit(0, 0, 5);
            board.setInitialDigit(0, 1, 3);
            board.setInitialDigit(0, 3, 6);
            board.setInitialDigit(0, 4, 7);
            board.setInitialDigit(0, 5, 8);
            board.setInitialDigit(0, 8, 2);

            board.setInitialDigit(1, 0, 6);
            board.setInitialDigit(1, 1, 7);
            board.setInitialDigit(1, 2, 2);
            board.setInitialDigit(1, 3, 1);
            board.setInitialDigit(1, 4, 9);
            board.setInitialDigit(1, 5, 5);

            board.setInitialDigit(2, 0, 1);
            board.setInitialDigit(2, 1, 9);
            board.setInitialDigit(2, 2, 8);
            board.setInitialDigit(2, 3, 3);
            board.setInitialDigit(2, 5, 2);
            board.setInitialDigit(2, 7, 6);

            board.setInitialDigit(3, 0, 8);
            board.setInitialDigit(3, 1, 5);
            board.setInitialDigit(3, 2, 9);
            board.setInitialDigit(3, 3, 7);
            board.setInitialDigit(3, 4, 6);
            board.setInitialDigit(3, 5, 1);
            board.setInitialDigit(3, 8, 3);

            board.setInitialDigit(4, 0, 4);
            board.setInitialDigit(4, 1, 2);
            board.setInitialDigit(4, 3, 8);
            board.setInitialDigit(4, 5, 3);
            board.setInitialDigit(4, 7, 9);

            board.setInitialDigit(5, 0, 7);
            board.setInitialDigit(5, 1, 1);
            board.setInitialDigit(5, 2, 3);
            board.setInitialDigit(5, 3, 9);
            board.setInitialDigit(5, 4, 2);
            board.setInitialDigit(5, 5, 4);
            board.setInitialDigit(5, 7, 5);

            board.setInitialDigit(6, 1, 6);
            board.setInitialDigit(6, 3, 5);
            board.setInitialDigit(6, 4, 3);
            board.setInitialDigit(6, 5, 7);
            board.setInitialDigit(6, 6, 2);
            board.setInitialDigit(6, 7, 8);

            board.setInitialDigit(7, 0, 2);
            board.setInitialDigit(7, 1, 8);
            board.setInitialDigit(7, 2, 7);
            board.setInitialDigit(7, 3, 4);
            board.setInitialDigit(7, 4, 1);
            board.setInitialDigit(7, 5, 9);
            board.setInitialDigit(7, 8, 5);

            board.setInitialDigit(8, 0, 3);
            board.setInitialDigit(8, 2, 5);
            board.setInitialDigit(8, 3, 2);
            board.setInitialDigit(8, 4, 8);
            board.setInitialDigit(8, 6, 1);
            board.setInitialDigit(8, 7, 7);
            board.setInitialDigit(8, 8, 9);
            View view = new View();
            Game controller = new Game(board, view);
            controller.start();
        }
    }