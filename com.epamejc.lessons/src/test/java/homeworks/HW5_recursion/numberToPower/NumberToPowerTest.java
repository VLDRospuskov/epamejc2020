package homeworks.HW5_recursion.numberToPower;

import org.junit.Assert;
import org.junit.Test;

public class NumberToPowerTest {

    @Test
    public void testPowerNumber() {
        int inputBase = 5;
        int inputPower = 6;
        long expectedNumber = 15625;
        long actualNumber = NumberToPower.powerNumber(inputBase, inputPower);

        Assert.assertEquals(expectedNumber, actualNumber);
    }
}