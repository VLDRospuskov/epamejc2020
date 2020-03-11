package homeworks.homework9_multithreading.service;

import homeworks.homework9_multithreading.model.ATM;
import homeworks.homework9_multithreading.model.Person;
import homeworks.homework9_multithreading.myenum.Operation;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Random;

@AllArgsConstructor
public class ATMOperations extends Thread {
    private Person person;
    private volatile ATM atm;
    private final Object mutex = new Object();

    @Override
    public void run() {
        while (true) {
            Operation operation = getRandomOperation();
            BigDecimal amount = new BigDecimal(getRandomAmount());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            synchronized (mutex) {
                atm.makeOperation(amount, person, operation);
            }

        }
    }

    private Operation getRandomOperation() {
        Random random = new Random();
        int position = random.nextInt(20);
        if (position == 0) {
            return Operation.DEPOSIT;
        } else {
            return Operation.WITHDRAW;
        }
    }

    private double getRandomAmount() {
        Random random = new Random();
        return Math.abs(random.nextInt(500));
    }
}
