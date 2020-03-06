package homework1;

import org.junit.Test;

import static org.junit.Assert.*;

public class trafficLightTest {

    @Test
    public void selectColor() {
        trafficLight trafficLight = new trafficLight();
        assertEquals(trafficLight.selectColor("9"),"Red");
    }
}