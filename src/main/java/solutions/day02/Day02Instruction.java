package solutions.day02;

public abstract class Day02Instruction {
    protected final boolean isFirstInstructionSet;
    protected final int amount;

    public Day02Instruction(int amount) {
        this(amount, true);
    }

    public Day02Instruction(int amount, boolean isFirstInstructionSet) {
        this.amount = amount;
        this.isFirstInstructionSet = isFirstInstructionSet;
    }

    public abstract void execute(Day02Position position);
}
