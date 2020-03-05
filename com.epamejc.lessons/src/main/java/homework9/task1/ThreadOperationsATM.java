package homework9.task1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import static homework9.task1.MultiThreadingTask1Main.atms;

@Data
@AllArgsConstructor
class ThreadOperationsATM extends Thread {

    static private final Object lock = new Object();
    User user;

    @SneakyThrows
    @Override
    public void run() {
        for (int j = 0; j < MultiThreadingTask1Main.numberOfOperations; j++) {

            ATM atm = atms.get(new Random().nextInt(5));
            int chooseOperation = generateRandomInt();
            BigDecimal moneyTransfer;
            switch (chooseOperation) {
                case 0:
                    synchronized (lock) {
                        moneyTransfer = generateRandomAmountToWithdraw();
                        withdraw(moneyTransfer, atm);
                        Thread.sleep(1000);
                    }
                    break;
                case 1:
                    synchronized (lock) {
                        moneyTransfer = generateRandomAmountToDeposit();
                        deposit(moneyTransfer, atm);
                        Thread.sleep(1000);
                    }
                    break;
                case 2:
                    synchronized (lock) {
                        checkUserBalance(atm);
                        Thread.sleep(1000);
                    }
                    break;
            }
        }
    }

    private int generateRandomInt() {
        return new Random().nextInt(3);
    }

    private BigDecimal generateRandomAmountToDeposit() {
        return BigDecimal.valueOf(Math.random()).multiply(user.getUserBalance()).setScale(2, RoundingMode.CEILING);
    }

    private BigDecimal generateRandomAmountToWithdraw() {
        return BigDecimal.valueOf(Math.random()).multiply(ATM.getBalance()).setScale(2, RoundingMode.CEILING);
    }

    private void deposit(BigDecimal amount, ATM atm) {
        ATM.balance = ATM.balance.add(amount);
        user.setUserBalance(user.getUserBalance().subtract(amount));
        System.out.println(user.getName() + " deposited " + amount + " through ATM № " + atm.getNumberOfATM());
        printInfo(user);
    }

    private void withdraw(BigDecimal amount, ATM atm) {
        ATM.balance = ATM.balance.subtract(amount);
        user.setUserBalance(user.getUserBalance().add(amount));
        System.out.println(user.getName() + " withdrew " + amount + " through ATM № " + atm.getNumberOfATM());
        printInfo(user);
    }

    private void checkUserBalance(ATM atm) {
        System.out.println(user.getName() + " checked own balance through ATM № " + atm.getNumberOfATM()
                + ". Result: " + user.getUserBalance());
        System.out.println("---------------------------------------------------------------");
    }

    private void printInfo(User user) {
        System.out.println(user.getName() + " has " + user.getUserBalance() + " in cash.");
        System.out.println("ATM balance: " + ATM.getBalance());
        System.out.println("---------------------------------------------------------------");
    }
}
