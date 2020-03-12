package homeworks.homework5.task4_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerTest {

    @Test
    public void calcPositivePow() {
        double expected = 8;
        double actual = Power.calcPow(2, 3);
        assertEquals(expected, actual, 0.0001);

    }

    @Test
    public void calcNegativePow() {
        double expected = 0.125;
        double actual = Power.calcPow(2, -3);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calcZeroPow() {
        double expected = 1;
        double actual = Power.calcPow(2, 0);
        assertEquals(expected, actual, 0.0001);
    }

}