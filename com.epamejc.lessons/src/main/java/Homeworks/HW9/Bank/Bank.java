package Homeworks.HW9.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {

    private final int moneySupply;
    private final int atmsCount;
    private final int usersCount;

    private int atmDefaultBalanceLimit = 1000;
    private int userDefaultBalanceLimit = 100;

    private List<ATM> atmList;
    private List<User> userList;

    public Bank(int moneySupply, int atmsCount, int usersCount) {
        this.moneySupply = moneySupply;
        this.atmsCount = atmsCount;
        this.usersCount = usersCount;

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

        /*
        int atm = 1;
        int user = 1;
        int amount = 1000;

        System.out.println("ATM id: " + atmList.get(atm).id + ", balance: " + atmList.get(atm).balance);
        System.out.println("User id: " + userList.get(user).id + ", balance: " + userList.get(user).balance + " is trying to withdraw " + amount);

        try {
            if (atmList.get(atm).withdraw(amount) == userList.get(user).withdraw(amount)) {
                System.out.print("");
                System.out.println("All good!");
                System.out.println("ATM id: " + atmList.get(atm).id + ", balance: " + atmList.get(atm).balance);
                System.out.println("User id: " + userList.get(user).id + ", balance: " + userList.get(user).balance);
            }
        } catch (ATMException e) {
            System.out.println("Error! " + e.getMessage());
        }
         */

        System.out.println("Money supply: " + moneySupply);
    }

    private Runnable createAtms() {
        return () -> {
            atmList = new ArrayList<>();
            for (int i = 0; i < atmsCount; i++) {
                int balance = new Random().nextInt(atmDefaultBalanceLimit);
                atmList.add(new ATM(i, balance));
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

    private void makeRandomOperation() {
        int randomAtmId = new Random().nextInt(atmsCount);
        int randomUserId = new Random().nextInt(usersCount);
        ATM randomAtm = atmList.get(randomAtmId);
        User randomUser = userList.get(randomUserId);

        int randomAmount = new Random().nextInt(atmDefaultBalanceLimit);

        System.out.println(randomUser.toString() + " is trying to withdraw " + randomAmount + " from " + randomAtm.toString());

        try {
            if (randomUser.withdraw(randomAmount) == randomAtm.withdraw(randomAmount)) {
                System.out.println("All good!"); // asdasd
            }
        } catch (ATMException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

}
