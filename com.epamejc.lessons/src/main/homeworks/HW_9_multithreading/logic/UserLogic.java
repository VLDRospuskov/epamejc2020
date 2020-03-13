package homeworks.HW_9_multithreading.logic;

import homeworks.HW_9_multithreading.data.User;

import java.math.BigDecimal;

import static homeworks.HW_9_multithreading.logic.Util.format;

public class UserLogic {

    public synchronized boolean getCash(User user, BigDecimal amount) {
        boolean isSuccessful = false;

        try {
            getCashIfPossible(user, amount);
            isSuccessful = true;
        } catch (Exception e) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " doesn't have enough money on account! " +
                    "Operation terminated!");
        }

        return isSuccessful;
    }

    public synchronized boolean putCash(User user, BigDecimal amount) {
        boolean isSuccessful = false;

        try {
            putCashIfPossible(user, amount);
            isSuccessful = true;
        } catch (Exception e) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " doesn't have enough cash! " +
                    "Operation terminated!");
        }

        return isSuccessful;
    }

    private void getCashIfPossible(User user, BigDecimal amount) throws Exception {
        if (user.getAccountBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            user.setCashBalance(user.getCashBalance().add(amount));
            user.setAccountBalance(user.getAccountBalance().subtract(amount));
            System.out.println(user.getFirstName() + " " + user.getLastName() +
                    " withdrew " + format(amount) + " from his account.");
        } else {
            throw new Exception();
        }
    }

    private void putCashIfPossible(User user, BigDecimal amount) throws Exception {
        if (user.getCashBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            user.setCashBalance(user.getCashBalance().subtract(amount));
            user.setAccountBalance(user.getAccountBalance().add(amount));
            System.out.println(user.getFirstName() + " " + user.getLastName() + " deposited " + format(amount) + " on his account.");
        } else {
            throw new Exception();
        }
    }

}
