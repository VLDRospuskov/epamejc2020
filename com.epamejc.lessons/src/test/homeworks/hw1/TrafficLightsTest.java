package homeworks.hw1;

import org.junit.*;

import static org.junit.Assert.*;

public class TrafficLightsTest {

    private static TrafficLights trafficLights;

    @Before
    public void setup() {
        trafficLights = new TrafficLights();
        System.out.println("SETUP BEFORE");
    }

    @Test
    public void testGetColor() {
        String expected1 = "green";
        String actual1 = trafficLights.getColor(2.0);
        String expected2 = "yellow";
        String actual2 = trafficLights.getColor(4.3);
        String expected3 = "red";
        String actual3 = trafficLights.getColor(9.0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    public void testGetTime() {
        Double expected1 = 3.0;
        Double actual = trafficLights.getTime("3.0");
        assertEquals(expected1, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetTimeWithWrongInput() {
        trafficLights.getTime("i am very sleepy");
    }
}
