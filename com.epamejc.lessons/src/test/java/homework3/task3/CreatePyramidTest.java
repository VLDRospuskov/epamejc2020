package homework3.task3;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CreatePyramidTest {
    private CreatePyramid instance;

    @Before
    public void init() {
        instance = new CreatePyramid();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("12");
        inputs.add("qwerty");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void createPyramidTest() {
        int pyramidHeight = 5;
        String[][] expectedPyramid = new String[pyramidHeight][];
        for (int i = 0; i < pyramidHeight; i++) {
            expectedPyramid[i] = new String[pyramidHeight - i];
        }

        String[][] actualPyramid = instance.createPyramid("5");

        assertEquals(expectedPyramid.length, actualPyramid.length);
        assertEquals(expectedPyramid[3].length, actualPyramid[3].length);
    }
}