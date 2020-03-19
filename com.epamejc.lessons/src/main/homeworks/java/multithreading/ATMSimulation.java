package homeworks.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ATMSimulation {

    public void run() {

        List<ATM> atms = generateATMs();
        List<User> users = generateUsers();

        Bank.getInstance().registerUsers(users);
        CollectorOperations collectorThread = new CollectorOperations(new Collector(atms));
        collectorThread.start();

        for (User user : users) {
            new Thread(new UserOperations(atms, user)).start();
        }

    }

    private List<ATM> generateATMs () {

        List<ATM> atms = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            atms.add(new ATM(new Random().nextInt(100)));
        }
        return atms;

    }

    private List<User> generateUsers () {

        List<User> users = new ArrayList<>();
        users.add(new User("Vladimir", 1_000, 55_000));
        users.add(new User("Vlad", 3_000, 65_000));
        users.add(new User("Karina", 2_000, 75_000));
        users.add(new User("Oleg", 4_000, 15_000));
        users.add(new User("Ivan", 6_000, 155_000));
        return users;

    }

}