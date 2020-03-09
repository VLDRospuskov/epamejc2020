package homework1Test;

import homeworks.homework1.TrafficLight;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TrafficLightTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    private TrafficLight trafficLight;

    @Before
    public void setupOutput() {
        trafficLight = new TrafficLight();
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString().trim();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void runTestExit() {
        String input = "ExIt";
        provideInput(input);
        trafficLight.run();

        String actual = getOutput();
        String output = "Enter time or 'exit': " + "Ending program!";
        String expected = output.trim();

        assertEquals(expected, actual);
    }

}
