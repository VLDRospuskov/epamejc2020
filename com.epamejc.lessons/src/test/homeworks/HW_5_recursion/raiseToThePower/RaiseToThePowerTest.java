package homeworks.HW_5_recursion.raiseToThePower;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class RaiseToThePowerTest {

    @Test
    public void testGetPowerOfNumber() {
        int expected = 9;
        int actual = RaiseToThePower.getPowerOfNumber(3, 2);
        assertEquals(expected, actual);

        expected = 32;
        actual = RaiseToThePower.getPowerOfNumber(2, 5);
        assertEquals(expected, actual);
    }
}