package homework.hw10;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class ThreadATMOperations extends Thread {

    private final ATM atm;
    private final User user;
    public static List<User> users;


    public User getUser() {
        return user;
    }

    public ThreadATMOperations(ATM atm, User user) {
        super(user.getName());
        this.atm = atm;
        this.user = user;
    }

    private User pickRandomUser() {
        int randomIndex = new Random().nextInt(users.size());
        return users.get(randomIndex);
    }

    @Override
    public void run() {
        while (true) {
            performRandomOperation();
        }
    }

    private void performRandomOperation() {
        final int chooseOperation = generateRandomIntForOperations();
        BigDecimal generatedRandomAmount = generateRandomAmount();
        switch (chooseOperation) {
            case 0: {
                performWithdraw(generatedRandomAmount);
            }
            break;
            case 1: {
                atm.deposit(generatedRandomAmount);
                user.setUserAmount(user.getUserAmount().add(generatedRandomAmount));
            }
            break;
            case 2: {
                atm.checkBalance();
            }
            break;
            case 3: {
                atm.sendMoneyToAnotherUser(pickRandomUser(), generatedRandomAmount);
            }
        }
        try {
            sleep(new Random().nextInt(2000));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void performWithdraw(BigDecimal generatedRandomAmount) {
        if (generatedRandomAmount.compareTo(user.getUserAmount()) > 0) return;
        if (atm.withdraw(generatedRandomAmount))
            user.setUserAmount(user.getUserAmount().subtract(generatedRandomAmount));
    }

    private int generateRandomIntForOperations() {
        return new Random().nextInt(4);
    }

    private BigDecimal generateRandomAmount() {
        int bound;
        if (user.getUserAmount().compareTo(new BigDecimal(Integer.MAX_VALUE)) >= 0) {
            bound = Integer.MAX_VALUE - 1;
        } else {
            bound = user.getUserAmount().intValueExact();
        }
        return new BigDecimal(1 + new Random().nextInt(1 + bound));
    }

}