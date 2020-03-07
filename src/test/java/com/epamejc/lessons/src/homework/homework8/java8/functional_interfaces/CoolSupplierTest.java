package com.epamejc.lessons.src.homework.homework8.java8.functional_interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoolSupplierTest {

    @Test
    public void getIntegerValue() {
        Integer value = 10;
        CoolSupplier<Integer> supplier = () -> value;
        assertEquals(value, supplier.get());
    }

    @Test
    public void getStringValue() {
        String value = "Hey yo";
        CoolSupplier<String> supplier = () -> value;
        assertEquals(value, supplier.get());
    }
}