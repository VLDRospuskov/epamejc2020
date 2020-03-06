package homework5.RecursionExponentiate;

import org.junit.Test;

import static org.junit.Assert.*;

public class recursionExponentialTest {

    @Test
    public void step() {
        recursionExponential recursionExponential = new recursionExponential();
        assertEquals(recursionExponential.step(3,4),81);
    }
}