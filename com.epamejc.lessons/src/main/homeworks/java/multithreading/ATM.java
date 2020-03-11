package homeworks.java.multithreading;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ATM {

    private boolean isOnService;
    private volatile BigDecimal account;
    private final int serialNumber;
    private final Object lock;

    public ATM(int serialNumber) {

        account = BigDecimal.valueOf(1_000_000.0);
        this.serialNumber = serialNumber;
        lock = new Object();
        isOnService = false;

    }

    public void service(BigDecimal cash) {

        synchronized (lock) {
            account = account.add(cash);
            isOnService = false;
            BigDecimal bankStorage = Bank.getInstance().getMoneyStash();
            System.out.println("Service on " + serialNumber + " ATM, bank storage is now " + bankStorage);
            System.out.println("ATM " + serialNumber + " storage is " + account);
        }

    }

    public void deposit(BigDecimal amount, User user) {

        synchronized (lock) {
            account = account.add(amount);
            Bank.getInstance().userAccountUpdate(user, amount);
            System.out.println("Deposit of " + amount + " to " + serialNumber + " ATM");
            System.out.println(("Current ATM: " + serialNumber + " balance: " + account));
            System.out.println("Current User balance: " + user.getName() +
                    " " + Bank.getInstance().getUserAccountDetails(user));
            isOnService = isServiceNeeded();
        }
    }

    public void withdraw(BigDecimal amount, User user) {

        if (isOnService) {
            System.out.println("Failed to withdraw, ATM " + serialNumber + " is closed for service");
        } else {
            synchronized (lock) {
                if (account.subtract(amount).doubleValue() < 0) {
                    isOnService = true;
                    System.out.println("Failed to withdraw, not enough cash, ATM is closing for service");
                } else {
                    if (Bank.getInstance().userAccountUpdate(user, amount.negate())) {
                        account = account.subtract(amount);
                        System.out.println("Withdraw of " + amount + " from " + serialNumber + " ATM");
                        System.out.println(("Current ATM: " + serialNumber + " balance: " + account));
                        System.out.println("Current User balance: " + user.getName() +
                                " " + Bank.getInstance().getUserAccountDetails(user));
                    } else {
                        System.out.println("Failed to withdraw, not enough funds on user account");
                    }
                    isOnService = isServiceNeeded();
                }
            }
        }
    }

    private boolean isServiceNeeded() {
        boolean isServiceNeeded = false;
        if (account.doubleValue() >= 1_500_000 || account.doubleValue() <= 10_000) {
            isServiceNeeded = true;
            System.out.println("ATM " + serialNumber + " is closed for service");
        }
        return isServiceNeeded;
    }

}
