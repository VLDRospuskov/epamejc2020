package homeworks.HW5_recursion.countNumbers;

import org.junit.Assert;
import org.junit.Test;

public class CountNumbersTest {

    @Test
    public void testCountNumbers() {
        String inputNumber = "1s23dd";
        int expectedNumber = 3;
        int actualNumber = CountNumbers.countNumbers(inputNumber);

        Assert.assertEquals(expectedNumber, actualNumber);
    }
}