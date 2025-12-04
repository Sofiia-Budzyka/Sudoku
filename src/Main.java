import Grid.Board;
import Grid.View;
import Rules.Game;
import Rules.Generator;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        View view = new View();
        Generator generator = new Generator();
        Game game = new Game(board, view, generator);
        game.start();
    }
}