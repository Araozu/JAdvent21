package utils;

public class Point extends Pair<Integer, Integer> {
    public final int x;
    public final int y;

    public Point(Integer first, Integer second) {
        super(first, second);
        x = first;
        y = second;
    }
}
