package homeworks.HW_1_trafficLight;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficLightTest {
    private final TrafficLight trafficLight = new TrafficLight();

    @Test
    public void testGetTrafficLightColor() {
        Colors expected = Colors.YELLOW;
        Colors actual = trafficLight.getTrafficLightColor(5);
        assertEquals(expected, actual);

        expected = Colors.GREEN;
        actual = trafficLight.getTrafficLightColor(-100);
        assertEquals(expected, actual);

        expected = Colors.RED;
        actual = trafficLight.getTrafficLightColor(1118);
        assertEquals(expected, actual);
    }

}
