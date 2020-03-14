package homeworks.homework09;

import java.math.BigDecimal;

public class ATM {

    public boolean addToBalance(BigDecimal value) {
        return Balance.addToBalance(value);
    }

    public boolean subtractFromBalance(BigDecimal value) {
        return Balance.subtractFromBalance(value);
    }

}
