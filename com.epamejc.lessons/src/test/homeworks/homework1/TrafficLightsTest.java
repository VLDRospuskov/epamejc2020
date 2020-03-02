package test.homeworks.homework1;

import main.homeworks.homework1.TrafficLights;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TrafficLightsTest {

    private static TrafficLights trafficLights = new TrafficLights();

    @Test
    public void testChangeLight() {
        String expected1 = "Green";
        String expected2 = "Yellow";
        String expected3 = "Red";

        String actual1 = trafficLights.changeLight(2);
        String actual2 = trafficLights.changeLight(5);
        String actual3 = trafficLights.changeLight(7);

        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2);
        assertEquals(expected3,actual3);

    }

}
