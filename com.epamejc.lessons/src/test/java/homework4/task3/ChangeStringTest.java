package homework4.task3;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChangeStringTest {
    private ChangeString instance;

    @Before
    public void init() {
        instance = new ChangeString();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("qwerty");
        inputs.add("0, 5");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void inputIndicesCheckTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("0, 5");

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(5);

        TestReader testReader = new TestReader(inputs);

        List<Integer> actualList = instance.inputIndicesCheck(testReader);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void changeStringTest() {
        String inputString = "qwerty";
        int firstIndex = 0;
        int secondIndex = 5;

        String expectedString = "ywertq";
        String actualString = instance.changeString(inputString, firstIndex, secondIndex);

        assertEquals(expectedString, actualString);
    }
}