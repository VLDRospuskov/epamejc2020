package main.homeworks.homework9;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Igor", randomDouble());
        Person person2 = new Person("Mark", randomDouble());
        Person person3 = new Person("Nina", randomDouble());

        Person person4 = new Person("Timur", randomDouble());
        Person person5 = new Person("Denis", randomDouble());
        Person person6 = new Person("Kingjames", randomDouble());

        ATM atm1 = new ATM("12AD34", randomDoubleATM());
        ATM atm2 = new ATM("60DA98", randomDoubleATM());
        ATM atm3 = new ATM("12BB00", randomDoubleATM());

        ThreadMoneyTransfer threadMoneyTransfer1 = new ThreadMoneyTransfer(atm1, person1, randomDouble(), randomBoolean());
        ThreadMoneyTransfer threadMoneyTransfer2 = new ThreadMoneyTransfer(atm2, person2, randomDouble(), randomBoolean());
        ThreadMoneyTransfer threadMoneyTransfer3 = new ThreadMoneyTransfer(atm3, person3, randomDouble(), randomBoolean());

        ThreadMoneyTransfer threadMoneyTransfer4 = new ThreadMoneyTransfer(atm1, person4, randomDouble(), randomBoolean());
        ThreadMoneyTransfer threadMoneyTransfer5 = new ThreadMoneyTransfer(atm2, person5, randomDouble(), randomBoolean());
        ThreadMoneyTransfer threadMoneyTransfer6 = new ThreadMoneyTransfer(atm3, person6, randomDouble(), randomBoolean());

        threadMoneyTransfer1.start();
        threadMoneyTransfer2.start();
        threadMoneyTransfer3.start();
        threadMoneyTransfer4.start();
        threadMoneyTransfer5.start();
        threadMoneyTransfer6.start();
    }

    public static double randomDouble() {
        return Math.random() * 100_000;
    }

    public static double randomDoubleATM() {
        return Math.random() * 200_000 + 100_000;
    }

    public static boolean randomBoolean() {
        return new Random().nextBoolean();
    }

}

