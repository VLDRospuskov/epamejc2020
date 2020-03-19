package homeworks.java.hw9;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(50000);

        List<ATM> atmList = new ArrayList<>();
        atmList.add(new ATM(800, 111, bank));
        atmList.add(new ATM(800, 57, bank));
        atmList.add(new ATM(800, 17, bank));

        List<User> userList = new ArrayList<>();
        userList.add(new User("Vladimir", 22000.00));
        userList.add(new User("Boris", 15000.50));
        userList.add(new User("Dmitriy", 75000.70));
        userList.add(new User("Maria", 500.00));

        ThreadATMOperations threadATMOperations = new ThreadATMOperations(bank, atmList, userList);
        ThreadATMOperations threadATMOperations1 = new ThreadATMOperations(bank, atmList, userList);
        ThreadATMOperations threadATMOperations2 = new ThreadATMOperations(bank, atmList, userList);
        ThreadATMOperations threadATMOperations3 = new ThreadATMOperations(bank, atmList, userList);

        threadATMOperations.start();
        threadATMOperations1.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
    }
    
}