package main.homeworks.java.homework5.recursion.task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigitsTest {

    Digits digits = new Digits();

    @Test
    public void TestNumDigits() {
        int cases[] = { 123456, 1, 25, 777, 1337, 98364 };
        int[] expected = { 6, 1, 2, 3, 4, 5 };
        int[] actual = new int[cases.length];
        for (int i = 0; i < cases.length; i++) {
            actual[i] = digits.numDigits(cases[i]);
        }

        assertArrayEquals(expected, actual);
    }
}