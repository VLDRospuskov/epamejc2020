package homeworks.HW3_arrays.arrayGeneration;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.setIn;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TwoDimArrayApplicationTest {

    public static TwoDimArrayApplication arrayApp;
    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        arrayApp = new TwoDimArrayApplication();
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
        int actualLinesNum = arrayApp.defineLinesQuantity(scanner);
        Assert.assertEquals(expectedLinesNum, actualLinesNum);
    }

    /**
     * Testing user input to define lines quantity with incorrect input
     */
    @Test(expected = Exception.class)
    public void testDefineLinesQuantityIncorrect() {
        systemInMock.provideLines("incorrect");
        Scanner scanner = new Scanner(System.in);
        arrayApp.defineLinesQuantity(scanner);
    }

    /**
     * Testing user input to define rows quantity with correct input
     */
    @Test
    public void testDefineRowsQuantity() {
        int expectedRowsNum = 6;
        systemInMock.provideLines("6");
        Scanner scanner = new Scanner(System.in);
        int actualRowsNum = arrayApp.defineRowsQuantity(scanner);
        Assert.assertEquals(expectedRowsNum, actualRowsNum);
    }

    /**
     * Testing user input to define rows quantity with incorrect input
     */
    @Test(expected = Exception.class)
    public void testDefineRowsQuantityIncorrect() {
        systemInMock.provideLines("-10");
        Scanner scanner = new Scanner(System.in);
        arrayApp.defineRowsQuantity(scanner);
    }

    @AfterClass
    public static void returnIn() {
        setIn(originalIn);
    }
}