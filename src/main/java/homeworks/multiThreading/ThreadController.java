package homeworks.multiThreading;

public class ThreadController {

    public final static Object lock = new Object();

    public void start() {

        Bank bank = new Bank("Tinkovv", 2500, false);


        ATM atm1 = new ATM("ATM1",500);
        ATM atm2 = new ATM("ATM2",500);
        ATM atm3 = new ATM("ATM3",500);
        ATM atm4 = new ATM("ATM4",500);


        User user1 = new User("Boris1", 250, false);
        User user2 = new User("Vladimir2", 250, false);
        User user3 = new User("Dmitriy3", 250, false);
        User user4 = new User("Vladimir4", 250, false);

        ThreadATMOperations threadATMOperations1 = new ThreadATMOperations(bank, user1, atm1);
        ThreadATMOperations threadATMOperations2 = new ThreadATMOperations(bank, user2, atm2);
        ThreadATMOperations threadATMOperations3 = new ThreadATMOperations(bank, user3, atm3);
        ThreadATMOperations threadATMOperations4 = new ThreadATMOperations(bank, user4, atm4);

        threadATMOperations1.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
        threadATMOperations4.start();
    }
}
