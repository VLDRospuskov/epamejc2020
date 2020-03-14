package Home_works.HW2.Number4_3;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void countOfNumbers() {
        int inputNumber = 123;
        int expectedNumber = 3;
        int actualNumber =  Main.countOfNumbers(inputNumber);

        Assert.assertEquals(expectedNumber, actualNumber);
    }
}