package com.epamejc.lessons.src.homework.homework9.threads;

import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.BankSystem;
import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.ClientsList;
import com.epamejc.lessons.src.homework.homework9.threads.bankSystem.Person;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    public void start() {
        BankSystem bankSystem = new BankSystem();
        List<PersonThread> personsThread = new ArrayList<>();
        for (Person client : ClientsList.getClients()) {
            personsThread.add(new PersonThread(client, bankSystem, 20));
        }
        EncashmentThread encashmentThread = new EncashmentThread(bankSystem, 5);
        encashmentThread.start();
        personsThread.forEach(Thread::start);
        try {
            encashmentThread.join();
            for (PersonThread personThread : personsThread) {
                personThread.join();
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception has occurred.");
        }
    }
}
