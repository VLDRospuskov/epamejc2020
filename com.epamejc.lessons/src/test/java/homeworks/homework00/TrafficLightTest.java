package homeworks.homework00;

import org.junit.Assert;
import org.junit.Test;

public class TrafficLightTest {

    private TrafficLight trafficLight = new TrafficLight();

    @Test
    public void launchGreen() {
        String expected = "Green";

        for (int i = 1; i <= 4; i++) {
            String actual = trafficLight.getTrafficLightColorFromMinute(i);

            Assert.assertEquals(expected, actual);
        }

    }

    @Test
    public void launchYellow() {
        String expected = "Yellow";

        for (int i = 5; i <= 7; i++) {
            String actual = trafficLight.getTrafficLightColorFromMinute(i);

            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void launchRed() {
        String expected = "Red";

        for (int i = 8; i <= 10; i++) {
            String actual = trafficLight.getTrafficLightColorFromMinute(i);

            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void launchOutOfBorders() {
        String expected = "It is broken!";
        String actual = trafficLight.getTrafficLightColorFromMinute(-1);

        Assert.assertEquals(expected, actual);

        actual = trafficLight.getTrafficLightColorFromMinute(11);

        Assert.assertEquals(expected, actual);
    }
}
