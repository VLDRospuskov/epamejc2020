package homeworks.hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThreadBalanceOperations extends Thread {

    private User user;

    @Override
    public void run() {
        while (true) {
            final Boolean operationChoiceBool = generateRandomBoolean();
            if (operationChoiceBool) {
                chooseRandomATM().withdraw(generateRandomAmount(), user);
            } else {
                chooseRandomATM().deposit(generateRandomAmount(), user);
            }
        }
    }

    private Boolean generateRandomBoolean() {
        return new Random().nextInt() > 0;
    }

    private Double generateRandomAmount() {
        return (double) (new Random().nextInt(999) * 0.999);
    }

    private ATM chooseRandomATM() {
        final ATM atm = new ATM("ATM 1");
        final ATM atm2 = new ATM("ATM 2");
        final ATM atm3 = new ATM("ATM 3");
        final ATM atm4 = new ATM("ATM 4");
        final ATM atm5 = new ATM("ATM 5");

        List<ATM> listATM = new ArrayList<>();
        listATM.add(atm);
        listATM.add(atm2);
        listATM.add(atm3);
        listATM.add(atm4);
        listATM.add(atm5);

        return listATM.get(new Random().nextInt(5));
    }
}
