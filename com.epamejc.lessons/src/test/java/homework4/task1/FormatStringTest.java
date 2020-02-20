package homework4.task1;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FormatStringTest {
    private FormatString instance;

    @Before
    public void init() {
        instance = new FormatString();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("qwerty");
        inputs.add("even");
        inputs.add("qwerty");
        inputs.add("odd");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void evenTest() {
        String inputString = "qwerty";

        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("even");

        String expectedString = "wry";

        TestReader testReader = new TestReader(inputs);

        assertEquals(expectedString, instance.evenOrOdd(inputString, testReader));
    }

    @Test
    public void oddTest() {
        String inputString = "qwerty";

        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("odd");

        String expectedString = "qet";

        TestReader testReader = new TestReader(inputs);

        assertEquals(expectedString, instance.evenOrOdd(inputString, testReader));
    }

    @Test
    public void extractLettersFromStringTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("qwerty");

        int index = 0;

        String expectedString = "qet";

        assertEquals(expectedString, instance.extractLettersFromString("qwerty", index));
    }
}