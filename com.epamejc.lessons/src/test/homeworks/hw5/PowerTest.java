package test.homeworks.hw5;

import main.homeworks.hw5.Power;
import org.junit.*;

import static org.junit.Assert.*;

public class PowerTest {

    private static Power power;

    @Before
    public void setup() {
        power = new Power();
    }

    @Test
    public void testPower() {
        int expected1 = 25;
        int actual1 = power.powNum(5,2);
        assertEquals(expected1, actual1);
    }
}
