package Homeworks.HW3.Task2Arrays;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class T21TwoDimensionalTest {

    @Test
    public void print2dArray() {
        int a = 2;
        int b = 2;
        T21TwoDimensional t21 = new T21TwoDimensional();
        String result = t21.twoDArray(2, 2);
        int expected = a * b;
        Scanner scanner = new Scanner(result);
        int actual = 0;
        while (scanner.hasNext()) {
            if (scanner.next().length() == 1) {
                actual++;
            }
        }
        scanner.close();
        assertEquals(actual, expected);
    }
}