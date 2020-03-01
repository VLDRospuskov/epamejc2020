package lessons.lesson19.example3;

import lombok.Data;

@Data
public class ATM {

    //private BankAccount balance;
    private int balance;
    private int ATMindex;

    public ATM(int balance, int index) {
        balance = balance;
        this.ATMindex = index;
    }

    public synchronized void deposit(int amount) {
        balance = balance + amount;
        //balance += amount;
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
