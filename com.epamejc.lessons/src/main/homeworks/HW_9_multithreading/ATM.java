package homeworks.HW_9_multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.ATMOperations.format;
import static homeworks.HW_9_multithreading.BankAccount.bankAccount;

@Data
@AllArgsConstructor
public class ATM {

    private BigDecimal balance;
    private String location;

    public synchronized void withdraw(BigDecimal amount) {
        BigDecimal temp = balance.subtract(amount);
        while (temp.compareTo(BigDecimal.ZERO) <= 0) {
            balance = balance.add(BigDecimal.valueOf(5000.00));
            bankAccount = bankAccount.subtract(BigDecimal.valueOf(5000.00));
            temp = balance.subtract(amount);
            System.out.println("ATM on " + location + " transferred $5,000.0 from the Bank");
        }

        balance = balance.subtract(amount);
        System.out.println("Withdrawal " + format(amount) + " from ATM on " + location);
        System.out.println("Current ATM status: " + format(balance));
    }

    public synchronized void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println("Depositing " + format(amount) + " to ATM on " + location);
        System.out.println("Current ATM status: " + format(balance));

        while (balance.doubleValue() >= 30000.00) {
            balance = balance.subtract(BigDecimal.valueOf(5000.00));
            bankAccount = bankAccount.add(BigDecimal.valueOf(5000.00));
            System.out.println("ATM on " + location + " transferred $5,000.0 to the Bank");
        }
    }

}
