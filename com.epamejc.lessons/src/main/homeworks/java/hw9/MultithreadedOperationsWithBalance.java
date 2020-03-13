package homeworks.java.hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultithreadedOperationsWithBalance extends Thread {

    private Customer user;

    public MultithreadedOperationsWithBalance(Customer user){
        this.user = user;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 100){
            boolean randomOperation = generateRandomBoolean();
            if (randomOperation) {
                getAnyATM().deposit(generateRandomAmount(), user);
                count++;
            } else {
                getAnyATM().withdraw(generateRandomAmount(), user);
                count++;
            }
        }
    }

    private ATM getAnyATM(){
        ATM atm1 = new ATM("ATM1");
        ATM atm2 = new ATM("ATM2");
        ATM atm3 = new ATM("ATM3");
        ATM atm4 = new ATM("ATM4");

        List<ATM> listOfATMs = new ArrayList<>();
        listOfATMs.add(atm1);
        listOfATMs.add(atm2);
        listOfATMs.add(atm3);
        listOfATMs.add(atm4);

        return listOfATMs.get(new Random().nextInt(3));
    }

    private int generateRandomAmount() {
        return new Random().nextInt(500);
    }

    private boolean generateRandomBoolean() {
        return new Random().nextInt(100) > 50;
    }
}
