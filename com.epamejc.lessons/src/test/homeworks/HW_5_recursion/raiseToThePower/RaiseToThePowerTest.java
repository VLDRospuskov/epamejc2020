package homeworks.HW_5_recursion.raiseToThePower;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class RaiseToThePowerTest {

    @Test
    public void testGetPowerOfNumber() {
        int actual = RaiseToThePower.getPowerOfNumber(3, 2);
        int expected = 9;
        assertEquals(actual, expected);
    }
}