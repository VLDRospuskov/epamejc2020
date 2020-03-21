package Homeworks.HW9.Bank;

import lombok.SneakyThrows;
import lombok.ToString;

@ToString
public class ATM {

    private final Object atmLock = new Object();
    private final int atmOperationTime = 1000;

    int id;
    int balance;

    @SneakyThrows
    public ATM(int id, int balance) {
        Thread.sleep(atmOperationTime);
        this.id = id;
        this.balance = balance;
        System.out.println("Created new ATM with id " + id + " and balance " + balance);
    }

    public int deposit(int amount) {
        this.balance += amount;
        return amount;
    }

    @SneakyThrows
    public int withdraw(int amount) throws ATMException {
        synchronized (atmLock) {
            Thread.sleep(atmOperationTime);
            if (this.balance >= amount) {
                this.balance -= amount;
                return amount;
            } else {
                throw new ATMException("ATM " + this.id + " don't have enough amount on it's balance!");
            }
        }
    }

    @SneakyThrows
    private void service(int amount) {
        synchronized (atmLock) {
            System.out.println("ATM " + id + " is temporary out of service!");
            Thread.sleep(atmOperationTime);
            balance = balance + amount;
            System.out.println("ATM " + id + " is back to work.");
        }
    }

}

class ATMException extends Exception {

    public ATMException(String message) {
        super(message);
    }
}