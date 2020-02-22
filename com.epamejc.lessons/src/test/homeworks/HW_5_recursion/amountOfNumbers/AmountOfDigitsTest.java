package homeworks.HW_5_recursion.amountOfNumbers;

import org.junit.*;

public class AmountOfDigitsTest {

    @Test
    public void testGetDigits() {
        int actual = new AmountOfDigits().getDigits(54);
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }
}
