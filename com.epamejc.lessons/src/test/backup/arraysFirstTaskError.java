package homeworks.HW3_arrays.arrayGeneration;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Scanner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TwoDimensionalArrayTest {

    public static homeworks.HW3_arrays.arrayGeneration.TwoDimensionalArray array;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    /**
     * Testing the size of a generated array with random characters
     */
    @Test
    public void testGenerateArray() {
        int expectedSize = 5;
        int actualSize = (array.generateArray(5, 5)).length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    /**
     * User input testing to define lines quantity with correct input
     */
    @Test
    public void testDefineLinesQuantity() {
        int expectedLinesNum = 4;
        systemInMock.provideLines("4");
        Scanner scanner = new Scanner(System.in);
        int actualLinesNum = array.defineLinesQuantity(scanner);
        Assert.assertEquals(expectedLinesNum, actualLinesNum);
    }

    /**
     * User input testing to define lines quantity with incorrect input
     */
    @Test (expected = Exception.class)
    public void testDefineLinesQuantityIncorrect() {
        systemInMock.provideLines("incorrect");
        Scanner scanner = new Scanner(System.in);
        array.defineLinesQuantity(scanner);
    }
}