package homework.homework9.atm;

import homework.homework9.util.Log;
import org.apache.commons.math3.util.Precision;

public class Account {
    volatile private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(AutomatedTellerMachine atm, double sum) {
        Log.log("ATM " + atm.getId() + " waits for account");
        synchronized (this) {
            Log.log("ATM " + atm.getId() + " got account and wants to deposit " + sum);
            balance += sum;
            Log.log("Success. General account balance " + Precision.round(balance, 2));
        }
    }

    public void withdraw(AutomatedTellerMachine atm, double sum) {
        Log.log("ATM " + atm.getId() + " waits for account");
        synchronized (this) {
            Log.log("ATM " + atm.getId() + " got account and wants to withdraw " + sum);
            if (balance >= sum) {
                balance -= sum;
                Log.log("Success. General account balance " + Precision.round(balance, 2));
            } else {
                throw new IllegalStateException("ATM " + atm.getId() + " doesn't have enough money");
            }
        }
    }
}
