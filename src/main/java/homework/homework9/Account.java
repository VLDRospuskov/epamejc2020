package homework.homework9;

import org.apache.commons.math3.util.Precision;

public class Account {
    volatile private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(AutomatedTellerMachine atm, double sum) {
        System.out.println("ATM " + atm.getId() + " waits for account");
        synchronized (this) {
            System.out.println("ATM " + atm.getId() + " got account and wants to deposit " + sum);
            balance += sum;
            System.out.println("Success. General account balance " + Precision.round(balance, 2));
        }
    }

    public void withdraw(AutomatedTellerMachine atm, double sum) {
        System.out.println("ATM " + atm.getId() + " waits for account");
        synchronized (this) {
            System.out.println("ATM " + atm.getId() + " got account and wants to withdraw " + sum);
            if (balance >= sum) {
                balance -= sum;
                System.out.println("Success. General account balance " + Precision.round(balance, 2));
            } else {
                throw new IllegalStateException("ATM " + atm.getId() + " doesn't have enough money");
            }
        }
    }
}
