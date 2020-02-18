package homeworks.java.hw5.recursion_3;

import org.junit.*;
import static org.junit.Assert.*;

public class NumberOfDigitsCounterTest {
    NumberOfDigitsCounter counter;

    @Before
    public void setup() {
        counter = new NumberOfDigitsCounter();
    }

    @Test
    public void countNumberOfDigits() {
        int expected = 4;
        int actual = counter.countNumberOfDigits(2020, 0);
        assertEquals(expected, actual);
    }

}
