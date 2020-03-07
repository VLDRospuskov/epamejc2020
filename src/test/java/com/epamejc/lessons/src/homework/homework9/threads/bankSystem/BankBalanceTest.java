package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BankBalanceTest {
    BankBalance bb;

    @Before
    public void init() {
        bb = new BankBalance();
    }

    @Test
    public void withdrawSmall() {
        BigDecimal money = new BigDecimal("10").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal startBalance = bb.getBalance();
        BigDecimal withdraw = bb.withdraw(money);
        assertEquals(startBalance.subtract(money), bb.getBalance());
        assertEquals(withdraw, money);
    }

    @Test
    public void withdrawBigValue() {
        BigDecimal money = new BigDecimal("50000000.0").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal withdraw = bb.withdraw(money);
        assertEquals(BigDecimal.ZERO, withdraw);
    }

    @Test
    public void deposit() {
        BigDecimal money = new BigDecimal("10").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal startBalance = bb.getBalance();
        bb.deposit(money);
        assertEquals(startBalance.add(money), bb.getBalance());
    }
}