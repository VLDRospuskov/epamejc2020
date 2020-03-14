package homeworks.homework9.logic;

import homeworks.homework9.data.ATM;
import homeworks.homework9.data.CentralStorage;
import homeworks.homework9.data.Statistics;
import homeworks.homework9.data.User;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Simulation {

    private ArrayList<ATM> atms;
    private ArrayList<User> users;

    @SneakyThrows
    public void run() {
        init();

        ThreadOperations operations1 = new ThreadOperations(atms, users);
        ThreadOperations operations2 = new ThreadOperations(atms, users);
        ThreadOperations operations3 = new ThreadOperations(atms, users);
        ThreadOperations operations4 = new ThreadOperations(atms, users);

        operations1.start();
        operations2.start();
        operations3.start();
        operations4.start();

        operations1.join();
        operations2.join();
        operations3.join();
        operations4.join();

        prinStatistics();
    }

    private void init() {
        atms = new ArrayList<>();

        atms.add(new ATM(BigDecimal.valueOf(250_000.00), 1));
        atms.add(new ATM(BigDecimal.valueOf(250_000.00), 2));
        atms.add(new ATM(BigDecimal.valueOf(250_000.00), 3));

        users = new ArrayList<>();

        users.add(new User("Vladimir Iljich", BigDecimal.valueOf(250_000.00), BigDecimal.valueOf(1_000_000.00)));
        users.add(new User("Tony Stark", BigDecimal.valueOf(180_000.00), BigDecimal.valueOf(25_000_000_000.00)));
        users.add(new User("Petr Romanov", BigDecimal.valueOf(50_000.00), BigDecimal.valueOf(350_000_000)));
    }

    private void prinStatistics() {
        AtmOperations.statistics.reserveAfterChanged = CentralStorage.reserve;
        System.out.println(AtmOperations.statistics.toString());
    }
}
