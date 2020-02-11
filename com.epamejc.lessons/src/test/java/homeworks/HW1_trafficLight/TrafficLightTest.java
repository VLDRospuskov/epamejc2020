package homeworks.HW1_trafficLight;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrafficLightTest {

    public static homeworks.HW1_trafficLight.TrafficLight trafficLight;

    @BeforeClass
    public static void initClass() {
        trafficLight = new homeworks.HW1_trafficLight.TrafficLight();
    }

    /**
     * Testing traffic light output
     */
    @Test
    public void testDefineTrafficLightSignal() {
        int inputSeconds1 = 160;
        int inputSeconds2 = 580;
        String expectedTrafficColor1 = TrafficLightColors.GREEN.getMessage();
        String expectedTrafficColor2 = TrafficLightColors.RED.getMessage();
        String actualTrafficColor1 = trafficLight.defineTrafficLightSignal(inputSeconds1);
        String actualTrafficColor2 = trafficLight.defineTrafficLightSignal(inputSeconds2);
        Assert.assertEquals(expectedTrafficColor1, actualTrafficColor1);
        Assert.assertEquals(expectedTrafficColor2, actualTrafficColor2);
    }
}