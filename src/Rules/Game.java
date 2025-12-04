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
    private Generator generator; // Додаємо посилання на генератор

    public Game(Board board, View view, Generator generator) {
        this.board = board;
        this.view = view;
        this.generator = generator;
        this.validator = new Validator();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Оберіть складність:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Ваш вибір(вводити потрібно лише число,яке стоїть біля рівня складності): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Будь ласка, введіть число (1, 2 або 3): ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        Difficulty difficulty;
        switch (choice) {
            case 2:
                difficulty = Difficulty.MEDIUM;
                break;
            case 3:
                difficulty = Difficulty.HARD;
                break;
            default:
                difficulty = Difficulty.EASY;
                break;
        }
        generator.generateNewGame(board, difficulty);
        long startTime = System.currentTimeMillis();
        boolean isRunning = true;
        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsedMillis = currentTime - startTime;
            String timeString = formatTime(elapsedMillis);
            System.out.println("\nЧас гри: " + timeString);
            view.drawBoard(board);
            if (validator.isGameFinished(board)) {
                System.out.println("\nВітаємо! Ви вирішили Судоку!");
                System.out.println("Ваш підсумковий час: " + timeString);
                break;
            }
            System.out.print("Введіть номер рядка (1-9) або '-1' для виходу: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Це не число! Введіть номер рядка ще раз: ");
                scanner.next();
            }
            int rowInput = scanner.nextInt();
            if (rowInput == -1) { isRunning = false; continue; }
            System.out.print("Введіть номер стовпця (1-9) або '-1' для виходу: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Це не число! Введіть номер стовпця ще раз: ");
                scanner.next();
            }
            int colInput = scanner.nextInt();
            if (colInput == -1) { isRunning = false; continue; }
            System.out.print("Введіть значення (1-9) або '-1' для виходу: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Це не число! Введіть значення ще раз: ");
                scanner.next();
            }
            int valueInput = scanner.nextInt();
            if (valueInput == -1) { isRunning = false; continue; }
            int r = rowInput - 1;
            int c = colInput - 1;
            if (r < 0 || r >= 9 || c < 0 || c >= 9 || valueInput < 1 || valueInput > 9) {
                System.out.println("Помилка: Координати мають бути 1-9, Значення 1-9.");
                continue;
            }
            Cell cell = board.getCell(r, c);
            if (cell.isFixed()) {
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
    private String formatTime(long millis) {
        long seconds = (millis / 1000) % 60;
        long minutes = (millis / (1000 * 60)) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}