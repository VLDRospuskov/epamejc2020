package homeworks.homework09;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ATM {
    public int id;
    BigDecimal atmBalance = BigDecimal.ZERO;
    final static int MAXIMUM_BALANCE = 300_000;
    final static int MINIMUM_BALANCE = 50_000;

    public ATM(int id) {
        this.id = id;
    }

    public boolean addToBalance(BigDecimal value) {
        System.out.print(getIdColumnForPrint() + "ATM №" + id + " balance changes from " + atmBalance.setScale(3, RoundingMode.HALF_UP));

        atmBalance = atmBalance.add(value);
        if (atmBalance.compareTo(BigDecimal.valueOf(MAXIMUM_BALANCE)) > 0) {
            System.out.println(getIdColumnForPrint() + "ATM №" + id + " calls incassation!");
            Incassation.freeATM(this, BigDecimal.valueOf(100_000));
            return true;
        }

        System.out.println(" to " + atmBalance.setScale(3, RoundingMode.HALF_UP));
        return true;
    }

    public boolean subtractFromBalance(BigDecimal value) {
        System.out.print(getIdColumnForPrint() + "ATM №" + id + " balance changes from " + atmBalance.setScale(3, RoundingMode.HALF_UP));

        if (atmBalance.compareTo(value) < 0) {
            System.out.println("Not enough money on ATM balance!!!");
            return false;
        }
        atmBalance = atmBalance.add(value.negate());

        if (atmBalance.compareTo(BigDecimal.valueOf(MINIMUM_BALANCE)) < 0) {
            System.out.println(" ATM №" + id + " calls incassation! ");
            Incassation.fillATM(this, BigDecimal.valueOf(100_000));
            return true;
        }

        System.out.println(" to " + atmBalance.setScale(3, RoundingMode.HALF_UP));
        return true;
    }

    public String getIdColumnForPrint() {
        String result = "";
        if (Main.ATM_PRINT_IN_COLUMNS) {
            result = "                              ";
            for (int i = 0; i < id * 55; i++) {
                result += " ";
            }
        }
        return result;
    }

}
