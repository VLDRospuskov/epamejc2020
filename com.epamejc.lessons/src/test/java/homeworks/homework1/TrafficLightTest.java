package homeworks.homework1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrafficLightTest {

    private static TrafficLight trafficLight;

    @BeforeClass
    public static void setUp() {
        trafficLight = new TrafficLight();
    }

    @Test
    public void getColor() {
        String actual1 = trafficLight.getColor(0);
        String actual2 = trafficLight.getColor(10);
        String actual3 = trafficLight.getColor(11);
        String actual4 = trafficLight.getColor(5);
        String actual5 = trafficLight.getColor(-1);
        String expected1 = "Green color";
        String expected2 = "Green color";
        String expected3 = "Green color";
        String expected4 = "Yellow color";
        String expected5 = "Green color";
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
    }

    @Test
    public void getProcessedMinutes() {
        int actual = trafficLight.getProcessedMinutes(0);
        int actualSecond = trafficLight.getProcessedMinutes(10);
        int actualThird = trafficLight.getProcessedMinutes(-1);

        int expected = 0;
        int expectedSecond = 0;
        int expectedThird = 1;
        assertEquals(expected, actual);
        assertEquals(expectedSecond, actualSecond);
        assertEquals(expectedThird, actualThird);
    }

}