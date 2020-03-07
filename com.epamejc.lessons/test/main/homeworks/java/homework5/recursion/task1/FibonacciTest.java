package main.homeworks.java.homework5.recursion.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    private Fibonacci fibonacci = new Fibonacci();

    @Test
    public void TestFib() {
        long[] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21 };
        long[] actual = new long[expected.length];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = fibonacci.fib(i);
        }

        assertArrayEquals(expected, actual);
    }
}