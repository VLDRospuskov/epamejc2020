package main.homeworks.java.homework9;

import java.util.Random;

public class Client {

    private static int count;
    private final int id = count++;
    private int balance;
    private int walletMoney;
    private Bills[] bills = Bills.values();
    private Random rand = new Random();

    public Client() {
        balance = generateBalance();
        walletMoney = generateWalletMoney();
    }

    public int getBalance() {
        return balance;
    }

    public int getWalletMoney() {
        return walletMoney;
    }

    public void deposit(int amount) {
        synchronized (this) {
            if (balance < amount) {
                throw new NotEnoughMoneyException("Not enough money at " + this + " balance");
            }
            walletMoney += amount;
            balance -= amount;
        }
    }

    public void withdraw(int amount) {
        synchronized (this) {
            if (walletMoney < amount) {
                throw new NotEnoughMoneyException("Not enough money in " + this + " wallet");
            }
            walletMoney -= amount;
            balance += amount;
        }
    }

    public String toString() {
        return "Client " + id + " ";
    }

    private int generateBalance() {
        int balance = 0;
        for (Bills bill : bills) {
            balance += bill.getValue() * (rand.nextInt(50) + 1);
        }
        return balance;
    }

    private int generateWalletMoney() {
        return bills[rand.nextInt(bills.length)].getValue() * rand.nextInt(50);
    }
}
