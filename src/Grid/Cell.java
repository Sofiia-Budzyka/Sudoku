package Grid;

public class Cell {
    private int value;
    private boolean canMove;
    public Cell(int value, boolean canMove) {
        this.value = value;
        this.canMove = canMove;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        if (!canMove) {
            this.value = value;
        }
    }
    public boolean isCanMove() {
        return canMove;
    }
}
