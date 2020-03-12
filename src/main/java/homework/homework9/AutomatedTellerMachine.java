package homework.homework9;

import homework.homework9.util.Log;

public class AutomatedTellerMachine {

    public static double MIN_SUM = 5.0;
    public static double MAX_SUM = 50.0;
    public static int OPERATIONS_COUNT = 3;

    private Account account;
    private final int id;

    private String ATM_DESCRIPTION;

    public AutomatedTellerMachine(int id, Account account) {
        this.id = id;
        this.account = account;

        ATM_DESCRIPTION = "ATM " + this.id + ": ";
    }

    public int getId() {
        return id;
    }

    public void deposit(User user, double sum) {
        Log.log(user.getName() + " waits for " + ATM_DESCRIPTION);
        synchronized (this) {
            Log.log(user.getName() + " got " + ATM_DESCRIPTION + "wants to deposit " + sum);
            account.deposit(this, sum);
        }
    }

    public void withdraw(User user, double sum) {
        Log.log(user.getName() + " waits for " + ATM_DESCRIPTION);
        synchronized (this) {
            Log.log(user.getName() + " got " + ATM_DESCRIPTION + "wants to withdraw " + sum);
            try {
                account.withdraw(this, sum);
            } catch (IllegalStateException e) {
                Log.log(e.getMessage());
            }
        }
    }

}
