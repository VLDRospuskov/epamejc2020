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
    private ATMLogic atmLogic = new ATMLogic();
    private UserLogic userLogic = new UserLogic();
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

    public void initializeOperationData() {
        user = getRandom(users);
        atm = getRandom(atms);
        amount = getRandomBigDecimal(100.00, 2000.00);
        operation = getDepositOrWithdraw();
    }

    public void makeOperation() {
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

    public void printStatusMessage() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(user.getName() + " wants to " + operation + " " +
                format(amount) + ", ATM on " + atm.getLocation());
        System.out.println("User account: " + format(user.getAccountBalance()) +
                ", cash: " + format(user.getCashBalance()));
        System.out.println("ATM: " + format(atm.getBalance()));
        System.out.println("UnitedAccount: " + format(unitedAccount));
    }


    public void withdraw() {
        if (userLogic.hasOnAccount(user, amount) && atmLogic.hasCash(atm, amount)) {
            userLogic.getCash(user, amount);
            atmLogic.withdraw(atm, amount);
        }

        withdrawals++;
        System.out.println("----------------------");
    }

    public void deposit() {
        if (userLogic.hasInCash(user, amount)) {
            userLogic.putCash(user, amount);
            atmLogic.deposit(atm, amount);
        }

        deposits++;
        System.out.println("----------------------");
    }

}
