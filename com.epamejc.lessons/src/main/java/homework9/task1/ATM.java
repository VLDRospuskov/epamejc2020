package homework9.task1;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class ATM {

    static BigDecimal balance = new BigDecimal(1_000_000);
    int numberOfATM;

    static synchronized BigDecimal getBalance() {
        return balance;
    }
}
