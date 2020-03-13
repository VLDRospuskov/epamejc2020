package homeworks.HW_9_multithreading.logic;

import homeworks.HW_9_multithreading.data.ATM;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.data.UnitedAccount.unitedAccount;

public class ATMLogic {

    public synchronized void withdraw(ATM atm, BigDecimal amount) {
        getFromUnitedAccountIfNeeded(atm, amount);
        subtract(atm, amount);
    }

    public synchronized void deposit(ATM atm, BigDecimal amount) {
        add(atm, amount);
        putIntoUnitedAccountIfNeeded(atm);
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
        atm.setBalance(atm.getBalance().add(amount));
    }

    private void add(ATM atm, BigDecimal amount) {
        atm.setBalance(atm.getBalance().add(amount));
    }

}
