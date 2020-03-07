package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AtmOperationsTest {
    BankBalance bb;
    ATM atm;
    Person person;

    @Before
    public void setUp() {
        bb = new BankBalance();
        atm = new ATM(1, bb);
        person = new Person("Maria", BigDecimal.valueOf(10_000));
    }

    @Test
    public void withdrawRandom() {
        BigDecimal personBalance = person.getBalance();
        BigDecimal atmBalance = atm.getBalance();
        AtmOperations.withdrawRandom(person, atm);
        BigDecimal withdraw = person.getBalance().subtract(personBalance);
        assertEquals(atmBalance.subtract(withdraw), atm.getBalance());
    }

    @Test
    public void depositRandom() {
        BigDecimal personBalance = person.getBalance();
        BigDecimal atmBalance = atm.getBalance();
        AtmOperations.depositRandom(person, atm);
        BigDecimal deposit = personBalance.subtract(person.getBalance());
        assertEquals(atmBalance.add(deposit), atm.getBalance());
    }

    @Test
    public void encashment() {
        BigDecimal atmBalance = atm.getBalance();
        atm.withdraw(new BigDecimal("10000"));
        AtmOperations.encashment(atm);
        assertEquals(atmBalance, atm.getBalance());
    }
}