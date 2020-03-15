package homeworks.homework09;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ATM {
    int id;

    public boolean addToBalance(BigDecimal value) {
        return Balance.addToBalance(value);
    }

    public boolean subtractFromBalance(BigDecimal value) {
        return Balance.subtractFromBalance(value);
    }

}
