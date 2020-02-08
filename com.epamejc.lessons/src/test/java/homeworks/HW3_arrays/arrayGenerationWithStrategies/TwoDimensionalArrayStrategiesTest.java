package homeworks.HW3_arrays.arrayGenerationWithStrategies;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;

import static java.lang.System.in;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TwoDimensionalArrayStrategiesTest {

    private static homeworks.HW3_arrays.arrayGenerationWithStrategies.TwoDimensionalArrayStrategies twoDimArr;
    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        twoDimArr = new homeworks.HW3_arrays.arrayGenerationWithStrategies.TwoDimensionalArrayStrategies();
        originalIn = in;
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    /**
     * Testing the size of a generated array with random characters
     */
    @Test
    public void testGenerateArrayLines() {
        int expectedSize = 5;
        int linesQuantity = 5;
        int rowsQuantity = 6;
        int actualSize = (twoDimArr.generateArray(linesQuantity, rowsQuantity)).length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    /**
     * Testing the size of a generated array with random characters
     */
    @Test
    public void testGenerateArrayRows() {
        int expectedSize = 3;
        int linesQuantity = 5;
        int rowsQuantity = 3;
        int actualSize = (twoDimArr.generateArray(linesQuantity, rowsQuantity))[0].length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    /**
     * Testing the created string from an array with strategy A
     */
    @Test
    public void testProcessArrayWithStrategyA() {
        int arrayLinesNum = 10;
        int arrayRowsNum = 10;
        int strategyNumber = 1;
        int expectedStringLength = 25;
        char[][] testArray = new char[arrayLinesNum][arrayRowsNum];
        int actualStringLength = (twoDimArr.processArrayWithStrategy(testArray, strategyNumber)).length();
        Assert.assertEquals(expectedStringLength, actualStringLength);
    }

    /**
     * Testing the created string from an array with strategy A
     */
    @Test
    public void secondTestProcessArrayWithStrategyA() {
        int arrayLinesNum = 5;
        int arrayRowsNum = 5;
        int strategyNumber = 1;
        int expectedStringLength = 9;
        char[][] testArray = new char[arrayLinesNum][arrayRowsNum];
        int actualStringLength = (twoDimArr.processArrayWithStrategy(testArray, strategyNumber)).length();
        Assert.assertEquals(expectedStringLength, actualStringLength);
    }

    /**
     * Testing the created string from an array with strategy B
     */
    @Test
    public void testProcessArrayWithStrategyB() {
        int arrayLinesNum = 7;
        int arrayRowsNum = 7;
        int strategyNumber = 2;
        int expectedStringLength = 9;
        char[][] testArray = new char[arrayLinesNum][arrayRowsNum];
        int actualStringLength = (twoDimArr.processArrayWithStrategy(testArray, strategyNumber)).length();
        Assert.assertEquals(expectedStringLength, actualStringLength);
    }
}