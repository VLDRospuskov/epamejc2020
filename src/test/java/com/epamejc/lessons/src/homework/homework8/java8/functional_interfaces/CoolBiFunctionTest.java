package com.epamejc.lessons.src.homework.homework8.java8.functional_interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoolBiFunctionTest {

    @Test
    public void applySumUpValues() {
        CoolBiFunction<Integer, Integer, Integer> sum = Integer::sum;
        Integer res = sum.apply(1, 2);
        assertEquals(new Integer(3), res);
    }

    @Test
    public void applyReturnBiggerValue() {
        CoolBiFunction<Integer, Integer, Integer> sum = Math::max;
        Integer res = sum.apply(1, 10);
        assertEquals(new Integer(10), res);
    }
}