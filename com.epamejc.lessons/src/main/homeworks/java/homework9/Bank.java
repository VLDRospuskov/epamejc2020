package main.homeworks.java.homework9;

import java.util.Random;

public class Bank {

    private int balance;

    public Bank() {
        balance = generateBalance();
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            throw new NotEnoughMoneyException("Bank is out of money");
        }
        balance -= amount;
    }

    private int generateBalance() {
        Random rand = new Random();
        int balance = 0;
        for (Bills bill : Bills.values()) {
            balance += bill.getValue() * (rand.nextInt(10000) + 1);
        }
        return balance;
    }

}
