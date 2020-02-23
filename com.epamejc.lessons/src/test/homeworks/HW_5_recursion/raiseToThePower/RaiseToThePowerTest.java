package homeworks.HW_5_recursion.raiseToThePower;

import org.junit.Test;
import org.junit.Assert;

public class RaiseToThePowerTest {

    @Test
    public void testGetPowerOfNumber() {
        int expected = 9;
        int actual = RaiseToThePower.getPowerOfNumber(3, 2);
        Assert.assertEquals(expected, actual);

        expected = 32;
        actual = RaiseToThePower.getPowerOfNumber(2, 5);
        Assert.assertEquals(expected, actual);
    }
}