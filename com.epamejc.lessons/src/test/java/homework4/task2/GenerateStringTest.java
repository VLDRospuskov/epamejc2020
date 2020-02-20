package homework4.task2;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GenerateStringTest {
    private GenerateString instance;

    @Before
    public void init() {
        instance = new GenerateString();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("qwerty");
        inputs.add("0");
        inputs.add("2");
        inputs.add("4");
        inputs.add("end");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void generateStringTest() {
        String inputString = "qwerty";

        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("1");
        inputs.add("3");
        inputs.add("5");
        inputs.add("end");

        String expectedResultString = "wry";

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();

        instance.generateString(inputString, testReader, testPrinter);

        List<String> actualStringArray = testPrinter.getOutputs();
        String actualString = actualStringArray.get(inputs.size() - 2);

        assertEquals(expectedResultString, actualString);

        testPrinter.eraseState();
    }
}