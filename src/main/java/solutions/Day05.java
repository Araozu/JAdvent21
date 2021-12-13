package solutions;

import environment.Environment;
import solutions.day05.Matrix;
import solutions.day05.VentLine;
import utils.Pair;

public class Day05 extends Solution {
    public Day05( Environment env) {
        super("05", env);
    }

    protected String firstPart() {
        Matrix matrix = new Matrix();
        for (String line : loadStringValues()) {
            new VentLine(line).apply(matrix);
        }
        return "" + matrix.getIntersections();
    }

    protected String secondPart() {
        Matrix matrix = new Matrix();
        for (String line : loadStringValues()) {
            new VentLine(line, true).apply(matrix);
        }
        return "" + matrix.getIntersections();
    }

    @Override
    public Pair<String, String> solve() {
        return new Pair<>(firstPart(), secondPart());
    }
}
