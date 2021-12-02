import environment.DefaultEnvironment;
import environment.Environment;
import solutions.Day01;
import solutions.Day02;
import utils.Pair;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    /**
     * Executes the program.
     * The environment variable INPUTS_PATH must be set
     *
     * @param args Array with a parameter, the day to solve
     * @param env  Class to get INPUTS_PATH from
     */
    public static void execute(String[] args, Environment env) {
        if (args.length != 1) {
            throw new IllegalArgumentException("The program expects a parameter (day to solve).");
        }

        int dayNumber;
        try {
            dayNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The parameter (day to solve) must be an integer.");
        }

        if (dayNumber < 1 || dayNumber > 31) {
            throw new IllegalArgumentException("The parameter (day to solve) must be between 1 and 25 inclusive.");
        }

        String inputsFolderPath = env.getInputsFolder();
        if (inputsFolderPath.equals("")) {
            throw new IllegalArgumentException("The environment variable INPUTS_PATH is not set.");
        }
        if (!Files.isDirectory(Paths.get(inputsFolderPath))) {
            throw new IllegalArgumentException("The path `" + inputsFolderPath + "` is not a valid folder.");
        }

        Pair<String, String> result;
        switch (dayNumber) {
            case 1:
                result = new Day01(env).solve();
                break;
            case 2:
                result = new Day02(env).solve();
                break;
            default:
                throw new RuntimeException("TODO: The day " + dayNumber + " doesn't have a solution yet.");
        }
        String firstPart = result.first;
        String secondPart = result.second;

        System.out.println("Results of day " + dayNumber + ":");
        System.out.println("part 1: " + firstPart);
        System.out.println("part 2: " + secondPart);
    }

    public static void execute(String[] args) {
        execute(args, new DefaultEnvironment());
    }

    public static void main(String[] args) {
        execute(args);
    }
}
