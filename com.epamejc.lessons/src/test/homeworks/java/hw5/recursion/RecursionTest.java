package homeworks.java.hw5.recursion;

import homeworks.java.hw5.recursion.countnumbers.Counter;
import homeworks.java.hw5.recursion.fibbonacci.Fibbonachi;
import homeworks.java.hw5.recursion.power.Power;
import org.junit.Assert;
import org.junit.Test;

public class RecursionTest {

    @Test
    public void testCounterOfNumbersWithValidInputs() {
        Assert.assertEquals(12, Counter.counterOfNumbers(123456789012L));
        Assert.assertEquals(1, Counter.counterOfNumbers(0));
        Assert.assertEquals(15, Counter.counterOfNumbers(123456789012558L));
    }

    @Test(expected = ArithmeticException.class)
    public void testCounterOfNumbersWithInvalidInput() {
        Counter.counterOfNumbers(-56489);
    }

    @Test
    public void testFindInFibonacciRowWithValidInputs() {
        Assert.assertEquals(987, Fibbonachi.findInFibbonachiRow(16));
        Assert.assertEquals(0, Fibbonachi.findInFibbonachiRow(0));
        Assert.assertEquals(1, Fibbonachi.findInFibbonachiRow(1));
    }

    @Test(expected = ArithmeticException.class)
    public void testFindInFibonacciRowWithInvalidInput() {
        Fibbonachi.findInFibbonachiRow(-6);
    }

    @Test
    public void testRaiseBaseXToPositiveIntegerPowerNWithValidInput() {
        Assert.assertEquals(4, Power.raiseBaseXToPositiveIntegerPowerN(2, 2));
        Assert.assertEquals(1, Power.raiseBaseXToPositiveIntegerPowerN(0, 0));
        Assert.assertEquals(1, Power.raiseBaseXToPositiveIntegerPowerN(10, 0));
        Assert.assertEquals(20, Power.raiseBaseXToPositiveIntegerPowerN(20, 1));
    }

    @Test(expected = ArithmeticException.class)
    public void testRaiseBaseXToPositiveIntegerPowerNWithInvalidInput() {
        Power.raiseBaseXToPositiveIntegerPowerN(-5, 3);
        Power.raiseBaseXToPositiveIntegerPowerN(5, -7);
    }

}