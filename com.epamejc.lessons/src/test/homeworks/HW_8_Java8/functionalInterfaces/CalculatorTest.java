package homeworks.HW_8_Java8.functionalInterfaces;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void getRandomInt() {
        int actual = Calculator.getRandomInt(() -> (int) (Math.random() * 100));
        boolean condition = 0 < actual && actual < 100;
        assertTrue(condition);
    }

    @Test
    public void getSumAsDouble() {
        Double actual = Calculator.getSumAsDouble(5, 9, (a, b) -> (double) (a + b));
        boolean isDouble = actual.getClass().isInstance(5.0);
        boolean condition = actual == (double) 5 + 9;
        assertTrue(isDouble && condition);
    }
}