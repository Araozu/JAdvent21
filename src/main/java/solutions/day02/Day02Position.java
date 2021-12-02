package solutions.day02;

public class Day02Position {
    private int horizontalPosition = 0;
    private int depth = 0;

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    protected void increaseHorizontalPosition(int i) {
        horizontalPosition += i;
    }

    protected void increaseDepth(int i) {
        depth += i;
    }

    protected void decreaseDepth(int i) {
        depth -= i;
    }
}
