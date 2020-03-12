package homework.homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Account account = new Account(AutomatedTellerMachine.MIN_SUM);

        List<AutomatedTellerMachine> atms = new ArrayList<>();

        final int ATM_COUNT = 3;
        List<Integer> atmIds = IdGenerator.generateIds(ATM_COUNT);
        System.out.println("ATMs" + atmIds);

        for (Integer id : atmIds) {
            atms.add(new AutomatedTellerMachine(id, account));
        }

        List<String> userNames = Arrays.asList("Alex", "Brian", "Fred", "Helen", "John", "Kate", "Laura", "Selena");
        System.out.println("Users" + userNames);

        ExecutorService executorService = Executors.newFixedThreadPool(userNames.size());

        for (String name : userNames) {
            executorService.submit(() -> new User(name, 50.0, atms).performRandomTasks());
        }
    }
}
