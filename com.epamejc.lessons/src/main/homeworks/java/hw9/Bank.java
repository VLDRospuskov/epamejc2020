package homeworks.java.hw9;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank {

    private volatile double balance;

    public synchronized void collect(double amount) {
        balance += amount;
    }

    public synchronized void fill(double amount) {
        balance -= amount;
    }

}
