package homeworks.HW_9_multithreading.logic;

import homeworks.HW_9_multithreading.data.User;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.logic.Util.format;
import static homeworks.HW_9_multithreading.data.Counter.*;


public class UserLogic {

    public void getCash(User user, BigDecimal amount) {
        substractAccount(user, amount);
        addCash(user, amount);
        System.out.println(user.getName() + " withdrew " + format(amount) + " from the account.");
    }

    public void putCash(User user, BigDecimal amount) {
        substractCash(user, amount);
        addAccount(user, amount);
        System.out.println(user.getName() + " deposited " + format(amount) + " on the account.");
    }

    public boolean hasOnAccount(User user, BigDecimal amount) {
        boolean result = user.getAccountBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0;

        if (!result) {
            System.out.println("\033[1;91m" + "User doesn't have enough money on the account!" + "\u001B[0m");
            declinedAccount++;
        }

        return result;
    }

    public boolean hasInCash(User user, BigDecimal amount) {
        boolean result = user.getCashBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0;

        if (!result) {
            System.out.println("\033[1;91m" + "User doesn't have enough cash!" + "\u001B[0m");
            declinedCash++;
        }

        return result;
    }

    private void substractAccount(User user, BigDecimal amount) {
        user.setAccountBalance(user.getAccountBalance().subtract(amount));
    }

    private void addCash(User user, BigDecimal amount) {
        user.setCashBalance(user.getCashBalance().add(amount));
    }

    private void addAccount(User user, BigDecimal amount) {
        user.setAccountBalance(user.getAccountBalance().add(amount));
    }

    private void substractCash(User user, BigDecimal amount) {
        user.setCashBalance(user.getCashBalance().subtract(amount));
    }
}
