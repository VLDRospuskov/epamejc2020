package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ATMTest {
    ATM atm;

    @Before
    public void init() {
        atm = new ATM(1, new BankBalance());
    }

    @Test
    public void withdrawSmallValue() {
        BigDecimal money = new BigDecimal("10").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal startBalance = atm.getBalance();
        BigDecimal withdraw = atm.withdraw(money);
        assertEquals(startBalance.subtract(money), atm.getBalance());
        assertEquals(withdraw, money);
    }

    @Test
    public void withdrawBigValue() {
        BigDecimal money = new BigDecimal("1000000").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal startBalance = atm.getBalance();
        BigDecimal withdraw = atm.withdraw(money);
        assertEquals(startBalance, atm.getBalance());
        assertEquals(BigDecimal.ZERO, withdraw);
    }

    @Test
    public void deposit() {
        BigDecimal money = new BigDecimal("10").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal startBalance = atm.getBalance();
        atm.deposit(money);
        assertEquals(startBalance.add(money), atm.getBalance());
    }

    @Test
    public void encashmentAddMoneyFromBank() {
        BigDecimal money = new BigDecimal("1000").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal startBalance = atm.getBalance();
        atm.withdraw(money);
        atm.encashment();
        assertEquals(startBalance, atm.getBalance());
    }

    @Test
    public void encashmentSendMoneyToBank() {
        BigDecimal money = new BigDecimal("1000").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal startBalance = atm.getBalance();
        atm.deposit(money);
        atm.encashment();
        assertEquals(startBalance, atm.getBalance());
    }
}