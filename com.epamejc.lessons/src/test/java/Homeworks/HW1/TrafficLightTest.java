package java.Homeworks.HW1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TrafficLightTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    Homeworks.HW1.TrafficLight tl;

    @Before
    public void setupOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        tl = new Homeworks.HW1.TrafficLight();
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
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
    public void systemOut() {
        String input = "1";
        provideInput(input);
        tl.start();
        assertEquals("Light is GREEN", getOutput());
    }

    @Test
    public void green() {
        assertEquals("Light is GREEN", tl.getLight(0));
        assertEquals("Light is GREEN", tl.getLight(1));
        assertEquals("Light is GREEN", tl.getLight(2));
        assertEquals("Light is GREEN", tl.getLight(3));
        assertEquals("Light is GREEN", tl.getLight(10));
        assertEquals("Light is GREEN", tl.getLight(11));
        assertEquals("Light is GREEN", tl.getLight(12));
        assertEquals("Light is GREEN", tl.getLight(13));
    }

    @Test
    public void yellow() {
        assertEquals("Light is YELLOW", tl.getLight(4));
        assertEquals("Light is YELLOW", tl.getLight(5));
        assertEquals("Light is YELLOW", tl.getLight(14));
        assertEquals("Light is YELLOW", tl.getLight(15));
    }

    @Test
    public void red() {
        assertEquals("Light is RED", tl.getLight(6));
        assertEquals("Light is RED", tl.getLight(7));
        assertEquals("Light is RED", tl.getLight(8));
        assertEquals("Light is RED", tl.getLight(9));
        assertEquals("Light is RED", tl.getLight(16));
        assertEquals("Light is RED", tl.getLight(17));
        assertEquals("Light is RED", tl.getLight(18));
        assertEquals("Light is RED", tl.getLight(19));
    }
}