package solutions.day02;

public class Day02ForwardInstruction extends Day02Instruction {
    private final int amount;

    public Day02ForwardInstruction(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute(Day02Position position) {
        position.increaseHorizontalPosition(amount);
    }
}
