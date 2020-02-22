package homeworks.homework3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultipleArrayBuilderTest {

    private static MultipleArrayBuilder builder;
    private char[][] arr = new char[][] { {'a', 'b'}, {'c', 'd'} };

    @BeforeClass
    public static void setup() {
        builder = new MultipleArrayBuilder();
    }

    @Test
    public void testCreateArray() {
        char[][] array = builder.createArray(5, 5);
        int actualLength = array.length;
        int expectedLength = 5;
        int actualInnerLength = array[0].length;
        int expectedInnerLength = 5;
        Assert.assertEquals(expectedLength, actualLength);
        Assert.assertEquals(expectedInnerLength, actualInnerLength);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                boolean actual = Character.isLetter(array[i][j]);

                Assert.assertTrue(actual);
            }
        }

    }

    @Test
    public void testPrintArray() {
        String actual = builder.printArray(arr);
        String expected = "a b \nc d \n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintEven() {
        String actual = builder.printEven(arr);
        String expected = "d";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintOdd() {
        String actual = builder.printOdd(arr);
        String expected = "a";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPyramid() {
        String actual = builder.pyramid(4);
        String expected = "0000\n" +
                          "000\n" +
                          "00\n" +
                          "0\n";
        Assert.assertEquals(expected, actual);
    }
}