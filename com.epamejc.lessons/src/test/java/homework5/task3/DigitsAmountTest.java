package homework5.task3;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DigitsAmountTest {
    private DigitsAmount instance;

    @Before
    public void init() {
        instance = new DigitsAmount();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("445");
        inputs.add("23");
        inputs.add("fgsdfs");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void amountOfDigitsTest() {
        int inputInt = 9876;
        int expectedInt = 4;

        int actualInt = instance.amountOfDigits(inputInt);

        assertEquals(expectedInt, actualInt);
    }
}