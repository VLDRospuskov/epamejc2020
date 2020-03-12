package homeworks.java.hw9;

import static homeworks.java.hw9.GeneralBalance.*;

public class ATM {

    public synchronized int deposit(int amount, Customer user) {
        if(user.getWalletBalance() >= amount) {
            commonATMBalance += amount;
            user.setWalletBalance(user.getWalletBalance() - amount);
            System.out.format("%s\n%s deposit %d \nWallet balance of the user is %d " +
                            "\nThe ATMs common balance is %d \n\n", Thread.currentThread().getName(),
                    user.getName(), amount, user.getWalletBalance(), commonATMBalance);
        } else {
            System.out.format("%s\n%s wants to deposit %d.\n%s has't enough money in the wallet. " +
                            "The wallet balance is %d\n\n", Thread.currentThread().getName(),
                    user.getName(), amount, user.getName(), user.getWalletBalance());
            throw new RuntimeException();
        }
        return commonATMBalance;
    }

    public synchronized int withdraw(int amount, Customer user) {
        if(commonATMBalance >= amount) {
            commonATMBalance -= amount;
            user.setWalletBalance(user.getWalletBalance() + amount);
            System.out.format("%s\n%s withdrew %d \nWallet balance of the user is %d " +
                            "\nThe ATMs common balance is %d \n\n", Thread.currentThread().getName(),
                    user.getName(), amount, user.getWalletBalance(), commonATMBalance);
        } else {
            System.out.format("%s\n%s wants to withdraw %d.\nNot enough money in ATM. " +
                    "ATM balance is %d\n\n", Thread.currentThread().getName(),
                    user.getName(), amount, commonATMBalance);
            throw new RuntimeException();
        }
        return commonATMBalance;
    }

}
