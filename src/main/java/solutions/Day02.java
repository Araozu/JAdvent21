package solutions;

import environment.Environment;
import solutions.day02.*;
import utils.Pair;

import java.util.ArrayList;

public class Day02 extends Solution {
    public Day02(Environment env) {
        super("02", env);
    }

    /**
     * Parses a line to a Day02Instruction object
     *
     * @param line The string to parse
     * @return The instruction
     */
    protected Day02Instruction parseInstruction(String line) {
        String instructionName = line.substring(0, line.indexOf(' '));
        int value = Integer.parseInt(line.substring(line.indexOf(' ') + 1));
        switch (instructionName) {
            case "forward":
                return new Day02ForwardInstruction(value);
            case "down":
                return new Day02DownInstruction(value);
            case "up":
                return new Day02UpInstruction(value);
            default:
                throw new RuntimeException("Day02 parseInstruction: found an incorrect instruction: " + instructionName);
        }
    }

    protected int firstPart() {
        Day02Position position = new Day02Position();
        ArrayList<String> lines = loadStringValues();
        for (String line : lines) {
            parseInstruction(line).execute(position);
        }
        return position.getHorizontalPosition() * position.getDepth();
    }

    @Override
    public Pair<String, String> solve() {
        return new Pair<>(firstPart() + "", null);
    }

}
