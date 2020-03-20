package homeworks.homework02;

import org.junit.Assert;
import org.junit.Test;

public class ArrayMethodsTest {

    ArrayMethods arrayMethods = new ArrayMethods();

    @Test
    public void testPrintPyramid() {

        char[][] expected = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X'},
                {'X', 'X'},
                {'X'}
        };

        char[][] actual = arrayMethods.generatePyramid(5);

        for (int i = 0; i < 5; i++) {
            Assert.assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testGetStringFromCharArrayByStrategy() {
        char[][] values = {
                {'a', 'b', 'c', 'd', 'e'},
                {'1', '2', '3', '4', '5'},
                {'b', 'c', 'd', 'e', 'f'},
                {'2', '3', '4', '5', '6'},
                {'c', 'd', 'e', 'f', 'g'}
        };

        String expected = "acebdfceg";
        String actual = arrayMethods.getStringFromCharArrayByStrategy(values, "A");

        Assert.assertEquals(expected, actual);

        expected = "2435";
        actual = arrayMethods.getStringFromCharArrayByStrategy(values, "B");

        Assert.assertEquals(expected, actual);
    }

}
