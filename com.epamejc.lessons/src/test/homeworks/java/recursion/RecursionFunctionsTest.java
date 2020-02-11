package homeworks.java.recursion;

import org.junit.Assert;
import org.junit.Test;

import static homeworks.java.recursion.RecursionFunctions.*;

public class RecursionFunctionsTest {

    @Test
    public void fibonacciTest() {
        int num = 10;

        int[] expected = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        int[] actual = new int[num];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = fibonacci(i);
        }

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void powTestPositive() {
        double num = 5.16;
        int pow = 5;

        double expected = 3658.040488857601;
        double actual = pow(num, pow);

        Assert.assertEquals(expected, actual, 0.00000001);
    }

    @Test
    public void powTestNegative() {
        double num = 5.16;
        int pow = -4;

        double expected = 0.001410591275771105;
        double actual = pow(num, pow);

        Assert.assertEquals(expected, actual, 0.00000001);
    }

    @Test
    public void numOfDigitsTest() {
        int num = 666;

        int expected = 3;
        int actual = numOfDigits(num);

        Assert.assertEquals(expected, actual);
    }
}
