package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;

import java.math.BigDecimal;

public class ATM {
    private final BankBalance bankBalance;
    private final int id;
    private final BigDecimal RECOMMENDED_BALANCE =
            new BigDecimal("50000.0").setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private BigDecimal balance = new BigDecimal("50000.0").setScale(2, BigDecimal.ROUND_HALF_DOWN);

    public ATM(int id, BankBalance bankBalance) {
        this.bankBalance = bankBalance;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public synchronized BigDecimal withdraw(BigDecimal money) {
        if (money.compareTo(balance) <= 0) {
            balance = balance.subtract(money);
            System.out.println("ATM " + id + " withdraw:" + money);
            System.out.println("ATM " + id + " balance:" + balance);
            return money;
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    public synchronized void deposit(BigDecimal money) {
        System.out.println("ATM " + id + " deposit:" + money);
        balance = balance.add(money);
        System.out.println("ATM " + id + " balance:" + balance);
    }

    public synchronized void encashment() {
        System.out.println("ATM " + id + " encashment.");
        if (RECOMMENDED_BALANCE.compareTo(balance) < 0) {
            sendMoneyToBank();
        } else if (RECOMMENDED_BALANCE.compareTo(balance) > 0) {
            requestMoneyFromBank();
        }
        System.out.println("ATM " + id + " balance:" + balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }


    private void sendMoneyToBank() {
        BigDecimal surplus = balance.subtract(RECOMMENDED_BALANCE);
        if (surplus.compareTo(BigDecimal.valueOf(0)) > 0) {
            bankBalance.deposit(surplus);
            balance = balance.subtract(surplus);
        }
    }

    private void requestMoneyFromBank() {
        BigDecimal lack = RECOMMENDED_BALANCE.subtract(balance);
        if (lack.compareTo(BigDecimal.valueOf(0)) > 0) {
            BigDecimal allowedLack = bankBalance.withdraw(lack);
            balance = balance.add(allowedLack);
        }
    }
}
