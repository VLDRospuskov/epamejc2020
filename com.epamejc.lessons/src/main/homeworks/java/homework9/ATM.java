package main.homeworks.java.homework9;

import java.util.Random;

public class ATM {

    private static int count = 0;
    private final int id = count++;
    private int balance;
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
        balance = getFromBank();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        synchronized (this) {
            balance += amount;
        }
    }

    public void withdraw(int amount) {
        synchronized (this) {
            if (amount > balance) {
                throw new NotEnoughMoneyException("Not enough money in " + this);
            }
            balance -= amount;
            balance = getFromBank();
        }
    }

    public String toString() {
        return "ATM " + id + " ";
    }

    private synchronized int getFromBank() {
        Random rand = new Random();
        if (this.balance == 0) {
            int balance = 0;
            for (Bills bill : Bills.values()) {
                balance += bill.getValue() * (rand.nextInt(100) + 1);
            }
            if (balance < bank.getBalance()) {
                bank.withdraw(balance);
                return balance;
            }
        }
        return getBalance();
    }

}
