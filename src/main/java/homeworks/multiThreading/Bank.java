package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static homeworks.multiThreading.ThreadController.locker;

@Data
@AllArgsConstructor
public class Bank {

    public String name;
    private volatile BigDecimal balance;
    public volatile boolean bankrupt;

    public void controlATM(List<ATM> atms, BigDecimal max, BigDecimal min) {

        locker.lock();

        for (ATM atm : atms) {
            BigDecimal atmBalance = atm.getBalance();

            if (atmBalance.compareTo(max) > 0) {

                System.out.println("Bank balance: " + balance);
                depositATM(atm, atmBalance, max);

            } else if (atmBalance.compareTo(min) <= 0) {

                System.out.println("Bank balance: " + balance);
                withdrawATM(atm, atmBalance, max);

            }
        }

        locker.unlock();
    }

    private void withdrawATM(ATM atm, BigDecimal atmBalance, BigDecimal max) {

        BigDecimal halfMax = max.divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);

        if (balance.compareTo(halfMax) > 0) {

            BigDecimal amount = halfMax.subtract(atmBalance);
            atm.setBalance(halfMax);
            setBalance(balance.subtract(amount));
            System.out.println(atm.getName() + " got " + amount + " from bank!\n");

        } else {
            System.out.println("Oops we are bankrupt!");
            bankrupt = true;
        }

    }

    private void depositATM(ATM atm, BigDecimal atmBalance, BigDecimal max) {

        BigDecimal halfMax = max.divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);

        BigDecimal amount = atmBalance.subtract(halfMax);
        atm.setBalance(halfMax);
        setBalance(balance.add(amount));
        System.out.println(atm.getName() + " gave " + amount + " to bank!\n");

    }
}
