package com.epamejc.lessons.src.homework.homework8.java8.functional_interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test
    public void fillFields() {
        String organizationName = "awsefdrgt";
        BankAccount ba = new BankAccount(organizationName);
        CoolBiFunction<String, String, Long> getLengthOfTwo =
                (first, second) -> (long) (first.length() + second.length());
        CoolSupplier<String> supplier = () -> "Donald";
        ba.fillFields(getLengthOfTwo, supplier);
        Long length = (long) (organizationName.length() + "Donald".length());
        assertEquals(length, ba.getId());
        assertEquals("Donald", ba.getOwner());
    }
}