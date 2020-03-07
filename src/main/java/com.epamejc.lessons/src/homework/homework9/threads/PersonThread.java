package com.epamejc.lessons.src.homework.homework9.threads;

import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.ATM;
import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.AtmOperations;
import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.BankSystem;
import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.Person;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PersonThread extends Thread {
    private final Person person;
    private final Random r = new Random();
    private final BankSystem bankSystem;
    private int operation;

    PersonThread(Person person, BankSystem bankSystem, int maxNumOperation) {
        super(person.getName());
        this.person = person;
        this.operation = maxNumOperation;
        this.bankSystem = bankSystem;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (operation > 0) {
            ATM atm = bankSystem.getRandomATM();
            boolean choice = r.nextBoolean();
            if (choice) {
                AtmOperations.depositRandom(person, atm);
            } else {
                AtmOperations.withdrawRandom(person, atm);
            }
            operation--;
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
