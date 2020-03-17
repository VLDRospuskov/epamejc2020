package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;

import java.math.BigDecimal;

public class BankBalance {
    private BigDecimal balance = new BigDecimal("10000000.0").setScale(2, BigDecimal.ROUND_HALF_DOWN);

    public synchronized BigDecimal withdraw(BigDecimal money) {
        if (money.compareTo(balance) <= 0) {
            balance = balance.subtract(money);
            System.out.println("Withdrawal occurred. Bank balance: " + balance);
            return money;
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    public synchronized void deposit(BigDecimal money) {
        balance = balance.add(money);
        System.out.println("Deposit occurred. Bank balance: " + balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
