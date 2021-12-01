package solutions;

import environment.Environment;
import utils.Pair;

import java.io.File;

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
     * Solves the puzzle.
     *
     * @return A pair with the solution to the first and second problem
     */
    public abstract Pair<String, String> solve();
}
