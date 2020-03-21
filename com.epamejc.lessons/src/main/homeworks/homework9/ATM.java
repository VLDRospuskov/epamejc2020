package main.homeworks.homework9;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ATM {

    private String macAddress;
    private double ATMBalance;
    private static final double overflowAmount = 500_000.0;
    private static final double lackAmount = 50_000.0;
    private static final double amountExchange = 100_000.0;

    public synchronized boolean deposit(double amount, Person person) {
        if (person.getPersonBalance() >= amount) {
            person.setPersonBalance(person.getPersonBalance() - amount);
            ATMBalance += amount;
            System.out.println("Person " + person.getName() + " put " + amount);
            System.out.println("Current " + person.getName() + " balance: " + person.getPersonBalance());
            checkOverflow();
            return true;
        } else {
            System.out.println("Person " + person.getName() + " does not put " + amount);
            System.out.println("Current " + person.getName() + " balance: " + person.getPersonBalance());
            return false;
        }
    }

    public synchronized boolean getAmount(double amount, Person person) {
        checkShortage();
        if (ATMBalance >= amount) {
            ATMBalance -= amount;
            person.setPersonBalance(person.getPersonBalance() + amount);
            System.out.println("Person " + person.getName() + " get " + amount);
            System.out.println("Current " + person.getName() + " balance: " + person.getPersonBalance());
            return true;
        } else {
            System.out.println("Person " + person.getName() + " does not get " + amount);
            System.out.println("Current " + person.getName() + " balance: " + person.getPersonBalance());
            return false;
        }
    }

    private synchronized void checkOverflow() {
        if (ATMBalance >= overflowAmount) {
            ATMBalance -= amountExchange;
            Bank.put(amountExchange);
        }
    }

    private synchronized void checkShortage() {
        if (ATMBalance <= lackAmount) {
            Bank.get(amountExchange);
        }
    }

}
