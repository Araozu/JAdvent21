package solutions.day02;

public class Day02ForwardInstruction extends Day02Instruction {
    public Day02ForwardInstruction(int amount) {
        super(amount);
    }

    public Day02ForwardInstruction(int amount, boolean isFirstInstructionSet) {
        super(amount, isFirstInstructionSet);
    }

    @Override
    public void execute(Day02Position position) {
        if (isFirstInstructionSet) {
            position.increaseHorizontalPosition(amount);
        } else {
            position.increaseHorizontalPosition(amount);
            position.increaseDepth(position.getAim() * amount);
        }
    }
}
