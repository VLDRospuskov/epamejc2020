package homeworks.java.multithreading;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Bank {

    private static volatile Bank instance;
    private volatile Map<User, BigDecimal> userAccounts;
    private volatile BigDecimal moneyStash;

    private Bank() {
        userAccounts = new HashMap<>();
        moneyStash = BigDecimal.valueOf(1_000_000_000);
    }

    public void registerUsers(List<User> users) {
        for (User user : users) {
            userAccounts.put(user, BigDecimal.ZERO);
        }
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

        synchronized (User.class) {
            return userAccounts.entrySet().stream()
                    .filter(person -> person.getKey().equals(user))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No such user."));
        }

    }

    public boolean userAccountUpdate(User user, BigDecimal amount) {

        synchronized (User.class) {
            BigDecimal current = getUserAccountDetails(user);
            if (current.add(amount).doubleValue() < 0) {
                return false;
            } else {
                userAccounts.put(user, current.add(amount));
                return true;
            }
        }
    }

    public void transferSalary(User user) {

        synchronized (Bank.class) {
            userAccounts.entrySet()
                    .stream()
                    .filter(u -> u.getKey().equals(user))
                    .forEach(u -> u.setValue(u.getValue().add(u.getKey().getSalary())));
        }
        System.out.println("User " + user.getName() + " got a salary. Account value: " + getUserAccountDetails(user));

    }

    public BigDecimal getMoneyStash() {

        return this.moneyStash;

    }

    public void serviceOperation(BigDecimal amount) throws RuntimeException {

        synchronized (Bank.class) {
            if (moneyStash.compareTo(amount) < 0) {
                throw new RuntimeException("The bank went bankrupt ");
            }
            moneyStash = moneyStash.add(amount);
        }

    }

}
