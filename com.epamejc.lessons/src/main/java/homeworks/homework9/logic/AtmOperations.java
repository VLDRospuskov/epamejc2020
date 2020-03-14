package homeworks.homework9.logic;

import homeworks.homework9.data.Statistics;
import homeworks.homework9.data.User;
import homeworks.homework9.data.ATM;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

import static homeworks.homework9.logic.CentralStorageOperations.*;

@AllArgsConstructor
public class AtmOperations {

    private ATM atm;
    public static Statistics statistics;

    static {
        statistics = new Statistics();
    }

    public synchronized void deposit(BigDecimal amount) {
        add(amount);
        putToCentralStorage();
        statistics.depositTimes++;
        statistics.depositedAmount = statistics.depositedAmount.add(amount);
    }

    public synchronized void withdraw(BigDecimal amount) {
        subtract(amount);
        getFromCentralStorage();
        statistics.withdrawTimes++;
        statistics.withdrawAmount = statistics.withdrawAmount.add(amount);
    }

    public synchronized void checkUserAccountBalance(User user) {
        System.out.println(user.getName() + ": " + user.getAccountBalance());
    }

    public synchronized boolean checkAtmBalance(BigDecimal amount) {
        return atm.getAtmBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0;
    }

    private synchronized void putToCentralStorage() {
        if (atm.getAtmBalance().doubleValue() >= 500_000.00) {
            System.out.println("ATM " + atm.getId() + " is pitting to reserve!");
            BigDecimal amount = BigDecimal.valueOf(250_000.00);
            putToReserve(amount);
            subtract(amount);
            statistics.putToReserveTimes++;
            statistics.putToReserveAmount = statistics.putToReserveAmount.add(amount);
        }
    }

    private synchronized void getFromCentralStorage() {
        if (atm.getAtmBalance().doubleValue() <= 100_000.00) {
            System.out.println("ATM " + atm.getId() + " is getting from reserve!");
            BigDecimal amount = BigDecimal.valueOf(150_000.00);
            add(getFromReserve(amount));
            statistics.getFromReserveTimes++;
            statistics.getFromReserveAmount = statistics.getFromReserveAmount.add(amount);
        }
    }

    private void add(BigDecimal amount) {
        atm.setAtmBalance(atm.getAtmBalance().add(amount));
    }

    private void subtract(BigDecimal amount) {
        atm.setAtmBalance(atm.getAtmBalance().subtract(amount));
    }

}
