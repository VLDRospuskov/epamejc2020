package main.homeworks.java.homework5.recursion.task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerTest {

    private Power power = new Power();

    @Test
    public void TestPow() {
        int[] expected = { 1, 5, 225, 27000, 83521, 243, 46656 };
        int[] cases = { 111, 5, 15, 30, 17, 3, 6 };
        int[] actual = new int[cases.length];
        for (int i = 0; i < cases.length; i++) {
            actual[i] = power.pow(cases[i], i);
        }

        assertArrayEquals(expected, actual);
    }
}