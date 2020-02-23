package homeworks.HW_5_recursion.amountOfNumbers;

import org.junit.Assert;
import org.junit.Test;


public class AmountOfDigitsTest {

    @Test
    public void testGetDigits() {
        int expected = 1;
        int actual = new AmountOfDigits().getDigits(9);
        Assert.assertEquals(expected, actual);

        expected = 2;
        actual = new AmountOfDigits().getDigits(98);
        Assert.assertEquals(expected, actual);

        expected = 5;
        actual = new AmountOfDigits().getDigits(98765);
        Assert.assertEquals(expected, actual);
    }
}
