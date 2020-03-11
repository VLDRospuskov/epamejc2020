package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Random;

@Data
@AllArgsConstructor
public class User {

    public String name;
    private volatile BigDecimal balance;
    public volatile boolean bankrupt;

    public boolean chooseRandomOperation() {
        return Math.random() > 0.5;
    }

    public BigDecimal getRandomAmount() {

        BigDecimal result;
        if (balance.compareTo(BigDecimal.valueOf(0)) > 0) {
            result = new BigDecimal(String.valueOf(new Random().nextDouble())).multiply(balance);
        } else {
            result = new BigDecimal(0);
        }
        return result;
    }

    public void setBalance(BigDecimal amount, boolean success) {
        if (success) {
            setBalance(amount);
            System.out.println("User: " + name + " balance " + balance);
        } else {
            System.out.println(name + " couldn't get " + amount);
        }
    }
}
