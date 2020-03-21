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

    public synchronized void deposit(double amount, Person person) {
        System.out.println("ATM " + macAddress + " balance: " + ATMBalance);
        if (person.getPersonBalance() >= amount) {
            person.setPersonBalance(person.getPersonBalance() - amount);
            ATMBalance += amount;
            System.out.println("Person " + person.getName() + " put " + amount);
            System.out.println("Current " + person.getName() + " balance: " + person.getPersonBalance());
            checkOverflow();
        } else {
            System.out.println("Person " + person.getName() + " does not put " + amount);
            System.out.println("Current " + person.getName() + " balance: " + person.getPersonBalance());
        }
        System.out.println("ATM " + macAddress + " balance: " + ATMBalance);
    }

    public synchronized void getAmount(double amount, Person person) {
        System.out.println("ATM " + macAddress + " balance: " + ATMBalance);
        checkShortage();
        if (ATMBalance >= amount) {
            ATMBalance -= amount;
            person.setPersonBalance(person.getPersonBalance() + amount);
            System.out.println("Person " + person.getName() + " get " + amount);
            System.out.println("Current " + person.getName() + " balance: " + person.getPersonBalance());
        } else {
            System.out.println("ATM " + macAddress + " does not have enough money.");
        }
        System.out.println("ATM " + macAddress + " balance: " + ATMBalance);
    }

    private synchronized void checkOverflow() {
        if (ATMBalance >= overflowAmount) {
            System.out.println("CheckOverflow: ATM " + macAddress + " balance: " + ATMBalance);
            ATMBalance -= amountExchange;
            Bank.put(amountExchange);
            System.out.println("ATM " + macAddress + " balance: " + ATMBalance);
        }
    }

    private synchronized void checkShortage() {
        if (ATMBalance <= lackAmount) {
            System.out.println("CheckShortage: ATM " + macAddress + " balance: " + ATMBalance);
            ATMBalance -= amountExchange;
            Bank.get(amountExchange);
            System.out.println("ATM " + macAddress + " balance: " + ATMBalance);
        }
    }

}
