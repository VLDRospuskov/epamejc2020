package homeworks.HW5_recursion.fibonacciNumber;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciNumberTest {

    @Test
    public void testFibonacciCalc() {
        int inputNumber = 10;
        int[] expectedResultArray = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        int[] actualResultArray = new int[inputNumber];
        for (int i = 0; i < actualResultArray.length; i++) {
            actualResultArray[i] = FibonacciNumber.fibonacciCalc(i);
        }

        Assert.assertArrayEquals(expectedResultArray, actualResultArray);
    }
}