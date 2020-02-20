package homework5.task1;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {
    private Fibonacci instance;

    @Before
    public void init() {
        instance = new Fibonacci();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("15");
        inputs.add("fgvsvc");
        inputs.add("345");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void inputCheckSuccessTest() throws Exception {
        String inputString = "15";
        int expectedInt = 15;

        int actualInt = instance.inputCheck(inputString);

        assertEquals(expectedInt, actualInt);
    }

    @Test
    public void inputCheckNegativeTest() {
        String inputWrongString1 = "tryhwwrefg";
        String inputWrongString2 = "345";

        assertThrows(RuntimeException.class, () -> instance.inputCheck(inputWrongString1));
        assertThrows(Exception.class, () -> instance.inputCheck(inputWrongString2));
    }

    @Test
    public void findFib() {
        int inputInt = 15;
        int expectedInt = 610;

        int actualInt = instance.findFib(inputInt);

        assertEquals(expectedInt, actualInt);
    }
}