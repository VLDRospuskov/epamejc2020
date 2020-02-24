package homeworks.java.hw1;

import org.junit.*;

import java.io.*;

import static homeworks.java.hw1.enums.Messages.*;
import static org.junit.Assert.*;

public class TrafficLightTest {

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private final PrintStream ORIGINAL_OUTPUT = System.out;
    private TrafficLight trafficLight;

    @Before
    public void setUp(){
        trafficLight = new TrafficLight();
    }

    @After
    public void restoreStreams(){
    }

    @Test
    public void getColor_AllColorsPositiveTest() {
        final String expectedGreen = GREEN_LIGHT_MESSAGE.toString();
        final String expectedYellow = YELLOW_LIGHT_MESSAGE.toString();
        final String expectedRed = RED_LIGHT_MESSAGE.toString();

        String actualGreen = trafficLight.getColor("11");
        String actualYellow = trafficLight.getColor("14");
        String actualRed = trafficLight.getColor("16");

        Assert.assertEquals(expectedGreen, actualGreen);
        Assert.assertEquals(expectedYellow, actualYellow);
        Assert.assertEquals(expectedRed, actualRed);
    }

    @Test
    public void getLight_ExitTest() {
        System.setOut(new PrintStream(OUTPUT));
        BufferedReader buffer = new BufferedReader(new StringReader("exit"));
        trafficLight.getLight(buffer);
        Assert.assertEquals(ENTER_MESSAGE.toString().trim(), OUTPUT.toString().trim());
        System.setOut(ORIGINAL_OUTPUT);
    }

}
