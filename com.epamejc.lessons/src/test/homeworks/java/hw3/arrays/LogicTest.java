package homeworks.java.hw3.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.Assert.*;

public class LogicTest {
//    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private final PrintStream ORIGINAL_OUT = System.out;
    private Logic logic;

    @Before
    public void setUp(){
        logic = new Logic();
//        System.setOut(new PrintStream(OUTPUT));
    }

    @After
    public void restoreStream(){
        logic = null;
        System.setOut(ORIGINAL_OUT);
    }

    @Test
    public void makeRandomCharsArray_HasLength3AndNotEmptyTest() {
        BufferedReader buffer = new BufferedReader(new StringReader("3\n2\n"));
        final int expectedLength = 3;
        char[][] actual = logic.makeRandomCharsArray(buffer);
        Assert.assertEquals(expectedLength, actual.length);
        Assert.assertNotNull(actual);
    }

    @Test
    public void outputInAStrategy_IsNotEmptyTest() {
        BufferedReader buffer = new BufferedReader(new StringReader("5\nA"));
        String actualOutput = logic.outputInDifferentStrategies(buffer);
        Assert.assertNotNull(actualOutput);
    }

    @Test
    public void outputInBStrategy_IsNotEmptyTest() {
        BufferedReader buffer = new BufferedReader(new StringReader("7\nB"));
        String actualOutput = logic.outputInDifferentStrategies(buffer);
        Assert.assertNotNull(actualOutput);
    }

    @Test
    public void makePyramid_HasLengthTenAndFulledByX() {
        BufferedReader buffer = new BufferedReader(new StringReader("10\nX"));
        final int expectedLength = 10;
        final String expectedStr = "X";

        String[][] actualPyramid = logic.makePyramid(buffer);

        Assert.assertEquals(expectedLength, actualPyramid.length);
        Assert.assertEquals(expectedStr, actualPyramid[0][0]);
    }
}