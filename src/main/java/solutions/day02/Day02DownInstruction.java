package solutions.day02;

public class Day02DownInstruction extends Day02Instruction {
    public Day02DownInstruction(int amount) {
        super(amount);
    }

    public Day02DownInstruction(int amount, boolean isFirstInstructionSet) {
        super(amount, isFirstInstructionSet);
    }

    @Override
    public void execute(Day02Position position) {
        if (isFirstInstructionSet) {
            position.increaseDepth(amount);
        } else {
            position.increaseAim(amount);
        }
    }
}
