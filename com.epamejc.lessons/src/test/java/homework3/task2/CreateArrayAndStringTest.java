package homework3.task2;

import TestReaderAndPrinter.TestReader;
import TestReaderAndPrinter.TestPrinter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateArrayAndStringTest {
    private CreateArrayAndString instance;

    @Before
    public void init() {
        instance = new CreateArrayAndString();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("4 4");
        inputs.add("fgvsvc");
        inputs.add("A");
        inputs.add("fgsdfs");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }


    @Test
    public void inputCheckSuccessTest() {
        String input1 = "32 23";
        String input2 = "2 9";

        List<Integer> result1 = new ArrayList<>();
        result1.add(32);
        result1.add(23);

        List<Integer> result2 = new ArrayList<>();
        result2.add(2);
        result2.add(9);

        assertEquals(result1, instance.inputCheck(input1));
        assertEquals(result2, instance.inputCheck(input2));
    }

    @Test
    public void inputCheckNegativeTest() {
        String input1 = "63453";
        String input2 = "qwerty 235";

        assertThrows(RuntimeException.class, () -> instance.inputCheck(input1));
        assertThrows(RuntimeException.class, () -> instance.inputCheck(input2));
    }

    @Test
    public void createArrayTest() {
        ArrayList<String> inputs = new ArrayList<>();

        int columns = 4;
        int rows = 4;

        inputs.add(columns + " " + rows);
        inputs.add("A");
        inputs.add("exit");

        TestReader reader = new TestReader(inputs);
        TestPrinter printer = new TestPrinter();

        instance.start(reader, printer);

        List<String> outputs = printer.getOutputs();
        String matrixString = outputs.get(0);
        String strategyString = outputs.get(1);

        assertEquals(outputs.size(), 2);
        assertEquals(36, matrixString.length());
        assertEquals(rows, matrixString.split("\n").length);
        assertTrue(Arrays.stream(matrixString.split("\n")).allMatch(row -> row.length() == columns * 2));
        assertEquals(strategyString.length(), 4);

        printer.eraseState();
    }

    @Test
    public void choiceStrategyA_andCreateStringTest() {
        ArrayList<String> inputs = new ArrayList<>();
        int columns = 3;
        int rows = 3;
        int startIndexExpected = 0;
        int resultStringLengthExpected = 4;

        inputs.add(columns + " " + rows);
        inputs.add("A");
        inputs.add("exit");

        TestReader reader = new TestReader(inputs);
        TestPrinter printer = new TestPrinter();
        instance.start(reader, printer);

        assertEquals(startIndexExpected, 0);
        assertEquals(resultStringLengthExpected, 4);

        printer.eraseState();
    }

    @Test
    public void choiceStrategyB_andCreateStringTest() {
        ArrayList<String> inputs = new ArrayList<>();
        int columns = 3;
        int rows = 3;
        int startIndexExpected = 1;
        int resultStringLengthExpected = 1;

        inputs.add(columns + " " + rows);
        inputs.add("B");
        inputs.add("exit");

        TestReader reader = new TestReader(inputs);
        TestPrinter printer = new TestPrinter();
        instance.start(reader, printer);

        assertEquals(startIndexExpected, 1);
        assertEquals(resultStringLengthExpected, 1);

        printer.eraseState();
    }
}