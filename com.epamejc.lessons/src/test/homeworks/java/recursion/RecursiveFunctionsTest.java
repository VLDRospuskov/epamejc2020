package homeworks.java.recursion;

import org.junit.Assert;
import org.junit.Test;

import static homeworks.java.recursion.RecursiveFunctions.*;

public class RecursiveFunctionsTest {

    @Test
    public void testFibonacci() {

        int index = 10;
        int[] expected = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        int[] actual = new int[index];

        for (int i = 0; i < actual.length; i++) {
            actual[i] = fibonacci(i);
        }

        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void testPowPositive() {

        double base = 5.16;
        int power = 5;
        double expected = 3658.040488857601;

        double actual = pow(base, power);

        Assert.assertEquals(expected, actual, 0.00000001);

    }

    @Test
    public void testPowNegative() {

        double base = 5.16;
        int power = -4;
        double expected = 0.001410591275771105;

        double actual = pow(base, power);

        Assert.assertEquals(expected, actual, 0.00000001);

    }

    @Test
    public void testNumOfDigits() {

        int number = 666;

        int expected = 3;
        int actual = numOfDigits(number);

        Assert.assertEquals(expected, actual);

    }

}
