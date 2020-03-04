package homework.homework2.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigitsCounterTest {

    @Test
    public void countDigits() {
        int num1 = 1234567890;
        int num2 = 0;
        int num3 = 34567;

        assertEquals(String.valueOf(num1).length(), DigitsCounter.countDigits(num1));
        assertEquals(String.valueOf(num2).length(), DigitsCounter.countDigits(num2));
        assertEquals(String.valueOf(num3).length(), DigitsCounter.countDigits(num3));
    }
}