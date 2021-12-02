package solutions;

import environment.Environment;
import utils.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01 extends Solution {

    public Day01(Environment env) {
        super("01", env);
    }

    /**
     * Solves the first part
     *
     * @param values ArrayList with the values of the puzzle
     * @return The result as a String
     */
    protected String firstPart(ArrayList<Integer> values) {
        int counter = 0;
        int lastValue = values.get(0);
        for (int newValue : values) {
            if (newValue > lastValue) {
                counter++;
            }
            lastValue = newValue;
        }
        return counter + "";
    }

    /**
     * Gets the sum of three values of an ArrayList: n-2 + n-1 + n
     *
     * @param values   ArrayList with values of the quiz
     * @param endIndex The ending index. Must be greater or equal than 2
     * @return The sum of the last three values
     */
    protected int getMeasurement(ArrayList<Integer> values, int endIndex) {
        if (endIndex < 2) {
            throw new RuntimeException("Day01, getMeasurement: Index is less than 2.");
        }
        return values.get(endIndex - 2) + values.get(endIndex - 1) + values.get(endIndex);
    }

    /**
     * Solves the second part
     *
     * @param values ArrayList with values of the puzzle
     * @return The result as a String
     */
    protected String secondPart(ArrayList<Integer> values) {
        int counter = 0;
        var previousValue = getMeasurement(values, 2);
        for (int i = 2; i < values.size(); i++) {
            int newValue = getMeasurement(values, i);
            if (newValue > previousValue) {
                counter++;
            }
            previousValue = newValue;
        }
        return counter + "";
    }

    @Override
    public Pair<String, String> solve() {
        ArrayList<Integer> values = loadIntValues();
        return new Pair<>(firstPart(values), secondPart(values));
    }
}
