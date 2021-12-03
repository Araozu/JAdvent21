package solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Pair;

import java.util.ArrayList;

public class Day03Test {

    private final Day03 day03 = new Day03(new TestEnvironment());

    @Test
    @DisplayName("getCommonUncommonBit shouldn't return null")
    public void testGetCommonUncommonBitNotNull() {
        Pair<Character, Character> result = day03.getCommonUncommonBit(day03.loadStringValues(), 0);
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("getCommonUncommonBit should throw if the index is less than zero")
    public void testGetCommonUncommonBitThrows() {
        try {
            Pair<Character, Character> result = day03.getCommonUncommonBit(day03.loadStringValues(), -1);
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("Day03 getCommonUncommonBit: index is less than zero.", e.getMessage());
        }
    }

    @Test
    @DisplayName("getCommonUncommonBit should throw if the index is greater or equal that the first string length")
    public void testGetCommonUncommonBitThrowsOnLength() {
        try {
            Pair<Character, Character> result = day03.getCommonUncommonBit(day03.loadStringValues(), 5);
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals(
                    "Day03 getCommonUncommonBit: index is greater or equal than the first string length.",
                    e.getMessage()
            );
        }
    }

    @Test
    @DisplayName("getCommonUncommonBit should return the correct value.")
    public void testGetCommonUncommonBitReturns() {
        ArrayList<String> values = day03.loadStringValues();
        Pair<Character, Character> result;
        result = day03.getCommonUncommonBit(values, 0);
        Assertions.assertEquals('1', result.first);
        Assertions.assertEquals('0', result.second);

        result = day03.getCommonUncommonBit(values, 1);
        Assertions.assertEquals('0', result.first);
        Assertions.assertEquals('1', result.second);
    }

    @Test
    @DisplayName("getValues should return the correct values")
    public void testGetValues() {
        Pair<Integer, Integer> result = day03.getValues(day03.loadStringValues());
        Assertions.assertEquals(22, result.first);
        Assertions.assertEquals(9, result.second);
    }

    @Test
    @DisplayName("firstPart should return the correct value")
    public void testFirstPart() {
        String result = day03.firstPart(day03.loadStringValues());
        Assertions.assertEquals("198", result);
    }
    
}
