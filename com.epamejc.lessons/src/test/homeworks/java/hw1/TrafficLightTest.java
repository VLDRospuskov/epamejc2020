package homeworks.java.hw1;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TrafficLightTest {

    private static TrafficLight tl;

    @Before
    public void setup() {
        tl = new TrafficLight();
    }

    @Test
    public void checkMinutesTest() {
        int expected1 = 3;
        int actual1 = tl.checkMinutes(123);
        int expected2 = 3;
        int actual2 = tl.checkMinutes(3);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void getColorTest() {
        String expected1 = "Green";
        String actual1 = tl.getColor(2);
        String expected2 = "Yellow";
        String actual2 = tl.getColor(5);
        String expected3 = "Red";
        String actual3 = tl.getColor(9);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
}
