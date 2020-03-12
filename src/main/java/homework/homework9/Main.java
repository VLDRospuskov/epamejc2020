package homework.homework9;

import homework.homework9.atm.Account;
import homework.homework9.atm.AutomatedTellerMachine;
import homework.homework9.atm.User;
import homework.homework9.util.IdGenerator;
import homework.homework9.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final int ATM_COUNT = 3;

    public static void main(String[] args) {
        Account account = new Account(AutomatedTellerMachine.MIN_SUM);

        List<AutomatedTellerMachine> atms = new ArrayList<>();

        Set<Integer> atmIds = IdGenerator.generateIds(ATM_COUNT);
        Log.log("ATMs" + atmIds);

        for (Integer id : atmIds) {
            atms.add(new AutomatedTellerMachine(id, account));
        }

        List<String> userNames = Arrays.asList("Alex", "Brian", "Fred", "Helen", "John", "Kate", "Laura", "Selena");
        Log.log("Users" + userNames);

        ExecutorService executorService = Executors.newFixedThreadPool(userNames.size());

        for (String name : userNames) {
            executorService.submit(() -> new User(name, 50.0, atms).performRandomTasks());
        }

        executorService.shutdown();
    }
}
