package homeworks.java.hw9;

import lombok.AllArgsConstructor;
import lombok.Data;

import static homeworks.java.hw9.GeneralBalance.*;

@AllArgsConstructor
public class ATM {

    String name;

    public synchronized int deposit(int amount, Customer user) {
        if (user.getWalletBalance() >= amount) {
            commonATMBalance += amount;
            user.setWalletBalance(user.getWalletBalance() - amount);
            System.out.format("%s %s\n%s topped up balance by %d.\nWallet balance of the user is %d " +
                            "\nThe ATMs common balance is %d \n\n", Thread.currentThread().getName(), name,
                    user.getName(), amount, user.getWalletBalance(), commonATMBalance);
        } else {
            throw new RuntimeException(String.format("%s %s\n%s wants to deposit %d.\n" +
                            "%s has't enough money in the wallet. " +
                            "The wallet balance is %d", Thread.currentThread().getName(), name,
                    user.getName(), amount, user.getName(), user.getWalletBalance()));
        }
        return commonATMBalance;
    }

    public synchronized int withdraw(int amount, Customer user) {
        if (commonATMBalance >= amount) {
            commonATMBalance -= amount;
            user.setWalletBalance(user.getWalletBalance() + amount);
            System.out.format("%s %s\n%s withdrew %d \nWallet balance of the user is %d " +
                            "\nThe ATMs common balance is %d \n\n", Thread.currentThread().getName(), name,
                    user.getName(), amount, user.getWalletBalance(), commonATMBalance);

        } else {
            throw new RuntimeException(String.format("%s\n%s wants to withdraw %d.\nNot enough money in %s. " +
                            "ATM balance is %d", Thread.currentThread().getName(),
                    user.getName(), amount, name, commonATMBalance));
        }
        return commonATMBalance;
    }

}
