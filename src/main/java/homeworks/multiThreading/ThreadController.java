package homeworks.multiThreading;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadController {

    public static ReentrantLock locker = new ReentrantLock();

    @SneakyThrows
    public void start() {

        Bank bank = new Bank("Tinkovv", new BigDecimal(2500), false);

        List<ATM> atms = new ArrayList<>();
        atms.add(new ATM("ATM1", new BigDecimal(500)));
        atms.add(new ATM("ATM2", new BigDecimal(500)));
        atms.add(new ATM("ATM3", new BigDecimal(500)));
        atms.add(new ATM("ATM4", new BigDecimal(500)));

        List<User> users = new ArrayList<>();
        users.add(new User("Boris1", new BigDecimal(500), false));
        users.add(new User("Vladimir2", new BigDecimal(500), false));
        users.add(new User("Dmitriy3", new BigDecimal(500), false));
        users.add(new User("Volodya4", new BigDecimal(500), false));

        ThreadATMOperations threadATMOperations1 =
                new ThreadATMOperations(bank, users, atms,
                        new BigDecimal(1000), new BigDecimal(50));
        ThreadATMOperations threadATMOperations2 =
                new ThreadATMOperations(bank, users, atms,
                        new BigDecimal(1000), new BigDecimal(50));
        ThreadATMOperations threadATMOperations3 =
                new ThreadATMOperations(bank, users, atms,
                        new BigDecimal(1000), new BigDecimal(50));
        ThreadATMOperations threadATMOperations4 =
                new ThreadATMOperations(bank, users, atms,
                        new BigDecimal(1000), new BigDecimal(50));

        threadATMOperations1.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
        threadATMOperations4.start();

        threadATMOperations1.join();
        threadATMOperations2.join();
        threadATMOperations3.join();
        threadATMOperations4.join();

        BigDecimal sum = getSum(bank, atms);

        System.out.println("Expected sum: 6500\n" +
                "Actual sum:   " + sum);
    }

    private BigDecimal getSum(Bank bank, List<ATM> atms) {

        BigDecimal bankBalance = bank.getBalance();

        BigDecimal atmsBalance = new BigDecimal(0);
        for (ATM atm : atms) {
            atmsBalance = atmsBalance.add(atm.getBalance());
        }

        BigDecimal usersBalance = UsersSum.sum;

        return bankBalance.add(usersBalance.add(atmsBalance));
    }
}
