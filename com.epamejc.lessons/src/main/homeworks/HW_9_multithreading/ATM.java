package homeworks.HW_9_multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.ATMOperations.format;

@Data
@AllArgsConstructor
public class ATM {

    private BigDecimal balance;
    private String location;

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
        System.out.println("Withdrawal " + format(amount) + " from ATM on " + location);
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println("Depositing " + format(amount) + " to ATM on " + location);
    }

}
