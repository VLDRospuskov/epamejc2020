package com.epamejc.lessons.src.homework.homework9.threads;

import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.ATM;
import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.BankSystem;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class EncashmentThread extends Thread {
    private final BankSystem bankSystem;
    private int count;

    public EncashmentThread(BankSystem bankSystem, int count) {
        this.bankSystem = bankSystem;
        this.count = count;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (count > 0) {
            ATM atm = bankSystem.getRandomATM();
            atm.encashment();
            count--;
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
