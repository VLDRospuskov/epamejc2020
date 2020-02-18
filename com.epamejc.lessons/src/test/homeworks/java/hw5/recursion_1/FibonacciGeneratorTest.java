package homeworks.java.hw5.recursion_1;

import org.junit.*;
import static org.junit.Assert.*;

public class FibonacciGeneratorTest {

    FibonacciGenerator fc;

    @Before
    public void setup() {
        fc = new FibonacciGenerator();
    }

    @Test
    public void generateFibonacciNumbersTest() {
        String expected = "1 2 3 5 8 13 21 34 55 89 ";
        String actual = fc.generateFibonacciNumbers(0, 1, 10);
        assertEquals(expected, actual);
    }
}
