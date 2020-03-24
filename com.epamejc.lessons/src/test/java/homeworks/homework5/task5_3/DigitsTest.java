package homeworks.homework5.task5_3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitsTest {

    @Test
    public void getAmountOfDigits() {
        int expected = 2;
        int actual = Digits.getAmountOfDigits(-24);
        assertEquals(expected, actual);
    }

}