package homework5.task2;


import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExponentiationTest {
    private Exponentiation instance;

    @Before
    public void init() {
        instance = new Exponentiation();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("4");
        inputs.add("4");
        inputs.add("fgsdfs");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void exponentiationTest() {
        int number = 5;
        int pow = 4;

        int expectedResult = 625;
        int actualResult = instance.exponentiation(number, pow);

        assertEquals(expectedResult, actualResult);
    }
}