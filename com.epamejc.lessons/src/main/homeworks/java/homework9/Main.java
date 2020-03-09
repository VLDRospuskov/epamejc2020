package main.homeworks.java.homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        List<Client> clients = new ArrayList<>();
        clients.add(new Client());
        clients.add(new Client());
        clients.add(new Client());
        clients.add(new Client());
        clients.add(new Client());

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            exec.execute(new ATMOperations(new ATM(bank), clients));
        }

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();

    }
}
