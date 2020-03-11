package main.homeworks.java.homework9;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ATMOperations implements Runnable {

    private ATM atm;
    private List<Client> clients;
    private Bills[] bills = Bills.values();

    public ATMOperations(ATM atm, List<Client> clients) {
        this.atm = atm;
        this.clients = clients;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(150);
                operate();
            }
        } catch (InterruptedException e) {
            System.out.println(atm + " is closed.");
        }
    }


    private void operate() {
        Random rand = new Random();
        boolean b = rand.nextBoolean();
        int nClient = rand.nextInt(clients.size());
        int amount = bills[rand.nextInt(bills.length)].getValue() * (rand.nextInt(5) + 1);
        Client currentClient = clients.get(nClient);

        try {
                if (b) {
                    atm.withdraw(amount);
                    currentClient.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + "    " + currentClient + "used: " +
                            atm + " got: " + amount + ". Current balance: " + currentClient.getBalance() +
                            ". Current walletMoney: " + currentClient.getWalletMoney() +
                            "\n" + atm + " Current balance: " + atm.getBalance());
                } else {
                    currentClient.withdraw(amount);
                    atm.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + "    " + currentClient + "used: " +
                            atm + " deposited: " + amount + ". Current balance: " + currentClient.getBalance() +
                            ". Current walletMoney: " + currentClient.getWalletMoney() +
                            " \n" + atm + " Current balance: " + atm.getBalance());
                }

        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
}
