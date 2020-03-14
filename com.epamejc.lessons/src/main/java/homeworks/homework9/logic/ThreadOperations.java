package homeworks.homework9.logic;

import homeworks.homework9.data.ATM;
import homeworks.homework9.data.User;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;

import static homeworks.homework9.logic.RandomGenerator.*;

public class ThreadOperations extends Thread {

    private ATM atm;
    private User user;
    private ArrayList<ATM> atms;
    private ArrayList<User> users;
    private AtmOperations operations;
    private UserOperations userOperations;
    private String operation;
    private BigDecimal amount;

    public ThreadOperations(ArrayList<ATM> atms, ArrayList<User> users) {
        this.atms = atms;
        this.users = users;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (ThreadOperations.class) {
            while (true) {
                init();
                doOperation();
                printMessage();
                Thread.sleep(1000);
            }
        }
    }

    private void init() {
        user = users.get(getRandomNumber(users.size()));
        atm = atms.get(getRandomNumber(atms.size()));
        userOperations = new UserOperations(user);
        operations = new AtmOperations(atm);
    }

    private void doOperation() {
        int o = getRandomOperation();
        amount = getRandomAmount();

        switch (o) {
            case 0 : {
                deposit(amount);
                operation = "deposit";
                break;
            }
            case 1 : {
                withdraw(amount);
                operation = "withdraw";
                break;
            }
            case 2 : {
                check();
                operation = "check";
                break;
            }
        }
    }

    private void printMessage() {
        System.out.println(Thread.currentThread().getName() + " " + operation);
        if (!(operation.equals("check"))) {
            System.out.println("Amount: " + amount.toString());
        }
        System.out.println(user.getName() + " cash balance: " + user.getCashBalance()
                + " account balance: " + user.getAccountBalance());
        System.out.println("Atm " + atm.getId() + " balance: " + atm.getAtmBalance());
        System.out.println("<<<<<<<<<<<<<<<O>>>>>>>>>>>>>>>");
    }

    private void check() {
        operations.checkUserAccountBalance(user);
    }

    private void withdraw(BigDecimal amount) {
        if (userOperations.checkAccountBalance(amount) && operations.checkAtmBalance(amount)) {
            operations.withdraw(amount);
            userOperations.withdraw(amount);
        }
    }

    private void deposit(BigDecimal amount) {
        if (userOperations.checkCashBalance(amount)) {
            operations.deposit(amount);
            userOperations.deposit(amount);
        }
    }
}
