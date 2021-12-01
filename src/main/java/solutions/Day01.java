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
     * Loads the values of the puzzle into an ArrayList.
     *
     * @return ArrayList with the values of the puzzle.
     */
    protected ArrayList<Integer> loadValues() {
        try {
            ArrayList<Integer> values = new ArrayList<>();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                values.add(scanner.nextInt());
            }

            return values;
        } catch (FileNotFoundException ignored) {
            return null;
        }
    }

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

    @Override
    public Pair<String, String> solve() {
        return new Pair<>(firstPart(loadValues()), null);
    }
}
