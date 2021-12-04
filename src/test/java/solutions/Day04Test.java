package solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import solutions.day04.Board;
import utils.Pair;

import java.util.ArrayList;

public class Day04Test {
    private final Day04 day04 = new Day04(new TestEnvironment());

    @Test
    @DisplayName("getValues should return the correct values")
    public void testGetValues() {
        Pair<ArrayList<Integer>, ArrayList<Board>> values = day04.getBingoNumbers();

        Assertions.assertNotNull(values);

        ArrayList<Integer> numbers = values.first;
        Assertions.assertEquals(27, numbers.size());
        Assertions.assertEquals(7, numbers.get(0));
        Assertions.assertEquals(4, numbers.get(1));
        Assertions.assertEquals(9, numbers.get(2));
        Assertions.assertEquals(26, numbers.get(25));
        Assertions.assertEquals(1, numbers.get(26));
    }

    @Test
    @DisplayName("findWinnerBoard should work")
    public void test() {
        Pair<ArrayList<Integer>, ArrayList<Board>> values = day04.getBingoNumbers();
        day04.firstPart(values);
    }

    @Test
    @DisplayName("firstPart should return the correct value")
    public void testFirstPart() {
        Pair<ArrayList<Integer>, ArrayList<Board>> values = day04.getBingoNumbers();
        String result = day04.firstPart(values);
        Assertions.assertEquals("4512", result);
    }
}
