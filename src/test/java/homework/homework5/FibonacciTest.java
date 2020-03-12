package homework.homework5;

import homework.homework5.recursion.Fibonacci;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void getFibonacci() {
        int[] fibbonacciSequence = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        for(int i = 0; i < fibbonacciSequence.length; i++){
            assertEquals(fibbonacciSequence[i], Fibonacci.getFibonacci(i));
        }
    }
}