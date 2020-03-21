package main.homeworks.homework9;

import java.util.ArrayList;
import java.util.List;

public class ThreadMoneyTransfer extends Thread {

    //private static List<ATM> listATM;
    private ATM ATMInstance;
    private Person person;
    private double amount;
    private boolean getMoney;
    private static final Object lock = new Object();

    public ThreadMoneyTransfer(ATM ATMInstance, Person person, double amount, boolean getMoney) {
        this.ATMInstance = ATMInstance;
        this.person = person;
        this.amount = amount;
        this.getMoney = getMoney;
        //listATM = new ArrayList<>();
        //listATM.add(ATMInstance);
    }

    @Override
    public void run() {
        /*if (!listATM.isEmpty()) {
            if (getMoney) {
                listATM.get(0).deposit(amount,person);
            } else {
                listATM.get(0).getAmount(amount,person);
            }
        }*/
        synchronized (lock) {
            if (getMoney) {
                ATMInstance.deposit(amount, person);
            } else {
                ATMInstance.getAmount(amount, person);
            }
        }
    }
}
