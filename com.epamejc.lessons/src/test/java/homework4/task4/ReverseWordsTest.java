package homework4.task4;

import TestReaderAndPrinter.TestPrinter;
import TestReaderAndPrinter.TestReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReverseWordsTest {
    private ReverseWords instance;

    @Before
    public void init() {
        instance = new ReverseWords();
    }

    @After
    public void afterTests() {
        instance = null;
    }

    @Test
    public void startTest() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("qwe rty");
        inputs.add("exit");

        TestReader testReader = new TestReader(inputs);
        TestPrinter testPrinter = new TestPrinter();
        instance.start(testReader, testPrinter);

        testPrinter.eraseState();
    }

    @Test
    public void reverseWordTest() {
        String inputString = "qwe rty";
        String expectedString = "ewq ytr";

        String actualString = instance.reverseWord(inputString);

        assertEquals(expectedString, actualString);
    }
}