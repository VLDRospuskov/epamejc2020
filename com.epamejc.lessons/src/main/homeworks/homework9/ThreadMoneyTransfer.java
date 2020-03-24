package main.homeworks.homework9;

public class ThreadMoneyTransfer extends Thread {

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
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (getMoney) {
                ATMInstance.deposit(amount, person);
            } else {
                ATMInstance.getAmount(amount, person);
            }
            System.out.println("-----------");
        }
    }

}
