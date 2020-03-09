package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class User {

    public String name;
    private double balance;
    public volatile boolean bankrupt;


    public boolean chooseRandomOperation() {
        return Math.random() > 0.5;
    }

    public double getRandomAmount() {
        return new Random().nextDouble() * balance;
    }

    public void setBalance(double amount, boolean success) {
        if (success) {
            System.out.println("User: " + name + " balance " + balance);
            balance = amount;
        } else {
            System.out.println(name + " couldn't get " + amount);
        }
    }
}
