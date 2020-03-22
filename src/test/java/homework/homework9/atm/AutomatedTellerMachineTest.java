package homework.homework9.atm;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static homework.homework9.Main.ATM_COUNT;
import static org.junit.Assert.assertEquals;

public class AutomatedTellerMachineTest {

    @SneakyThrows
    @Test
    public void checkBalance() {
        Account account = new Account(AutomatedTellerMachine.MIN_SUM);

        List<AutomatedTellerMachine> atms = new ArrayList<>();

        for (int i = 0; i < ATM_COUNT; i++) {
            atms.add(new AutomatedTellerMachine(0, account));
        }

        final int usersCount = 8;
        final double userCash = 50.0;
        List<User> users = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(usersCount);

        for (int i = 0; i < usersCount; i++) {
            User user = new User("", userCash, atms);
            users.add(user);
            executorService.submit(() -> user.performRandomTasks());
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) ;

        assertEquals(AutomatedTellerMachine.MIN_SUM + 50 * usersCount, countMoney(account, users), 1e-6);
    }

    private double countMoney(Account account, List<User> users) {
        double money = 0.0;
        money += account.getBalance();

        for (User user : users) {
            money += user.getCash();
        }

        return money;
    }

}