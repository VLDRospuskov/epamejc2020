package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ATM {

    public String name;
    private double balance;

    public void deposit(double amount) {

        synchronized (ThreadController.lock) {
            balance += amount;
            System.out.println("Deposit to " + getName() + " " + amount + " balance " + getBalance());
        }
    }

    public void withdraw(double amount) {

        synchronized (ThreadController.lock) {
            if (amount < balance) {
                balance -= amount;
                System.out.println("Withdraw from " + getName() + " " + amount + " balance " + getBalance());
            } else {
                System.out.println("Sorry, withdraw " + amount + " from " +
                        balance + " at " + getName() + " is not available!");
            }
            balance -= amount;
        }
    }
}
