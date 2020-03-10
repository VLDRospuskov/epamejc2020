package homeworks.HW_9_multithreading;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ATMOperations {

    public static String format(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
    }

    public static void withdraw (User user, ATM atm, BigDecimal amount) {
        if (user.getCash(amount)) {
            atm.withdraw(amount);
        }
    }

    public static void put (User user, ATM atm, BigDecimal amount) {
        if (user.putCash(amount)) {
            atm.deposit(amount);
        }
    }

}
