package homework.seabattle.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    @Test(expected = IllegalArgumentException.class)
    public void of() {
        assertEquals(new Coordinate('f', 5), Coordinate.of("f5"));
        Coordinate.of("f11");
        Coordinate.of("k1");
    }
}