package solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Pair;

import java.util.ArrayList;

public class SolutionTest {

    private final Solution solution = new Solution("01", new TestEnvironment()) {
        @Override
        public Pair<String, String> solve() {
            return null;
        }
    };

    @Test
    @DisplayName("loadStringValues should load correctly")
    public void testLoadStringValues() {
        ArrayList<String> values = solution.loadStringValues();
        Assertions.assertEquals(10, values.size());
        Assertions.assertEquals("199", values.get(0));
        Assertions.assertEquals("200", values.get(1));
        Assertions.assertEquals("208", values.get(2));
        Assertions.assertEquals("210", values.get(3));
        Assertions.assertEquals("200", values.get(4));
        Assertions.assertEquals("207", values.get(5));
        Assertions.assertEquals("240", values.get(6));
        Assertions.assertEquals("269", values.get(7));
        Assertions.assertEquals("260", values.get(8));
        Assertions.assertEquals("263", values.get(9));
    }

    @Test
    @DisplayName("loadValues should load the values into an arraylist")
    public void testLoadIntValues() {
        ArrayList<Integer> values = solution.loadIntValues();
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
}
