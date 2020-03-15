package homeworks.homework09;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class Balance {
    @Setter
    private static BigDecimal balance = BigDecimal.valueOf(0);

    public static synchronized boolean addToBalance(BigDecimal value) {
        balance = balance.add(value);
        return true;
    }

    public static synchronized boolean subtractFromBalance(BigDecimal value) {
        if (balance.compareTo(value) < 0) {
            System.out.println("Not enough money on balance!!!");
            return false;
        }
        balance = balance.add(value.negate());
        return true;
    }

    public static synchronized BigDecimal getBalance() {
        return balance;
    }

}
