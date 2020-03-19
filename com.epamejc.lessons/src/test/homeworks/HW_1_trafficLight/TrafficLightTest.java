package homeworks.HW_1_trafficLight;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficLightTest {
    private final TrafficLight trafficLight = new TrafficLight();

    @Test
    public void testGetTrafficLightColor() {
        String expected = Messages.YELLOW.toString();
        String actual = trafficLight.getTrafficLightColor(5);
        assertEquals(expected, actual);

        expected = Messages.GREEN.toString();
        actual = trafficLight.getTrafficLightColor(-100);
        assertEquals(expected, actual);

        expected = Messages.RED.toString();
        actual = trafficLight.getTrafficLightColor(1118);
        assertEquals(expected, actual);
    }

}
