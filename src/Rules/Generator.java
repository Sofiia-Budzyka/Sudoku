package Rules;

import Grid.Board;
import Grid.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Generator {
        private Random random = new Random();

        public void generateNewGame(Board board) {
            clearBoard(board);
            fillBoard(board);
            removeDigits(board, 27);
        }

        private void clearBoard(Board board) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    board.getCell(r, c).setValue(0);
                }
            }
        }

        private boolean fillBoard(Board board) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board.getCell(row, col).getValue() == 0) {
                        List<Integer> numbers = getShuffledNumbers();
                        for (int number : numbers) {
                            if (isSafeForGenerator(board, row, col, number)) {
                                board.setInitialDigit(row, col, number);
                                if (fillBoard(board)) {
                                    return true;
                                } else {
                                    board.getCell(row, col).setValue(0);
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private void removeDigits(Board board, int countToRemove) {
            int removed = 0;
            while (removed < countToRemove) {
                int row = random.nextInt(9);
                int col = random.nextInt(9);
                Cell cell = board.getCell(row, col);
                if (cell.getValue() != 0) {
                    cell.setValue(0);
                    removed++;
                }
            }
        }

        private boolean isSafeForGenerator(Board board, int row, int col, int number) {
            for (int i = 0; i < 9; i++) {
                if (board.getCell(row, i).getValue() == number) return false;
                if (board.getCell(i, col).getValue() == number) return false;
            }
            int startRow = row - row % 3;
            int startCol = col - col % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getCell(startRow + i, startCol + j).getValue() == number) {
                        return false;
                    }
                }
            }
            return true;
        }

        private List<Integer> getShuffledNumbers() {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= 9; i++) numbers.add(i);
            Collections.shuffle(numbers);
            return numbers;
        }
    }

