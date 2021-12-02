package solutions.day02;

public class Day02UpInstruction extends Day02Instruction {
    private final int amount;

    public Day02UpInstruction(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute(Day02Position position) {
        position.decreaseDepth(amount);
    }
}
