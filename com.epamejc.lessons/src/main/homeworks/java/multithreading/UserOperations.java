package homeworks.java.multithreading;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class UserOperations implements Runnable{

    private User user;
    private List<ATM> atms;

    public UserOperations(List<ATM> atms, User user) {
        this.user = user;
        this.atms = atms;
    }

    @SneakyThrows
    @Override
    public void run() {

        while(true) {
            Thread.sleep(2000L);
            if (Bank.getInstance().getUserAccountDetails(user).doubleValue() < 50_000.0) {
                doJob();
            } else {
                useATM();
            }
        }
    }

    private void doJob() {

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bank.getInstance().transferSalary(user);

    }

    private void useATM() {

        ATM atm = randomATM();
        BigDecimal amount;
        if (new Random().nextInt(2) == 0) {
            amount = BigDecimal.valueOf((new Random().nextDouble() * user.getCash().doubleValue()));
            atm.deposit(amount, user);
        } else {
            amount = BigDecimal.valueOf(new Random().nextDouble() * 100_000.0);
            atm.withdraw(amount, user);
        }

    }

    private ATM randomATM () {

        int i = new Random().nextInt(atms.size());
        return atms.get(i);

    }

}
