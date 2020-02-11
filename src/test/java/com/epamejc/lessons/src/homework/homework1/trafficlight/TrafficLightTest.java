package com.epamejc.lessons.src.homework.homework1.trafficlight;


import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrafficLightTest {
    static private TrafficLight trafficLight;

    @BeforeClass
    static public void setUp() {
        trafficLight = new TrafficLight();
    }

    @Test
    public void setColorYellowColor() {
        for (int color = 4; color < 6; color++) {
            trafficLight.setColor(color);
            String expectedColor = "YELLOW";
            String actualColor = trafficLight.getColor();
            assertEquals(expectedColor, actualColor);
        }
    }

    @Test
    public void setColorRedColor() {
        for (int color = 6; color < 11; color++) {
            trafficLight.setColor(color);
            String expectedColor = "RED";
            String actualColor = trafficLight.getColor();
            assertEquals(expectedColor, actualColor);
        }
    }

    @Test
    public void setColorGREENColor() {
        for (int color = 0; color < 4; color++) {
            trafficLight.setColor(color);
            String expectedColor = "GREEN";
            String actualColor = trafficLight.getColor();
            assertEquals(expectedColor, actualColor);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setColorErrorValueHigh() {
        int highValue = 11;
        trafficLight.setColor(highValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setColorErrorValueLow() {
        int lowValue = -1;
        trafficLight.setColor(lowValue);
    }
}
