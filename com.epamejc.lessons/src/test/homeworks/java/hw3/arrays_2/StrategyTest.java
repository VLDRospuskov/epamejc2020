package homeworks.java.hw3.arrays_2;

import org.junit.*;
import static org.junit.Assert.*;

public class StrategyTest {

    private Strategy strategy;

    @Before
    public void setup() {
        strategy = new Strategy();
    }

    @Test
    public void checkStrategyTest() {
        boolean expectedTrue = true;
        boolean expectedFalse = false;
        String strategyTrue = "error";
        String strategyFalse = "A";
        boolean actualTrue = strategy.checkStrategy(strategyTrue);
        boolean actualFalse = strategy.checkStrategy(strategyFalse);
        assertEquals(expectedTrue, actualTrue);
        assertEquals(expectedFalse, actualFalse);
    }
}
