package solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Day05Test {

    @Test
    @DisplayName("should solve")
    public void testFirstPart() {
        Assertions.assertEquals(new Day05(new TestEnvironment()).firstPart(), "5");
    }

}
