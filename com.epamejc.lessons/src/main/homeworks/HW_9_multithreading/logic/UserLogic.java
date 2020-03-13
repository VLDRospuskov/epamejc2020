package homeworks.HW_9_multithreading.logic;

import homeworks.HW_9_multithreading.data.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.logic.Util.format;
import static homeworks.HW_9_multithreading.data.Counter.*;

@Data
@AllArgsConstructor
public class UserLogic {

    private User user;
    private BigDecimal amount;

    public void getCash() {
        substractAccount();
        addCash();
        System.out.println(user.getName() + " withdrew " + format(amount) + " from the account.");
    }

    public void putCash() {
        substractCash();
        addAccount();
        System.out.println(user.getName() + " deposited " + format(amount) + " on the account.");
    }

    public boolean hasOnAccount() {
        boolean result = user.getAccountBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0;

        if (!result) {
            System.out.println("\033[1;91m" + "User doesn't have enough money on the account!" + "\u001B[0m");
            declinedAccount++;
        }

        return result;
    }

    public boolean hasInCash() {
        boolean result = user.getCashBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0;

        if (!result) {
            System.out.println("\033[1;91m" + "User doesn't have enough cash!" + "\u001B[0m");
            declinedCash++;
        }

        return result;
    }

    private void substractAccount() {
        user.setAccountBalance(user.getAccountBalance().subtract(amount));
    }

    private void addCash() {
        user.setCashBalance(user.getCashBalance().add(amount));
    }

    private void addAccount() {
        user.setAccountBalance(user.getAccountBalance().add(amount));
    }

    private void substractCash() {
        user.setCashBalance(user.getCashBalance().subtract(amount));
    }
}
