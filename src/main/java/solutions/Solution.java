package solutions;

import environment.Environment;
import utils.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Solution {
    protected File file;

    public Solution(String day, Environment env) {
        String inputsFolder = env.getInputsFolder();
        if (inputsFolder.endsWith("/")) {
            inputsFolder = inputsFolder.substring(0, inputsFolder.length() - 1);
        }
        String filePath = inputsFolder + "/" + day + ".txt";
        file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("AssertionError: The file at " + filePath + " doesn't exists.");
        }
    }

    /**
     * Loads each line of the puzzle input into an ArrayList. Ignores white lines.
     *
     * @return ArrayList with the lines of the puzzle.
     */
    protected ArrayList<String> loadStringValues() {
        try {
            ArrayList<String> values = new ArrayList<>();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                String nextLine = scanner.nextLine();
                if (nextLine.length() == 0) continue;
                values.add(nextLine);
            }

            return values;
        } catch (FileNotFoundException ignored) {
            return null;
        }
    }

    /**
     * Loads the values of the puzzle as Integers into an ArrayList.
     *
     * @return ArrayList with the values of the puzzle.
     */
    protected ArrayList<Integer> loadIntValues() {
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

    /**
     * Solves the puzzle.
     *
     * @return A pair with the solution to the first and second problem
     */
    public abstract Pair<String, String> solve();
}
