package solutions.day02;

public class Day02DownInstruction extends Day02Instruction {

    private final int amount;

    public Day02DownInstruction(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute(Day02Position position) {
        position.increaseDepth(amount);
    }
}
