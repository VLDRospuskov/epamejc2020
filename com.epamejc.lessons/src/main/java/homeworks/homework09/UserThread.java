package homeworks.homework09;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class UserThread extends Thread {

    static BigDecimal allUsersBalance = BigDecimal.ZERO;

    User user;

    public UserThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        int operationsCounter = 0;
        while (operationsCounter < 100_000) {
            int operation = user.chooseRandomOperation();
            BigDecimal amount = user.chooseRandomAmountFrom0To10000();
            ATM atm = user.chooseRandomATM();

            int operationID = new Random().nextInt(900_000) + 100_000;

            System.out.println("Operation "+ operationID + ": " +
                    user.name + " tries to " + user.getOperationName(operation) + " " + amount.toString().substring(0, 7) + " dollars.");
            BigDecimal oldBalanceValue = Balance.getBalance();
            user.executeOperation(operation, amount, atm);
            BigDecimal newBalanceValue = Balance.getBalance();
            System.out.println("Operation "+ operationID +
                    ": balance changed from " + oldBalanceValue.setScale(3, RoundingMode.UP) +
                    " to " + newBalanceValue.setScale(3, RoundingMode.UP));

            operationsCounter++;
        }

        allUsersBalance = allUsersBalance.add(user.userBalance);
        System.out.println("All user balance = " + allUsersBalance);
        System.out.println("System balance = " + Balance.getBalance());
        System.out.println("Total balance = " + allUsersBalance.add(Balance.getBalance()) +
                ". Should be: " + 500000.0);
    }

}
