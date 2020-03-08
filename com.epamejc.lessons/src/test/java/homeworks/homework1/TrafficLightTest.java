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
    public void getGreenColor() {
        String actual1 = trafficLight.getColor(0);
        String actual2 = trafficLight.getColor(1);
        String actual3 = trafficLight.getColor(2);
        String actual4 = trafficLight.getColor(10);
        String expectedGreen = "Green color";
        assertEquals(expectedGreen, actual1);
        assertEquals(expectedGreen, actual2);
        assertEquals(expectedGreen, actual3);
        assertEquals(expectedGreen, actual4);
    }

    @Test
    public void getYellowColor() {
        String actual1 = trafficLight.getColor(3);
        String actual2 = trafficLight.getColor(4);
        String actual3 = trafficLight.getColor(5);
        String expectedYellow = "Yellow color";
        assertEquals(expectedYellow, actual1);
        assertEquals(expectedYellow, actual2);
        assertEquals(expectedYellow, actual3);
    }

    @Test
    public void getRedColor() {
        String actual1 = trafficLight.getColor(6);
        String actual2 = trafficLight.getColor(7);
        String actual3 = trafficLight.getColor(8);
        String actual4 = trafficLight.getColor(9);
        String expectedRed = "Red color";
        assertEquals(expectedRed, actual1);
        assertEquals(expectedRed, actual2);
        assertEquals(expectedRed, actual3);
        assertEquals(expectedRed, actual4);
    }

}