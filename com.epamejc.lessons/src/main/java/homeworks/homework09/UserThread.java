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
        while (operationsCounter++ < 100_000) {
            int operation = user.chooseRandomOperation();
            BigDecimal amount = user.chooseRandomAmountFrom0To10000();
            ATM atm = user.chooseRandomATM();
            int operationID = new Random().nextInt(900_000) + 100_000;

            printOperationDetails(operationID, operation, user, amount, atm);
            BigDecimal oldBalanceValue = Balance.getBalance();

            user.executeOperation(operation, amount, atm);

            BigDecimal newBalanceValue = Balance.getBalance();
            printOperationResults(operationID, oldBalanceValue, newBalanceValue);
        }

        updateAndPrintSystemState();
    }

    private void updateAndPrintSystemState() {
        allUsersBalance = allUsersBalance.add(user.userBalance);
        System.out.println("All user balance = " + allUsersBalance);
        System.out.println("System balance = " + Balance.getBalance());
        System.out.println("Total balance = " + allUsersBalance.add(Balance.getBalance()) +
                ". Should be: " + 500000.0);
    }

    private void printOperationResults(int operationID, BigDecimal oldBalanceValue, BigDecimal newBalanceValue) {
        System.out.println("Operation "+ operationID +
                ": balance changed from " + oldBalanceValue.setScale(3, RoundingMode.HALF_UP) +
                " to " + newBalanceValue.setScale(3, RoundingMode.HALF_UP));
    }

    private void printOperationDetails(int operationID, int operation, User user, BigDecimal amount, ATM atm) {


        System.out.println("Operation "+ operationID + ": " +
                user.name + " tries to " + getOperationName(operation) +
                " " + amount.setScale(3, RoundingMode.HALF_UP) + " dollars from ATM № " + atm.id);
    }

    public String getOperationName(int operation) {
        switch (operation) {
            case 0:
                return "add to balance";
            case 1:
                return "take from balance";
            default:
                return "";
        }
    }

}
