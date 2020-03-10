package homeworks.java.multithreading;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Bank {

    private static volatile Bank instance;
    private volatile Map<User, BigDecimal> userAccounts;
    private volatile BigDecimal moneyStash;

    private Bank() {
        userAccounts = new HashMap<>();
        moneyStash = BigDecimal.valueOf(1_000_000_000);
    }

    public static Bank getInstance() {
        if (instance == null)
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        return instance;
    }

    public BigDecimal getUserAccountDetails(User user) throws RuntimeException {

        synchronized (user) {
            return userAccounts.entrySet().stream()
                    .filter(person -> person.getKey().equals(user))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No such user."));
        }

    }

    public void transferSalary () {

        synchronized (Bank.class) {
            userAccounts.entrySet()
                    .forEach(user -> user.setValue(user.getValue().add(user.getKey().getSalary())));
        }
    }

    public BigDecimal getMoneyStash() {

        return this.moneyStash;

    }

    public void serviceOperation(BigDecimal amount) throws RuntimeException {

        synchronized(Collector.class) {
            if (moneyStash.compareTo(amount) < 0) {
                throw new RuntimeException("The bank went bankrupt ");
            }
            moneyStash = moneyStash.add(amount);
        }

    }

}
