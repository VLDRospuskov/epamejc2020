package homeworks.homework09;

import java.math.BigDecimal;

public class Incassation {

    public static boolean fillATM(ATM atm, BigDecimal value) {
        if (Balance.subtractFromBalance(value)) {
            return atm.addToBalance(value);
        } else {
            System.out.println("Incassation failed");
            return false;
        }
    }

    public static boolean freeATM(ATM atm, BigDecimal value) {
        atm.subtractFromBalance(value);
        if (!Balance.addToBalance(value)) {
            System.out.println("Incassation FAILED!");
            atm.addToBalance(value);
            return false;
        }
        return true;
    }

}
