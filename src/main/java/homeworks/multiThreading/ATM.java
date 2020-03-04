package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ATM {

    public String name;
    private double balance;

    public void deposit(double amount) {

        balance += amount;
        System.out.println("Deposit to " + getName() + " " + amount + " balance " + getBalance());

    }

    public boolean withdraw(double amount) {

        if (amount < balance) {
            balance -= amount;
            System.out.println("Withdraw from " + getName() + " " + amount + " balance " + getBalance());
            return true;
        } else {
            System.out.println("Sorry, withdraw " + amount + " from " +
                    balance + " at " + getName() + " is not available!");
            return false;
        }

    }
}
