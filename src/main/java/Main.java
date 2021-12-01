import environment.DefaultEnvironment;
import environment.Environment;

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

    }

    public static void execute(String[] args) {
        execute(args, new DefaultEnvironment());
    }

    public static void main(String[] args) {
        execute(args);
    }
}
