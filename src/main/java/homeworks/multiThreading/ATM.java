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
            System.out.println("Atm: " + getName() + " balance " + getBalance());
        }
    }

    public void withdraw(double amount) {

        synchronized (ThreadController.lock) {
            if (amount < balance) {
                balance -= amount;
                System.out.println("Atm: " + getName() + " balance " + getBalance());
            } else {
                System.out.println("Sorry, operation is not available!");
            }
            balance -= amount;
        }
    }
}
