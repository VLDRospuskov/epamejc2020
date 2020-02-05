package main.homeworks.recursion_hw2_4.task4_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Power {

    public void run() {
        int number = 0;
        int pow = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input number");
            number = scanner.nextInt();
            System.out.println("Input pow");
            pow = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
            e.printStackTrace();
        }
        System.out.println(Power.calcPow(number, pow));
    }

    private static int calcPow(int n, int p) {
        if (p == 0) {
            return 1;
        }
        return n * calcPow(n, p - 1);
    }
}
