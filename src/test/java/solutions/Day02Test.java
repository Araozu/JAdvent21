package solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import solutions.day02.Day02Instruction;
import solutions.day02.Day02Position;

public class Day02Test {

    private final Day02 day02 = new Day02(new TestEnvironment());

    @Test
    @DisplayName("parseInstruction should parse correctly an instruction")
    public void testParseInstruction() {
        Day02Instruction instruction = day02.parseInstruction("forward 5");
        Assertions.assertNotNull(instruction);
        Day02Position position = new Day02Position();

        instruction.execute(position);
        Assertions.assertEquals(5, position.getHorizontalPosition());
    }

    @Test
    @DisplayName("firstPart should return the correct value")
    public void testFirstPart() {
        int result = day02.firstPart(day02.loadStringValues());
        Assertions.assertEquals(150, result);
    }

    @Test
    @DisplayName("secondPart should return the correct value")
    public void testSecondPart(){
        int result = day02.secondPart(day02.loadStringValues());
        Assertions.assertEquals(900, result);
    }

}
