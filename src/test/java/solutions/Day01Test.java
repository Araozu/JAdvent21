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

    @Test
    @DisplayName("getMeasurement should return the correct value")
    public void testGetMeasurement() {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(199);
        values.add(200);
        values.add(208);
        int result = day01.getMeasurement(values, 2);
        Assertions.assertEquals(607, result);
    }

    @Test
    @DisplayName("getMeasurement should throw if the end index is less than 2")
    public void testGetMeasurementIncorrectIndex() {
        try {
            ArrayList<Integer> values = new ArrayList<>();
            day01.getMeasurement(values, 1);
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("Day01, getMeasurement: Index is less than 2.", e.getMessage());
        }
    }

    @Test
    @DisplayName("secondPart should return the correct answer")
    public void testSecondPart(){
        String result = day01.secondPart(day01.loadValues());
        Assertions.assertNotNull(result);
        Assertions.assertEquals("5", result);
    }

}
