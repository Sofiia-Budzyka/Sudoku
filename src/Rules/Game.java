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
                    System.out.print("Ви вирішили Судоку!");
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
                int rowIndex = rowInput - 1;
                int colIndex = colInput - 1;
                int value = scanner.nextInt();
                int r = rowInput - 1;
                int c = colInput - 1;
                if (r < 0 || r >= 9 || c < 0 || c >= 9 || value < 1 || value > 9) {
                    System.out.print("Помилка: Координати 1-9, Значення 1-9.");
                    continue;
                }

                Cell cell = board.getCell(r, c);
                if (cell.isCanMove()) {
                    System.out.print("Помилка: Цю клітинку змінювати не можна.");
                } else {
                    if (validator.isValidMove(board, r, c, value)) {
                        cell.setValue(value);
                    } else {
                        System.out.print("Помилка: Невірний хід за правилами гри!");
                    }
                }
            }
            System.out.print("Гру завершено.");
        }
    }
