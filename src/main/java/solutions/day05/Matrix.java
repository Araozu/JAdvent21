package solutions.day05;

import utils.Point;

import java.util.HashMap;

public class Matrix {

    private final HashMap<Point, Integer> map = new HashMap<>();

    /**
     * Adds 1 to the position in the matrix
     *
     * @param position The position in which to add 1
     */
    public void add(Point position) {
        if (position.first < 0 || position.second < 0) {
            throw new RuntimeException("Matrix: attempted to add into negative position");
        }

        if (!map.containsKey(position)) {
            map.put(position, 1);
        } else {
            int value = map.get(position);
            map.put(position, value + 1);
        }
    }

    /**
     * Returns the value stored in position
     *
     * @param position The position
     * @return The value stored
     */
    protected int get(Point position) {
        if (position.first < 0 || position.second < 0) {
            throw new RuntimeException("Matrix: attempted to get from negative position");
        }

        return map.getOrDefault(position, 0);
    }

    /**
     * Return the number of positions whose value is >= 2
     *
     * @return Number of positions
     */
    public int getIntersections() {
        int amount = 0;
        for (var v : map.entrySet()) {
            if (v.getValue() > 1) {
                amount++;
            }
        }
        return amount;
    }

}
