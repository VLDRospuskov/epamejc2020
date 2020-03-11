package homeworks.java.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ATMSimulation {

    List<ATM> atms = new ArrayList<>();

    public void run() {
        for (int i = 0; i < 20; i++) {
            atms.add(new ATM(new Random().nextInt(100)));
        }

        User user1 = new User("Vladimir", 1_000, 55_000);
        User user2 = new User("Vlad", 3_000, 65_000);
        User user3 = new User("Karina", 2_000, 75_000);
        User user4 = new User("Oleg", 4_000, 15_000);
        User user5 = new User("Ivan", 6_000, 155_000);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Bank.getInstance().registerUsers(users);

        Collector collector = new Collector(atms);
        UserOperations userOperations1 = new UserOperations(atms, user1);
        UserOperations userOperations2 = new UserOperations(atms, user2);
        UserOperations userOperations3 = new UserOperations(atms, user3);
        UserOperations userOperations4 = new UserOperations(atms, user4);
        UserOperations userOperations5 = new UserOperations(atms, user5);

        Thread collectorThread = new Thread(collector);
        Thread userThread1 = new Thread(userOperations1);
        Thread userThread2 = new Thread(userOperations2);
        Thread userThread3 = new Thread(userOperations3);
        Thread userThread4 = new Thread(userOperations4);
        Thread userThread5 = new Thread(userOperations5);

        collectorThread.start();
        userThread1.start();
        userThread2.start();
        userThread3.start();
        userThread4.start();
        userThread5.start();

    }
}
