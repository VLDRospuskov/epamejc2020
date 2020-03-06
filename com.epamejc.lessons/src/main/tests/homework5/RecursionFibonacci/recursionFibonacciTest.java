package homework5.RecursionFibonacci;

import org.junit.Test;

import static org.junit.Assert.*;

public class recursionFibonacciTest {

    @Test
    public void feb() {
        recursionFibonacci recursionFibonacci = new recursionFibonacci();
        assertEquals(recursionFibonacci.feb(10),55);
    }
}