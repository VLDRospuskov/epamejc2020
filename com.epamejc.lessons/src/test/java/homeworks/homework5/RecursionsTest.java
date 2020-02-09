package homeworks.homework5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionsTest {

    private static Recursions recursions;

    @BeforeClass
    public static void setup() {
        recursions = new Recursions();
    }

    @Test
    public void testFibonacci() {
        int actual = recursions.fibonacci(5);
        int expected = 5;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testExponent() {
        int actual = recursions.exponent(6, 4);
        int expected = 1296;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNumbersQty() {
        int actual = recursions.numbersQty(1296);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }
}