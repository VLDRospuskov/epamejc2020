package test.homeworks.homework5.fibonaccinumbers;

import main.homeworks.homework5.fibonaccinumbers.Fibonacci;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    private static Fibonacci fibonacci;

    @Before
    public void initialization() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void testFibonacciSearch() {
        long actual1 = fibonacci.fibonacciSearch(1);
        long actual2 = fibonacci.fibonacciSearch(5);
        long actual3 = fibonacci.fibonacciSearch(10);
        long expected1 = 1;
        long expected2 = 5;
        long expected3 = 55;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
}