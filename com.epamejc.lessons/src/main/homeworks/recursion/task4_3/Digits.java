package main.homeworks.recursion.task4_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Digits {

    public void run() {
        System.out.println("Input number to calculate ammount of Digits");
        int number = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
            e.printStackTrace();
        }
        System.out.println(Digits.getAmountOfDigits(number));
    }

    private static int getAmountOfDigits(int n) {
        if (n / 10 == 0) {
            return 1;
        }
        return 1 + getAmountOfDigits(n / 10);
    }

}
