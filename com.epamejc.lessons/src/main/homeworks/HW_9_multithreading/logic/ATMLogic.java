package homeworks.HW_9_multithreading.logic;

import homeworks.HW_9_multithreading.data.ATM;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.data.UnitedAccount.unitedAccount;
import static homeworks.HW_9_multithreading.data.Counter.*;

@Data
@AllArgsConstructor
public class ATMLogic {

    private ATM atm;
    private BigDecimal amount;

    public void withdraw() {
        getFromUnitedAccountIfNeeded();
        subtract();
    }

    public void deposit() {
        add();
        putIntoUnitedAccountIfNeeded();
    }

    public boolean hasCash() {
        boolean result = atm.getBalance().add(unitedAccount).subtract(amount).compareTo(BigDecimal.ZERO) > 0;

        if (!result) {
            System.out.println("\033[1;91m" + "UnitedAccount doesn't have enough cash!" + "\u001B[0m");
            declinedATM++;
        }

        return result;
    }

    private void getFromUnitedAccountIfNeeded() {
        while (atm.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) <= 0) {
            unitedAccount = unitedAccount.subtract(BigDecimal.valueOf(5000.00));
            atm.setBalance(atm.getBalance().add(BigDecimal.valueOf(5000.00)));
            System.out.println("ATM on " + atm.getLocation() + " got $5,000.0 from the Bank");
        }
    }

    private void putIntoUnitedAccountIfNeeded() {
        while (atm.getBalance().doubleValue() >= 30000.00) {
            atm.setBalance(atm.getBalance().subtract(BigDecimal.valueOf(5000.00)));
            unitedAccount = unitedAccount.add(BigDecimal.valueOf(5000.00));
            System.out.println("ATM on " + atm.getLocation() + " transferred $5,000.0 to the Bank");
        }
    }

    private void subtract() {
        atm.setBalance(atm.getBalance().subtract(amount));
    }

    private void add() {
        atm.setBalance(atm.getBalance().add(amount));
    }
}