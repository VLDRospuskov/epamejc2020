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
            System.out.println("\nService on " + serialNumber + " ATM, bank storage is now " +
                    bankStorage.setScale(2, BigDecimal.ROUND_DOWN) + "\n" +
                    "ATM " + serialNumber + " storage is "
                    + account.setScale(2, BigDecimal.ROUND_DOWN) + "\n");
        }

    }

    public void deposit(BigDecimal amount, User user) {

        synchronized (lock) {
            account = account.add(amount);
            Bank.getInstance().userAccountUpdate(user, amount);
            user.substractCash(amount);
            System.out.println("\nDeposit of " + amount.setScale(2, BigDecimal.ROUND_DOWN) +
                    " to " + serialNumber + " ATM" + "\n" +
                    "Current ATM: " + serialNumber +
                    " balance: " + account.setScale(2, BigDecimal.ROUND_DOWN) + "\n" +
                    "Current User: " + user.getName() + " balance " +
                    Bank.getInstance().getUserAccountDetails(user)
                            .setScale(2, BigDecimal.ROUND_DOWN) +
                    ", cash " + user.getCash().setScale(2, BigDecimal.ROUND_DOWN) + "\n");
            isOnService = isServiceNeeded();
        }

    }

    public void withdraw(BigDecimal amount, User user) {

        if (isOnService) {
            System.out.println("\nFailed to withdraw, ATM " + serialNumber + " is closed for service\n");
            System.out.println();
        } else {
            synchronized (lock) {
                if (account.subtract(amount).doubleValue() < 0) {
                    isOnService = true;
                    System.out.println("\nFailed to withdraw " + amount.setScale(2, BigDecimal.ROUND_DOWN) +
                            ", not enough cash, ATM " + serialNumber + " is closing for service\n");
                } else {
                    if (Bank.getInstance().userAccountUpdate(user, amount.negate())) {
                        account = account.subtract(amount);
                        user.addCash(amount);
                        System.out.println("\nWithdraw of " + amount.setScale(2, BigDecimal.ROUND_DOWN) +
                                " from " + serialNumber + " ATM" + "\n" +
                                "Current ATM: " + serialNumber +
                                " balance: " + account.setScale(2, BigDecimal.ROUND_DOWN) + "\n" +
                                "Current User: " + user.getName() + " balance " +
                                Bank.getInstance().getUserAccountDetails(user)
                                        .setScale(2, BigDecimal.ROUND_DOWN) +
                                ", cash " + user.getCash().setScale(2, BigDecimal.ROUND_DOWN) + "\n");
                    } else {
                        System.out.println("\nFailed to withdraw " + amount.setScale(2, BigDecimal.ROUND_DOWN) +
                                ", not enough funds on user " + user.getName() + " account\n" +
                                "There is " + Bank.getInstance().getUserAccountDetails(user)
                                .setScale(2, BigDecimal.ROUND_DOWN) + " on account\n");
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
            System.out.println("\nATM " + serialNumber + " is closed for service\n");
        }
        return isServiceNeeded;
    }

}
