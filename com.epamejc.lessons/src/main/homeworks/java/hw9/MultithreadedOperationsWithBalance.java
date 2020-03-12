package homeworks.java.hw9;

import java.util.Random;

public class MultithreadedOperationsWithBalance extends Thread {

    private ATM atm;
    private Customer user;

    public MultithreadedOperationsWithBalance(ATM atm, Customer user){
        this.user = user;
        this.atm = atm;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 50){
            boolean randomOperation = generateRandomBoolean();
            if (randomOperation) {
                atm.deposit(generateRandomAmount(), user);
                count++;
            } else {
                atm.withdraw(generateRandomAmount(), user);
                count++;
            }
        }
    }

    private int generateRandomAmount() {
        return new Random().nextInt(500);
    }

    private boolean generateRandomBoolean() {
        return new Random().nextInt(100) > 50;
    }
}
