package homeworks.HW_9_multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.ATMOperations.format;

@Data
@AllArgsConstructor
public class User {

    private BigDecimal cashBalance;
    private BigDecimal accountBalance;
    private String firstName;
    private String lastName;

    public boolean getCash(BigDecimal amount) {
        BigDecimal temp = accountBalance.subtract(amount);
        if (temp.doubleValue() > 0) {
            cashBalance = cashBalance.add(amount);
            accountBalance = accountBalance.subtract(amount);
            System.out.println(lastName + " " + firstName + " withdrew " + format(amount) + " from his account.");
            System.out.println("Current status - cash: " + format(cashBalance) +
                    ", account: " + format(accountBalance));
            return true;
        } else {
            System.out.println(lastName + " " + firstName + " doesn't have enough money on account to withdraw! " +
                    "Operation terminated!");
            System.out.println("Current status - cash: " + format(cashBalance) +
                    ", account: " + format(accountBalance));
            return false;
        }
    }

    public boolean putCash(BigDecimal amount) {
        BigDecimal temp = cashBalance.subtract(amount);
        if (temp.doubleValue() > 0) {
            cashBalance = cashBalance.subtract(amount);
            accountBalance = accountBalance.add(amount);
            System.out.println(lastName + " " + firstName + " deposited " + format(amount) + " on his account.");
            System.out.println("Current status - cash: " + format(cashBalance) +
                    ", account: " + format(accountBalance));
            return true;
        } else {
            System.out.println(lastName + " " + firstName + " doesn't have enough cash to put on his account! " +
                    "Operation terminated!");
            System.out.println("Current status - cash: " + format(cashBalance) +
                    ", account: " + format(accountBalance));
            return false;
        }
    }



}
