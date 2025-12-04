package Rules;

public class Difficulty {
    public static final Difficulty EASY = new Difficulty(27);
    public static final Difficulty MEDIUM = new Difficulty(40);
    public static final Difficulty HARD = new Difficulty(54);

    private final int holes;
    private Difficulty(int holes) {
        this.holes = holes;
    }
    public int getHoles() {
        return holes;
    }
}