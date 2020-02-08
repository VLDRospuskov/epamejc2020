package homeworks.HW3_arrays.arrayGenerationWithStrategies;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setIn;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TwoDimArrStrategiesAppTest {

    public static homeworks.HW3_arrays.arrayGenerationWithStrategies.TwoDimArrStrategiesApp arrayStrategiesApp;
    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        arrayStrategiesApp = new homeworks.HW3_arrays.arrayGenerationWithStrategies.TwoDimArrStrategiesApp();
        originalIn = in;
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    /**
     * Testing user input to define lines quantity with correct input
     */
    @Test
    public void testDefineLinesQuantity() {
        int expectedLinesNum = 4;
        systemInMock.provideLines("4");
        Scanner scanner = new Scanner(System.in);
        int actualLinesNum = arrayStrategiesApp.defineLinesQuantity(scanner);
        Assert.assertEquals(expectedLinesNum, actualLinesNum);
    }

    /**
     * Testing user input to define rows quantity with correct input
     */
    @Test
    public void testDefineRowsQuantity() {
        int expectedRowsNum = 6;
        systemInMock.provideLines("6");
        Scanner scanner = new Scanner(System.in);
        int actualRowsNum = arrayStrategiesApp.defineRowsQuantity(scanner);
        Assert.assertEquals(expectedRowsNum, actualRowsNum);
    }

    /**
     * Testing user input to define strategy number with correct input
     */
    @Test
    public void testDefineStrategy() {
        int expectedStrategyNum = 1;
        systemInMock.provideLines("1");
        Scanner scanner = new Scanner(System.in);
        int actualStrategyNum = arrayStrategiesApp.defineRowsQuantity(scanner);
        Assert.assertEquals(expectedStrategyNum, actualStrategyNum);
    }

    /**
     * Testing user input to define lines quantity with incorrect input
     */
    @Test(expected = Exception.class)
    public void testDefineLinesQuantityIncorrect() {
        systemInMock.provideLines("incorrect");
        Scanner scanner = new Scanner(System.in);
        arrayStrategiesApp.defineLinesQuantity(scanner);
    }

    /**
     * Testing user input to define rows quantity with incorrect input
     */
    @Test(expected = Exception.class)
    public void testDefineRowsQuantityIncorrect() {
        systemInMock.provideLines("-10");
        Scanner scanner = new Scanner(System.in);
        arrayStrategiesApp.defineRowsQuantity(scanner);
    }

    /**
     * Testing user input to define number of strategy with incorrect input
     */
    @Test(expected = Exception.class)
    public void testDefineStrategyIncorrect() {
        systemInMock.provideLines("3");
        Scanner scanner = new Scanner(System.in);
        arrayStrategiesApp.defineStrategy(scanner);
    }

    @AfterClass
    public static void returnIn() {
        setIn(originalIn);
    }
}