package homeworks.multiThreading;

import lombok.SneakyThrows;


public class ThreadController {

    @SneakyThrows
    public void start() {

        Bank bank = new Bank("Tinkovv", 2500, false);


        ATM atm1 = new ATM("ATM1",500);
        ATM atm2 = new ATM("ATM2",500);
        ATM atm3 = new ATM("ATM3",500);
        ATM atm4 = new ATM("ATM4",500);


        User user1 = new User("Boris1", 500, false);
        User user2 = new User("Vladimir2", 500, false);
        User user3 = new User("Dmitriy3", 500, false);
        User user4 = new User("Vladimir4", 500, false);

        ThreadATMOperations threadATMOperations1 = new ThreadATMOperations(bank, user1, atm1);
        ThreadATMOperations threadATMOperations2 = new ThreadATMOperations(bank, user2, atm2);
        ThreadATMOperations threadATMOperations3 = new ThreadATMOperations(bank, user3, atm3);
        ThreadATMOperations threadATMOperations4 = new ThreadATMOperations(bank, user4, atm4);

        threadATMOperations1.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
        threadATMOperations4.start();

        threadATMOperations1.join();
        threadATMOperations2.join();
        threadATMOperations3.join();
        threadATMOperations4.join();

        double sum = bank.getBalance() + atm1.getBalance() + atm2.getBalance() + atm3.getBalance()
                + atm4.getBalance() + user1.getBalance() + user2.getBalance() + user3.getBalance()
                + user4.getBalance();

        System.out.println("Expected sum: 6500\n" +
                "Actual sum:   " + sum);
    }
}
