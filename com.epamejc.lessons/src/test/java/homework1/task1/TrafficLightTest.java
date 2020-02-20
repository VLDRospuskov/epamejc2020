package homework1.task1;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrafficLightTest {

    private TrafficLight instance;

    @Before
    public void init() {
        instance = new TrafficLight();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("123");
        inputs.add("125");
        inputs.add("129");
        inputs.add("ikruh");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void chooseColorSuccessTest() {
        String green = "Green signal";
        String yellow = "Yellow signal";
        String red = "Red signal";

        String timeGreen = "92";
        String timeYellow = "94";
        String timeRed = "98";

        assertEquals(green, instance.chooseColor(timeGreen));
        assertEquals(yellow, instance.chooseColor(timeYellow));
        assertEquals(red, instance.chooseColor(timeRed));
    }

    @Test
    public void chooseColorNegativeTest() {
        String incorrect1 = "iuuw324wefw";
        String incorrect2 = "123 431";
        assertThrows(RuntimeException.class, () -> instance.chooseColor(incorrect1));
        assertThrows(RuntimeException.class, () -> instance.chooseColor(incorrect2));
    }
}