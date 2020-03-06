package homework5.RecursionNumberCounting;

import org.junit.Test;

import static org.junit.Assert.*;

public class recursionNumberCountingTest {

    @Test
    public void numCounter() {
        recursionNumberCounting recursionNumberCounting = new recursionNumberCounting();
        assertEquals(recursionNumberCounting.numCounter(12345),5);
    }
}