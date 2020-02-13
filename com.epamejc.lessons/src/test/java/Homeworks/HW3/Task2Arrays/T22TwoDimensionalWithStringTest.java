package Homeworks.HW3.Task2Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class T22TwoDimensionalWithStringTest {

    @Test
    public void strategy() {
        int a = 3;
        int b = 3;
        boolean sA = true;
        boolean sB = false;
        T22TwoDimensionalWithString t22 = new T22TwoDimensionalWithString();
        String actual = t22.strategy(a, b, sA, sB);

    }
}