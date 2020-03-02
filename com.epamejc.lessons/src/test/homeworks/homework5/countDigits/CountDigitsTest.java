package test.homeworks.homework5.countDigits;

import main.homeworks.homework5.countDigits.CountDigits;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CountDigitsTest {

    private static CountDigits countDigits;

    @Before
    public void initialization() {
        countDigits = new CountDigits();
    }

    @Test
    public void testCount() {
        int actual1 = countDigits.count(251);
        int actual2= countDigits.count(1893000);
        int actual3= countDigits.count(-1);
        int expected1 = 3;
        int expected2 = 7;
        int expected3 = 1;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
}
