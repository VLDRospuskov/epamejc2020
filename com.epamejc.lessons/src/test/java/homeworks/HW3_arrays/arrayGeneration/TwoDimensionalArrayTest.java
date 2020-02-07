package homeworks.HW3_arrays.arrayGeneration;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;

import static java.lang.System.in;
import static java.lang.System.setIn;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TwoDimensionalArrayTest {

    private static homeworks.HW3_arrays.arrayGeneration.TwoDimensionalArray array;
    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        array = new homeworks.HW3_arrays.arrayGeneration.TwoDimensionalArray();
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
        int actualSize = (array.generateArray(linesQuantity, rowsQuantity)).length;
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
        int actualSize = (array.generateArray(linesQuantity, rowsQuantity))[0].length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @AfterClass
    public static void returnIn() {
        setIn(originalIn);
    }
}