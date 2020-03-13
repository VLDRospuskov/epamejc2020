package homeworks.HW_9_multithreading.logic;

import homeworks.HW_9_multithreading.data.ATM;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.data.UnitedAccount.unitedAccount;
import static homeworks.HW_9_multithreading.data.Counter.*;

public class ATMLogic {

    public void withdraw(ATM atm, BigDecimal amount) {
        getFromUnitedAccountIfNeeded(atm, amount);
        subtract(atm, amount);
    }

    public void deposit(ATM atm, BigDecimal amount) {
        add(atm, amount);
        putIntoUnitedAccountIfNeeded(atm);
    }

    public boolean hasCash(ATM atm, BigDecimal amount) {
        boolean result = atm.getBalance().add(unitedAccount).subtract(amount).compareTo(BigDecimal.ZERO) > 0;

        if (!result) {
            System.out.println("\033[1;91m" + "UnitedAccount doesn't have enough cash!" + "\u001B[0m");
            declinedATM++;
        }

        return result;
    }

    private void getFromUnitedAccountIfNeeded(ATM atm, BigDecimal amount) {
        while (atm.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) <= 0) {
            unitedAccount = unitedAccount.subtract(BigDecimal.valueOf(5000.00));
            atm.setBalance(atm.getBalance().add(BigDecimal.valueOf(5000.00)));
            System.out.println("ATM on " + atm.getLocation() + " got $5,000.0 from the Bank");
        }
    }

    private void putIntoUnitedAccountIfNeeded(ATM atm) {
        while (atm.getBalance().doubleValue() >= 30000.00) {
            atm.setBalance(atm.getBalance().subtract(BigDecimal.valueOf(5000.00)));
            unitedAccount = unitedAccount.add(BigDecimal.valueOf(5000.00));
            System.out.println("ATM on " + atm.getLocation() + " transferred $5,000.0 to the Bank");
        }
    }

    private void subtract(ATM atm, BigDecimal amount) {
        atm.setBalance(atm.getBalance().subtract(amount));
    }

    private void add(ATM atm, BigDecimal amount) {
        atm.setBalance(atm.getBalance().add(amount));
    }
}