package lessons.java.lesson19.example3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ATM {

    private int balance;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("User name: " + Thread.currentThread().getName() + " deposit: " + amount);
        System.out.println("ATM balance: " + getBalance());
    }

    public void withdraw(int amount) {
        synchronized (this) {
            balance -= amount;
            System.out.println("User name: " + Thread.currentThread().getName() + " withdraw: " + amount);
            System.out.println("ATM balance: " + getBalance());
        }
    }

}
