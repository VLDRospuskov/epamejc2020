package Homeworks.HW9.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {

    private final int moneySupply;
    private final int atmsCount;
    private final int usersCount;

    private int atmDefaultBalance = 1000;
    private int userDefaultBalanceLimit = 100;

    private List<ATM> atmList;
    private List<User> userList;

    public Bank(int moneySupply, int atmsCount, int usersCount) {
        this.moneySupply = moneySupply;
        this.atmsCount = atmsCount;
        this.usersCount = usersCount;

        setupAtmsAndUsers();
    }

    private void setupAtmsAndUsers() {
        Runnable createAtmsRunnable = createAtms();
        Runnable createUsersRunnable = createUsers();

        Thread createAtmsThread = new Thread(createAtmsRunnable);
        Thread createUsersThread = new Thread(createUsersRunnable);

        createAtmsThread.start();
        createUsersThread.start();

        System.out.println("Create ATMs and Users:");
        try {
            createAtmsThread.join();
            createUsersThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ATMs and Users created.");
    }

    private Runnable createAtms() {
        return () -> {
            atmList = new ArrayList<>();
            for (int i = 0; i < atmsCount; i++) {
                atmList.add(new ATM(i, atmDefaultBalance));
            }
        };
    }

    private Runnable createUsers() {
        return () -> {
            userList = new ArrayList<>();
            for (int i = 0; i < usersCount; i++) {
                int balance = new Random().nextInt(userDefaultBalanceLimit);
                userList.add(new User(i, balance));
            }
        };
    }

    public void makeOperations(int count) {
        for (int i = 0; i < count; i++) {
            makeRandomOperation();
        }
    }

    private void makeRandomOperation() {
        int randomAtmId = new Random().nextInt(atmsCount);
        int randomUserId = new Random().nextInt(usersCount);
        ATM randomAtm = atmList.get(randomAtmId);
        User randomUser = userList.get(randomUserId);

        int randomAmount = new Random().nextInt(atmDefaultBalance);

        System.out.println(randomUser.id + " is trying to withdraw " + randomAmount + " from " + randomAtm.id + " with balance " + randomAtm.balance);

        try {
            if (randomUser.withdraw(randomAmount) == randomAtm.withdraw(randomAmount)) {
                System.out.println("All good!");
            }
        } catch (ATMException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

}
