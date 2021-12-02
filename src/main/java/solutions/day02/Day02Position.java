package solutions.day02;

public class Day02Position {
    private int horizontalPosition = 0;
    private int depth = 0;
    private int aim = 0;

    public int getAim() {
        return aim;
    }

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

    protected void increaseAim(int i) {
        aim += i;
    }

    protected void decreaseAim(int i) {
        aim -= i;
    }
}
