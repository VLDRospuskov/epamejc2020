package homeworks.java.hw5.recursion_2;

import org.junit.*;
import static org.junit.Assert.*;

public class ExponentiationTest {

    Exponentiation exp;

    @Before
    public void setup() {
        exp = new Exponentiation();
    }

    @Test
    public void generateFibonacciNumbersTest() {
        int expected = 8;
        int actual = exp.exponentiation(2, 2, 3);
        assertEquals(expected, actual);
    }
}

