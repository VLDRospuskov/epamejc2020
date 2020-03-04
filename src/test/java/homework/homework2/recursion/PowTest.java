package homework.homework2.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowTest {

    @Test
    public void getPow() {
        assertEquals(Math.pow(3, 3), Pow.getPow(3,3), 1e-5);
        assertEquals(Math.pow(3.2, 5), Pow.getPow(3.2,5), 1e-5);
        assertEquals(Math.pow(6.3, 7), Pow.getPow(6.3,7), 1e-5);
        assertEquals(Math.pow(7.8, 9), Pow.getPow(7.8,9), 1e-5);
        assertEquals(Math.pow(10.1, 2), Pow.getPow(10.1,2), 1e-5);
        assertEquals(Math.pow(1, 4), Pow.getPow(1,4), 1e-5);
        assertEquals(Math.pow(0, 6), Pow.getPow(0,6), 1e-5);
    }
}