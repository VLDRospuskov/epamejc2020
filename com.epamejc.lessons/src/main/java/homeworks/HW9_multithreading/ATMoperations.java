package homeworks.HW9_multithreading;

import java.math.BigDecimal;
import java.util.Random;

public class ATMoperations extends Thread {

    private ATM atm;
    private User user;

    public ATMoperations(ATM atm, User user) {
        super(user.getName());
        this.atm = atm;
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            final Integer operationNumber = generateRandomOperationNumber(1, 2);
            try {
                switch (operationNumber) {
                    case 1:
                        atm.withdraw(BigDecimal.valueOf(generateRandomAmount(1000, 3000)), user);
                    case 2:
                        atm.deposit(BigDecimal.valueOf(generateRandomAmount(1000, 3000)), user);
                    case 3:
                        atm.checkBalance(user);
                    case 4:
                        atm.sendMoney(user, BigDecimal.valueOf(generateRandomAmount(500, 1000)));
                }
            } catch (Exception ex) {
                System.out.println("Trouble with threading");
            }
        }
    }

    private Integer generateRandomOperationNumber(int min, int max) {
        return new Random().nextInt(max) + min;
    }

    private Integer generateRandomAmount(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
