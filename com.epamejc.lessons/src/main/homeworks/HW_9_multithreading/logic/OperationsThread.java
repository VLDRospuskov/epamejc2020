package homeworks.HW_9_multithreading.logic;


import homeworks.HW_9_multithreading.data.ATM;
import homeworks.HW_9_multithreading.data.User;

import java.math.BigDecimal;
import java.util.ArrayList;

import static homeworks.HW_9_multithreading.data.UnitedAccount.unitedAccount;
import static homeworks.HW_9_multithreading.logic.Util.*;
import static homeworks.HW_9_multithreading.data.Counter.*;

public class OperationsThread extends Thread {

    static ArrayList<User> users;
    static ArrayList<ATM> atms;
    private User user;
    private ATM atm;
    private BigDecimal amount;
    private String operation;
    private ATMLogic atmLogic;
    private UserLogic userLogic;
    private int amountOfOperations = 1000;

    @Override
    public void run() {
        while (amountOfOperations > 0) {
            amountOfOperations--;
            initializeOperationData();
            synchronized (OperationsThread.class) {
                printStatusMessage();
                makeOperation();
            }
        }
    }

    private void initializeOperationData() {
        user = getRandom(users);
        atm = getRandom(atms);
        amount = getRandomBigDecimal(100.00, 2000.00);
        operation = getDepositOrWithdraw();
        atmLogic = new ATMLogic(atm, amount);
        userLogic = new UserLogic(user, amount);
    }

    private void makeOperation() {
        switch (operation) {
            case "withdraw": {
                withdraw();
                break;
            }
            case "deposit": {
                deposit();
                break;
            }
        }
    }

    private void printStatusMessage() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(user.getName() + " wants to " + operation + " " +
                format(amount) + ", ATM on " + atm.getLocation());
        System.out.println("User account: " + format(user.getAccountBalance()) +
                ", cash: " + format(user.getCashBalance()));
        System.out.println("ATM: " + format(atm.getBalance()));
        System.out.println("UnitedAccount: " + format(unitedAccount));
    }


    private void withdraw() {
        if (userLogic.hasOnAccount() && atmLogic.hasCash()) {
            userLogic.getCash();
            atmLogic.withdraw();
        }

        withdrawals++;
        System.out.println("----------------------");
    }

    private void deposit() {
        if (userLogic.hasInCash()) {
            userLogic.putCash();
            atmLogic.deposit();
        }

        deposits++;
        System.out.println("----------------------");
    }

}
