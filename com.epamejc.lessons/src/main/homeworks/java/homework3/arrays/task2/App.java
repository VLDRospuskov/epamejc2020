package main.homeworks.java.homework3.arrays.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private ArrayMaker arrayMaker;
    private String strategy;
    private Scanner sc;
    private int dimension1;
    private int dimension2;

    public App(Scanner sc) {
        arrayMaker = new ArrayMaker();
        this.sc = sc;
    }

    public void run() {
        System.out.println("Enter array size (int int): ");
        getInputForArray();
        char[][] randomCharArray = arrayMaker.makeArray(dimension1, dimension2);
        arrayMaker.printArray(randomCharArray);
        getInputForStrategy();
        String stringViaStrategy = new StringMaker(randomCharArray).makeString(strategy);
        System.out.println(stringViaStrategy);
    }

    private void getInputForArray() {
        try {
            dimension1 = sc.nextInt();
            dimension2 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input");
            throw new InputMismatchException();
        }
        sc.nextLine();
    }

    private void getInputForStrategy() {
        System.out.println("Enter strategy (A / B) :");
        strategy = sc.nextLine();
    }
}
