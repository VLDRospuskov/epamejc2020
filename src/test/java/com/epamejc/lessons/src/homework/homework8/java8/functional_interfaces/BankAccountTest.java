package com.epamejc.lessons.src.homework.homework8.java8.functional_interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {

    @Test
    public void fillFields() {
        String organizationName = "awsefdrgt";
        BankAccount ba = new BankAccount(organizationName);
        CoolBiFunction<String, String, Long> getLengthOfTwo =
                (first, second) -> new Long(first.length() + second.length());
        CoolSupplier<String> supplier = () -> "Donald";
        ba.fillFields(getLengthOfTwo, supplier);
        Long length = Long.valueOf(organizationName.length() + "Donald".length());
        assertEquals(length, ba.getId());
        assertTrue(ba.getOwner().equals("Donald"));
    }
}