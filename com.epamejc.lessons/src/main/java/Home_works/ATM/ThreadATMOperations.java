package Home_works.ATM;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class ThreadATMOperations extends Thread {

    private final ATM atm;
    private User user;
    public static List<User> listOfUsers;

    public ThreadATMOperations(ATM atm, User user) {
        super(user.getName());
        this.atm = atm;
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            try {
                chooseOperationRND();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private BigDecimal generateRandomAmount() {
        int bound;
        if (user.getBalanceOfUser().compareTo(new BigDecimal(Integer.MAX_VALUE)) >= 0) {
            bound = Integer.MAX_VALUE - 1;
        } else {
            bound = user.getBalanceOfUser().intValueExact();
        }
        return new BigDecimal(1 + new Random().nextInt(1 + bound));
    }

    public User getUser() {
        return user;
    }

    private void chooseOperationRND() throws InterruptedException {
        int chooseOperation = new Random().nextInt(3);
        BigDecimal generateRandomAmount = generateRandomAmount();

        switch (chooseOperation) {
            case 0: {
                doWithdraw(generateRandomAmount);

            }
            break;
            case 1: {
                atm.deposit(generateRandomAmount);
                user.setBalanceOfUser(user.getBalanceOfUser().add(generateRandomAmount));

            }
            break;
            case 2: {
                atm.checkBalanceOfUser();

            }
            break;
        }
        sleep(new Random().nextInt(2000));
    }

    public void doWithdraw(BigDecimal generateRandomAmount) {
        if (generateRandomAmount.compareTo(user.getBalanceOfUser()) > 0) {
            return;
        }

        if (atm.withdraw(generateRandomAmount))
            user.setBalanceOfUser(user.getBalanceOfUser().subtract(generateRandomAmount));
    }
}
