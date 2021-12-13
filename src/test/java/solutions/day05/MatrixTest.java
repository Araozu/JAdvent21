package solutions.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Point;

public class MatrixTest {

    @Test
    @DisplayName("should construct correctly")
    public void testConstruct() {
        new Matrix();
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("should throw when adding in a negative position")
    public void testNegative() {
        var matrix = new Matrix();
        Assertions.assertThrows(RuntimeException.class, () -> matrix.add(new Point(-1, 1)));
    }

    @Test
    @DisplayName("should add in a correct position")
    public void testAdd() {
        var matrix = new Matrix();
        matrix.add(new Point(10, 420));
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("should throw when getting from a negative position")
    public void testGetNegative() {
        var matrix = new Matrix();
        Assertions.assertThrows(RuntimeException.class, () -> matrix.get(new Point(-1345, 1)));
    }

    @Test
    @DisplayName("should return 0 when getting from an empty position")
    public void testEmpty() {
        var matrix = new Matrix();
        Assertions.assertEquals(0, matrix.get(new Point(322, 322)));
    }

    @Test
    @DisplayName("should return 1 when getting from a previously added position")
    public void testReturn() {
        var matrix = new Matrix();
        matrix.add(new Point(322, 322));
        Assertions.assertEquals(1, matrix.get(new Point(322, 322)));
    }

}
