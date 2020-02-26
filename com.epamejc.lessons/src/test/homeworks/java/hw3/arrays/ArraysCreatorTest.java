package homeworks.java.hw3.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static homeworks.java.hw3.enums.Messages.WARNING_FOR_PARSING_TO_INT;

public class ArraysCreatorTest {
    private final ByteArrayOutputStream OUT_CONTENT = new ByteArrayOutputStream();
    private final PrintStream OUT_ORIGINAL = System.out;

    @Before
    public void setUp(){
        System.setOut(new PrintStream(OUT_CONTENT));
    }

    @After
    public void restoreStream(){
        System.setOut(OUT_ORIGINAL);
    }

    @Test
    public void testRandomCharsArrayHaveLengthThreeAndNotEmpty() {
        FirstArray firstArray = new FirstArray();
        final int expectedLength = 3;
        char[][] actual = firstArray.makeRandomCharsArray("3", "2");
        Assert.assertEquals(expectedLength, actual.length);
        Assert.assertNotNull(actual);
    }

    @Test
    public void testRandomCharsArrayWithWrongInputType(){
        FirstArray firstArray = new FirstArray();
        firstArray.makeRandomCharsArray("three", "two");
        Assert.assertEquals(WARNING_FOR_PARSING_TO_INT.toString().trim(), OUT_CONTENT.toString().trim());
    }

    @Test
    public void testOutputInAStrategyIsNotEmpty() {
        SecondArray secondArray = new SecondArray();
        String actual = secondArray.strategyAOutput("5");
        Assert.assertNotNull(actual);
    }

    @Test
    public void TestOutputInBStrategyIsNotEmpty() {
        SecondArray secondArray = new SecondArray();
        String actual = secondArray.strategyBOutput("6");
        Assert.assertNotNull(actual);
    }

    @Test
    public void testStrategyAOutputWithWrongInputType(){
        SecondArray secondArray = new SecondArray();
        secondArray.strategyAOutput("six");
        Assert.assertEquals(WARNING_FOR_PARSING_TO_INT.toString().trim(), OUT_CONTENT.toString().trim());
    }

    @Test
    public void testStrategyBOutputWithWrongInputType(){
        SecondArray secondArray = new SecondArray();
        secondArray.strategyBOutput("five");
        Assert.assertEquals(WARNING_FOR_PARSING_TO_INT.toString().trim(), OUT_CONTENT.toString().trim());
    }

    @Test
    public void TestPyramidHasLengthTenAndFilledByX() {
        ThirdArray thirdArray = new ThirdArray();
        final int expectedLength = 10;
        final String expectedStr = "X";

        String[][] actual = thirdArray.fillPyramid("10", "X");

        Assert.assertEquals(expectedLength, actual.length);
        Assert.assertEquals(expectedStr, actual[0][0]);
    }

    @Test
    public void testPyramidMakerWithWrongInputType(){
        ThirdArray thirdArray = new ThirdArray();
        thirdArray.fillPyramid("six", "X");
        Assert.assertEquals(WARNING_FOR_PARSING_TO_INT.toString().trim(), OUT_CONTENT.toString().trim());
    }
}