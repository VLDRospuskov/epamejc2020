package homeworks.homework3.arrays.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PyramidMaker {

    private Scanner sc;
    private int height;

    public PyramidMaker(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("Enter pyramid height: ");
        getInput();
        makePyramid(height);
    }

    private void printStars(int amount) {
        int n = 0;
        while (n < amount) {
            System.out.print("*");
            n++;
        }
        System.out.println();
    }

    private void printWhitespaces(int amount) {
        int n = 0;
        while (n < amount) {
            System.out.print(" ");
            n++;
        }
    }

    private void makePyramid(int height) {
        int n = 1;
        while (n <= height) {
            printWhitespaces(height - n);
            printStars(n + (n - 1));
            n++;
        }
    }

    private void getInput() {
        try {
            height = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input");
        }
    }
}
