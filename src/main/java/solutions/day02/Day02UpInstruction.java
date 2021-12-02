package solutions.day02;

public class Day02UpInstruction extends Day02Instruction {
    public Day02UpInstruction(int amount) {
        super(amount);
    }

    public Day02UpInstruction(int amount, boolean isFirstInstructionSet) {
        super(amount, isFirstInstructionSet);
    }

    @Override
    public void execute(Day02Position position) {
        if (isFirstInstructionSet) {
            position.decreaseDepth(amount);
        } else {
            position.decreaseAim(amount);
        }
    }
}
