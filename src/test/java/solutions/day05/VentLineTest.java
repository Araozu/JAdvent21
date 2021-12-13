package solutions.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Point;

public class VentLineTest {

    @Test
    @DisplayName("should create vertical line")
    public void testVertical() {
        var ventLine = new VentLine("0,9 -> 0,13");
        Assertions.assertEquals(new Point(0, 9), ventLine.points.get(0));
        Assertions.assertEquals(new Point(0, 10), ventLine.points.get(1));
        Assertions.assertEquals(new Point(0, 11), ventLine.points.get(2));
        Assertions.assertEquals(new Point(0, 12), ventLine.points.get(3));
        Assertions.assertEquals(new Point(0, 13), ventLine.points.get(4));

        ventLine = new VentLine("0,13 -> 0,9");
        Assertions.assertEquals(new Point(0, 9), ventLine.points.get(0));
        Assertions.assertEquals(new Point(0, 10), ventLine.points.get(1));
        Assertions.assertEquals(new Point(0, 11), ventLine.points.get(2));
        Assertions.assertEquals(new Point(0, 12), ventLine.points.get(3));
        Assertions.assertEquals(new Point(0, 13), ventLine.points.get(4));
    }

    @Test
    @DisplayName("should create horizontal line")
    public void testHorizontal() {
        var ventLine = new VentLine("9,5 -> 13,5");
        Assertions.assertEquals(new Point(9, 5), ventLine.points.get(0));
        Assertions.assertEquals(new Point(10, 5), ventLine.points.get(1));
        Assertions.assertEquals(new Point(11, 5), ventLine.points.get(2));
        Assertions.assertEquals(new Point(12, 5), ventLine.points.get(3));
        Assertions.assertEquals(new Point(13, 5), ventLine.points.get(4));

        ventLine = new VentLine("13,5 -> 9,5");
        Assertions.assertEquals(new Point(9, 5), ventLine.points.get(0));
        Assertions.assertEquals(new Point(10, 5), ventLine.points.get(1));
        Assertions.assertEquals(new Point(11, 5), ventLine.points.get(2));
        Assertions.assertEquals(new Point(12, 5), ventLine.points.get(3));
        Assertions.assertEquals(new Point(13, 5), ventLine.points.get(4));
    }

}
