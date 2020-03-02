package test.homeworks.homework5.power;

import main.homeworks.homework5.power.Pow;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowTest {

    private static Pow pow;

    @Before
    public void initialization() {
        pow = new Pow();
    }

    @Test
    public void testPowInt() {
        int actual1 = pow.powerInt(3,8);
        int actual2 = pow.powerInt(14,2);
        int actual3 = pow.powerInt(-5,3);
        int expected1 = 6561;
        int expected2 = 196;
        int expected3 = -125;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
}