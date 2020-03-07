package com.epamejc.lessons.src.homework.homework9.threads.bankSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BankSystem {
    private final List<ATM> listATM;
    private final Random r = new Random();

    public BankSystem() {
        BankBalance bankBalance = new BankBalance();
        listATM = Arrays.asList(
                new ATM(1, bankBalance),
                new ATM(2, bankBalance),
                new ATM(3, bankBalance)
        );
    }

    public ATM getRandomATM() {
        int index = r.nextInt(2);
        return listATM.get(index);
    }
}
