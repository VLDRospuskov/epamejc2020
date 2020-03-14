package homeworks.homework9.logic;

import homeworks.homework9.data.User;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class UserOperations {

    private User user;

    public synchronized boolean checkCashBalance(BigDecimal amount) {
        return user.getCashBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0;
    }

    public synchronized boolean checkAccountBalance(BigDecimal amount) {
        return user.getAccountBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0;
    }

    public synchronized void deposit(BigDecimal amount) {
        user.setCashBalance(user.getCashBalance().subtract(amount));
        user.setAccountBalance(user.getAccountBalance().add(amount));
    }

    public synchronized void withdraw(BigDecimal amount) {
        user.setCashBalance(user.getCashBalance().add(amount));
        user.setAccountBalance(user.getAccountBalance().subtract(amount));
    }
}
