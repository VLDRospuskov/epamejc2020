package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ATM {

    public String name;
    private volatile BigDecimal balance;

    public void deposit(BigDecimal amount) {

        setBalance(balance.add(amount));
        System.out.println("Deposit to " + getName() + " " + amount + " balance " + getBalance());
    }

    public boolean withdraw(BigDecimal amount) {

        int compare = amount.compareTo(balance);
        boolean result;

        if (compare < 0) {
            setBalance(balance.subtract(amount));
            System.out.println("Withdraw from " + getName() + " " + amount + " balance " + getBalance());
            result = true;
        } else {
            System.out.println("Sorry, withdraw " + amount + " from " +
                    balance + " at " + getName() + " is not available!");
            result = false;
        }
        return result;
    }
}
