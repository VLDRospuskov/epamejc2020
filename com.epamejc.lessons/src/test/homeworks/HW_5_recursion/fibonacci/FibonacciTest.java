package homeworks.HW_5_recursion.fibonacci;

import org.junit.Test;
import org.junit.Assert;

public class FibonacciTest {

    @Test
    public void testGetFibonacci() {
        int expected = 144;
        int actual = new Fibonacci().getFibonacci(12);
        Assert.assertEquals(expected, actual);
    }

}
