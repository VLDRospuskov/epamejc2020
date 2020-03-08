package homeworks.homework9;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ATM {

    private BigDecimal atmBalance;
    private int id;

    public void deposit(BigDecimal amount) {
        synchronized (CentralStorage.class) {

        }
    }

    public void withdraw(BigDecimal amount) {
        synchronized (CentralStorage.class) {

        }
    }

    public void checkAccountBalance(User user) {

    }
}
