package homeworks.java.hw9;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        GeneralBalance.commonATMBalance = 1000;

        ATM atm1 = new ATM();
        ATM atm2 = new ATM();
        ATM atm3 = new ATM();
        ATM atm4 = new ATM();

        Customer andrei = new Customer("Andrei", 570);
        Customer voland = new Customer("Voland", 125);
        Customer annushka = new Customer("Annushka", 67);
        Customer garri = new Customer("Garri", 495);
        Customer artur = new Customer("Artur", 73);
        Customer maria = new Customer("Maria-Antuanetta", 859);
        Customer bathory = new Customer("Bathory", 97);

        MultithreadedOperationsWithBalance thread1 = new MultithreadedOperationsWithBalance(atm1, andrei);
        MultithreadedOperationsWithBalance thread2 = new MultithreadedOperationsWithBalance(atm3, annushka);
        MultithreadedOperationsWithBalance thread3 = new MultithreadedOperationsWithBalance(atm1, voland);
        MultithreadedOperationsWithBalance thread4 = new MultithreadedOperationsWithBalance(atm2, garri);
        MultithreadedOperationsWithBalance thread5 = new MultithreadedOperationsWithBalance(atm2, artur);
        MultithreadedOperationsWithBalance thread6 = new MultithreadedOperationsWithBalance(atm4, maria);
        MultithreadedOperationsWithBalance thread7 = new MultithreadedOperationsWithBalance(atm3, andrei);
        MultithreadedOperationsWithBalance thread8 = new MultithreadedOperationsWithBalance(atm4, bathory);

        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);
        thread3.start();
        Thread.sleep(100);
        thread4.start();
        Thread.sleep(100);
        thread5.start();
        Thread.sleep(100);
        thread6.start();
        Thread.sleep(100);
        thread7.start();
        Thread.sleep(100);
        thread8.start();
        Thread.sleep(100);

    }

}
