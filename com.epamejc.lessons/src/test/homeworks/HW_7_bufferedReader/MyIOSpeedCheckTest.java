package homeworks.HW_7_bufferedReader;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyIOSpeedCheckTest {

    @Test
    public void checkExecutionTimeBuffered() {
        long expected = 1500;
        long actual = new MyIOSpeedCheck().checkExecutionTimeBuffered();
        boolean condition = Math.abs(actual - expected) < 1000;
        assertTrue(condition);
    }

    @Test
    public void checkExecutionTimeNotBuffered() {
        long expected = 4500;
        long actual = new MyIOSpeedCheck().checkExecutionTimeNotBuffered();
        boolean condition = Math.abs(actual - expected) < 1000;
        assertTrue(condition);
    }
}