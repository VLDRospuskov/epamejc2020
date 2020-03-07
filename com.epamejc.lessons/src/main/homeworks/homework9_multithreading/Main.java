package homeworks.homework9_multithreading;

import homeworks.homework9_multithreading.service.BankOperations;

public class Main {
    public static void main(String[] args) {
        BankOperations operations = new BankOperations();
        Thread thread = new Thread(operations);
        thread.start();
    }
}
