import environment.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {
    private static class MockEnvironment implements Environment {
        private final String value;

        public MockEnvironment(String value) {
            this.value = value;
        }

        @Override
        public String getInputsFolder() {
            return value;
        }
    }

    private static final String inputsPath = "/home/fernando/Advent/21/";

    @Test
    @DisplayName("main should throw when the environment variable INPUTS_PATH is not set")
    public void testInputsPath() {
        try {
            String[] args = {"01"};
            Main.execute(args, new MockEnvironment(""));
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertEquals("The environment variable INPUTS_PATH is not set.", e.getMessage());
        }
    }

    @Test
    @DisplayName("main should throw if INPUTS_PATH is not a path to a folder")
    public void testInputPathIsFolder() {
        try {
            String[] args = {"01"};
            Main.execute(args, new MockEnvironment("param"));
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The path `param` is not a valid folder.", e.getMessage());
        }
    }

    @Test
    @DisplayName("main should throw if args doesn't have exactly one parameter")
    public void testMainArgs() {
        try {
            String[] args = {};
            Main.execute(args, new MockEnvironment(inputsPath));
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The program expects a parameter (day to solve).", e.getMessage());
        }
    }

    @Test
    @DisplayName("main should throw if the parameter isn't an integer")
    public void testMainArgType() {
        try {
            String[] args = {"x"};
            Main.execute(args, new MockEnvironment(inputsPath));
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The parameter (day to solve) must be an integer.", e.getMessage());
        }
    }

    @Test
    @DisplayName("main should throw if the parameter is less than 1 or more than 25")
    public void testMainArgValue() {
        try {
            String[] args = {"0"};
            Main.execute(args, new MockEnvironment(inputsPath));
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(
                    "The parameter (day to solve) must be between 1 and 25 inclusive.",
                    e.getMessage()
            );
        }
    }
}
