package homeworks.HW9_multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class User {

    private final Object userLock = new Object();
    private String name;
    private BigDecimal userBalance;

    public boolean isEnoughUserBalance(BigDecimal amount) {
        synchronized (userLock) {
            return amount.compareTo(userBalance) == -1 || amount.compareTo(userBalance) == 0;
        }
    }

    public void increaseUserBalance(BigDecimal amount) {
        userBalance = userBalance.add(amount);
    }

    public void decreaseUserBalance(BigDecimal amount) {
        userBalance = userBalance.subtract(amount);
    }

    public synchronized Object getUserLock() {
        return this.userLock;
    }

}
