package test.homeworks.hw5;

import main.homeworks.hw5.Fibonacci;
import org.junit.*;

import static org.junit.Assert.*;

public class FibonacciTest {

    private static Fibonacci fibonacci;

    @Before
    public void setup() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void testFibonacci() {
        int expected1 = 5;
        int actual1 = fibonacci.fibonacciSeries(4);
        assertEquals(expected1, actual1);
    }

}
