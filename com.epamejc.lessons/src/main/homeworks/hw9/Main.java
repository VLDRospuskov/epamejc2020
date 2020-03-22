package main.homeworks.hw9;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        final User user = new User("Margo", 450.);
        final User user2 = new User("Elliot", 3000.);
        final User user3 = new User("Alice", 575.);
        final User user4 = new User("Penny", 1240.);
        final User user5 = new User("Quentin", 1050.);

        ThreadBalanceOperations thread1 = new ThreadBalanceOperations(user);
        ThreadBalanceOperations thread2 = new ThreadBalanceOperations(user2);
        ThreadBalanceOperations thread3 = new ThreadBalanceOperations(user3);
        ThreadBalanceOperations thread4 = new ThreadBalanceOperations(user4);
        ThreadBalanceOperations thread5 = new ThreadBalanceOperations(user5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
