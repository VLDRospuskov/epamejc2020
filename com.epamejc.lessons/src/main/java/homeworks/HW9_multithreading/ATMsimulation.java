package homeworks.HW9_multithreading;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ATMsimulation {

    private static List<User> usersList = new ArrayList<>();


    public ATMsimulation() {
        usersList.add(new User("Vladimir", BigDecimal.valueOf(5000)));
        usersList.add(new User("Vladimir", BigDecimal.valueOf(5000)));
        usersList.add(new User("Mikhail", BigDecimal.valueOf(10000)));
        usersList.add(new User("Maria", BigDecimal.valueOf(12000)));
    }

    public void startSimulation() {

        BankAccount bankAccount = new BankAccount(BigDecimal.valueOf(1_000_000));

        ATM atm1 = new ATM(bankAccount, 1);
        ATM atm2 = new ATM(bankAccount, 2);

        ATMoperations ATMoperations1 = new ATMoperations(atm1, usersList.get(0));
        ATMoperations ATMoperations2 = new ATMoperations(atm1, usersList.get(1));
        ATMoperations ATMoperations3 = new ATMoperations(atm2, usersList.get(2));
        ATMoperations ATMoperations4 = new ATMoperations(atm2, usersList.get(3));

        ATMoperations1.start();
        ATMoperations2.start();
        ATMoperations3.start();
        ATMoperations4.start();
    }

    public static User getRandomUser(User user) {
        User randomUser;
        while(true) {
            randomUser = usersList.get(new Random().nextInt(usersList.size()));
            if (!randomUser.equals(user)) {
                return randomUser;
            }
        }
    }
}
