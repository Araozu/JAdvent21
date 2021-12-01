package environment;

public class DefaultEnvironment implements Environment {
    @Override
    public String getInputsFolder() {
        return System.getenv("INPUTS_PATH");
    }
}
