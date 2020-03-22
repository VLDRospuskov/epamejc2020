package homework.homework9.atm;

import homework.homework9.util.Log;
import lombok.Getter;
import org.apache.commons.math3.util.Precision;

public class Account {
    @Getter
    volatile private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(AutomatedTellerMachine atm, double sum) {
        Log.log("ATM " + atm.getId() + " waits for account");
        synchronized (this) {
            Log.log("ATM " + atm.getId() + " got account and wants to deposit " + Precision.round(sum,2));
            balance += sum;
            Log.log("Success. General account balance " + Precision.round(balance, 2));
        }
    }

    public void withdraw(AutomatedTellerMachine atm, double sum) {
        Log.log("ATM " + atm.getId() + " waits for account");
        synchronized (this) {
            Log.log("ATM " + atm.getId() + " got account and wants to withdraw " + Precision.round(sum,2));
            if (balance >= sum) {
                balance -= sum;
                Log.log("Success. General account balance " + Precision.round(balance, 2));
            } else {
                throw new IllegalStateException("ATM " + atm.getId() + " doesn't have enough money");
            }
        }
    }
}
