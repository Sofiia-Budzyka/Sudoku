package Rules;

import Grid.Board;
import Grid.Cell;
import Grid.View;

import java.util.Scanner;

public class Game {
    private Board board;
    private View view;
    private Validator validator;
    private Scanner scanner;
    public Game(Board board, View view) {
        this.board = board;
        this.view = view;
        this.validator = new Validator();
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            view.drawBoard(board);
            if (validator.isGameFinished(board)) {
                System.out.println("\nВітаємо! Ви вирішили Судоку!");
                break;
            }
            System.out.print("Введіть номер рядка (1-9) або '-1' для виходу: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Це не число! Введіть номер рядка ще раз: ");
                scanner.next();
            }
            int rowInput = scanner.nextInt();
            if (rowInput == -1) {
                isRunning = false;
                continue;
            }
            System.out.print("Введіть номер стовпця (1-9) або '-1' для виходу: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Це не число! Введіть номер стовпця ще раз: ");
                scanner.next();
            }
            int colInput = scanner.nextInt();
            if (colInput == -1) {
                isRunning = false;
                continue;
            }
            System.out.print("Введіть значення (1-9) або '-1' для виходу: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Це не число! Введіть значення ще раз: ");
                scanner.next();
            }
            int valueInput = scanner.nextInt();
            if (valueInput == -1) {
                isRunning = false;
                continue;
            }
            int r = rowInput - 1;
            int c = colInput - 1;
            if (r < 0 || r >= 9 || c < 0 || c >= 9 || valueInput < 1 || valueInput > 9) {
                System.out.println("Помилка: Координати мають бути 1-9, Значення 1-9.");
                continue;
            }

            Cell cell = board.getCell(r, c);
            if (cell.getValue() != 0 && isInitialPosition(r, c)) {
                System.out.println("Помилка: Цю клітинку змінювати не можна.");
            } else {
                if (validator.isValidMove(board, r, c, valueInput)) {
                    cell.setValue(valueInput);
                } else {
                    System.out.println("Помилка: Невірний хід! Така цифра вже є в рядку, стовпці або блоці.");
                }
            }
        }
        System.out.println("Гру завершено.");
    }
    private boolean isInitialPosition(int row, int col) {
        return false;
    }
}