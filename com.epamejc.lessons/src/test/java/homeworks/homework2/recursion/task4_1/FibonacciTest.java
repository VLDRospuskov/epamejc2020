package homeworks.homework2.recursion.task4_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void calculatePositiveFibonacci() {
        int expected = 34;
        int actual = Fibonacci.calculateFibonacci(9);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateNegativeFibonacci() {
        int expected = 0;
        int actual = Fibonacci.calculateFibonacci(-2);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateZeroFibonacci() {
        int expected = 0;
        int actual = Fibonacci.calculateFibonacci(0);
        assertEquals(expected, actual);
    }

}