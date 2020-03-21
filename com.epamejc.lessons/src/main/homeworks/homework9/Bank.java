package main.homeworks.homework9;

public class Bank {

    private static double bankBalance = 5_000_000.0;

    public static synchronized double get(double amount) {
        if (bankBalance >= amount) {
            System.out.println("Bank issued: " + amount);
            return amount;
        } else {
            System.out.println("Bank does not have enough funds.");
            System.out.println("Bank balance: " + bankBalance);
            return 0;
        }
    }

    public static synchronized void put(double amount) {
        System.out.println("Bank topped up the balance on: " + amount);
        System.out.println("Current balance: " + bankBalance);
        Bank.bankBalance += amount;
    }
}
