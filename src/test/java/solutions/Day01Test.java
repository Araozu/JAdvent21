package solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Day01Test {

    private final Day01 day01 = new Day01(new TestEnvironment());

    @Test
    @DisplayName("loadValues should load the values into an arraylist")
    public void testLoadValues() {
        ArrayList<Integer> values = day01.loadValues();
        Assertions.assertNotNull(values);
        Assertions.assertEquals(10, values.size());
        Assertions.assertEquals(199, values.get(0));
        Assertions.assertEquals(200, values.get(1));
        Assertions.assertEquals(208, values.get(2));
        Assertions.assertEquals(210, values.get(3));
        Assertions.assertEquals(200, values.get(4));
        Assertions.assertEquals(207, values.get(5));
        Assertions.assertEquals(240, values.get(6));
        Assertions.assertEquals(269, values.get(7));
        Assertions.assertEquals(260, values.get(8));
        Assertions.assertEquals(263, values.get(9));
    }

    @Test
    @DisplayName("firstPart should give the correct answer")
    public void testFirstPart() {
        String result = day01.firstPart(day01.loadValues());
        Assertions.assertNotNull(result);
        Assertions.assertEquals("7", result);
    }
}
