package main.homeworks.java.homework3.arrays.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private ArrayMaker arrayMaker;
    private int dimension1;
    private int dimension2;
    private Scanner sc;

    public App(Scanner sc) {
        arrayMaker = new ArrayMaker();
        this.sc = sc;
    }

    public void run() {
        System.out.println("Enter array size (int int): ");
        getInput();
        char[][] randomCharArray = arrayMaker.makeArray(dimension1, dimension2);
        arrayMaker.printArray(randomCharArray);
    }

    private void getInput() {
        try {
            dimension1 = sc.nextInt();
            dimension2 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input");
            throw new InputMismatchException();
        }
    }
}
