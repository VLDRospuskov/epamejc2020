package seabattle.java;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static seabattle.java.Utils.*;

public class UtilsTest {

    @Test
    public void checkBadCoordinatesTest() {
        Integer[] coordYX = {11, 2};
        boolean expected = true;
        boolean actual = checkBadCoordinates(coordYX);
        assertEquals(expected, actual);
    }

    @Test
    public void checkShipTypeTest() {
        int shipType = 0;
        boolean expected = true;
        boolean actual = checkBadShipType(shipType);
        assertEquals(expected, actual);
        shipType = 7;
        actual = checkBadShipType(shipType);
        assertEquals(expected, actual);
    }

    @Test
    public void sortCoordinatesAscendingTest() {

    }


}
