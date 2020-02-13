package homeworks.java.hw3.arrays_2;

import org.junit.*;
import static org.junit.Assert.*;

public class StrategyTest {
    private Strategy s;

    @Before
    public void setup() {
        s = new Strategy();
    }

    @Test
    public void checkStrategyTest() {
        boolean expectedTrue = true;
        boolean expectedFalse = false;
        String strategyTrue = "error";
        String strategyFalse = "A";
        boolean actualTrue = s.checkStrategy(strategyTrue);
        boolean actualFalse = s.checkStrategy(strategyFalse);
        assertEquals(expectedTrue, actualTrue);
        assertEquals(expectedFalse, actualFalse);
    }
}
