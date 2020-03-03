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


    public boolean chooseRandomOperation () {
        return new Random().nextInt() > 0;
    }

    public double getRandomAmount() {
        return new Random().nextDouble() * balance;
    }

    public void setBalance (double amount) {
        synchronized (ThreadController.lock) {
            balance = amount;
            System.out.println("User: " + name + " balance " + balance);
        }
    }
}
