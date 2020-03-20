package homeworks.homework1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheTrafficLightsTest {

    private static TheTrafficLights theTrafficLights;

    @BeforeClass
    public static void setup() {
        theTrafficLights = new TheTrafficLights();
    }

    @Test
    public void checkTheLight() {
        int number1 = 120;
        int number2 = 295;
        int number3 = 378;

        String expected1 = "Signal is GREEN";
        String expected2 = "Signal is YELLOW";
        String expected3 = "Signal is RED";

        Assert.assertEquals(expected1, theTrafficLights.checkTheLight(number1));
        Assert.assertEquals(expected2, theTrafficLights.checkTheLight(number2));
        Assert.assertEquals(expected3, theTrafficLights.checkTheLight(number3));
    }
}