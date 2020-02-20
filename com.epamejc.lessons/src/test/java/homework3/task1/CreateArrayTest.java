package homework3.task1;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class CreateArrayTest {

    private CreateArray instance;

    @Before
    public void init() {
        instance = new CreateArray();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("12 12");
        inputs.add("fddvd");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void inputCheckSuccessTest() {

        String input1 = "123 65788";
        String input2 = "1 6";

        List<Integer> result1 = new ArrayList<>();
        result1.add(123);
        result1.add(65788);

        List<Integer> result2 = new ArrayList<>();
        result2.add(1);
        result2.add(6);

        assertEquals(result1, instance.inputCheck(input1));
        assertEquals(result2, instance.inputCheck(input2));
    }

    @Test
    public void inputCheckNegativeTest() {

        String input1 = "12365788";
        String input2 = "gdgdfgdg gdfgdfg";

        assertThrows(RuntimeException.class, () -> instance.inputCheck(input1));
        assertThrows(RuntimeException.class, () -> instance.inputCheck(input2));
    }
}