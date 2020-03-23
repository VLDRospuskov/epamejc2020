package homeworks.java.multithreading;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Bank {

    private static Bank instance;
    private Map<User, BigDecimal> userAccounts;
    private volatile BigDecimal moneyStash;

    private Bank() {

        userAccounts = new HashMap<>();
        moneyStash = BigDecimal.valueOf(1_000_000.);

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

    public BigDecimal getMoneyStash() {

        return this.moneyStash;

    }

    public void setMoneyStash(BigDecimal value) {

        moneyStash = value;

    }

    public Map<User, BigDecimal> getUserAccounts() {

        return userAccounts;

    }

    public void registerUser(User user) {

        userAccounts.put(user, BigDecimal.ZERO);

    }

    public void deleteAllUsers() {

        userAccounts.clear();

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

    /**
     * Used to update user account.
     *
     * @param amount is {@code BigDecimal} value which can de positive or negative.
     * @return {@code true} if an operation is possible and done, or {@code false} otherwise
     */
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
                    .findFirst()
                    .ifPresent(u -> u.setValue(u.getValue().add(u.getKey().getSalary())));
        }
        System.out.println("\nUser " + user.getName() + " got a salary. Account details: "
                + getUserAccountDetails(user).setScale(2, BigDecimal.ROUND_DOWN) + "\n");

    }

    /**
     * Used during service operation.
     *
     * @param amount is {@code BigDecimal} value which can be positive or negative
     * @throws RuntimeException if bank account went empty
     */
    public void serviceOperation(BigDecimal amount) throws RuntimeException {

        synchronized (Bank.class) {
            if (moneyStash.add(amount).compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("\nThe bank went bankrupt\n");
            }
            moneyStash = moneyStash.add(amount);
        }

    }

}
