package Homeworks.HW1;

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

    TrafficLight tl;

    @Before
    public void setupOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        tl = new TrafficLight();
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
        assertEquals("Light is GREEN", tl.printLight(0));
        assertEquals("Light is GREEN", tl.printLight(1));
        assertEquals("Light is GREEN", tl.printLight(2));
        assertEquals("Light is GREEN", tl.printLight(3));
        assertEquals("Light is GREEN", tl.printLight(10));
        assertEquals("Light is GREEN", tl.printLight(11));
        assertEquals("Light is GREEN", tl.printLight(12));
        assertEquals("Light is GREEN", tl.printLight(13));
    }

    @Test
    public void yellow() {
        assertEquals("Light is YELLOW", tl.printLight(4));
        assertEquals("Light is YELLOW", tl.printLight(5));
        assertEquals("Light is YELLOW", tl.printLight(14));
        assertEquals("Light is YELLOW", tl.printLight(15));
    }

    @Test
    public void red() {
        assertEquals("Light is RED", tl.printLight(6));
        assertEquals("Light is RED", tl.printLight(7));
        assertEquals("Light is RED", tl.printLight(8));
        assertEquals("Light is RED", tl.printLight(9));
        assertEquals("Light is RED", tl.printLight(16));
        assertEquals("Light is RED", tl.printLight(17));
        assertEquals("Light is RED", tl.printLight(18));
        assertEquals("Light is RED", tl.printLight(19));
    }
}