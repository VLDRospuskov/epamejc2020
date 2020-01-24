package main.homeworks.recursion.task4_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4_2 {
    public static void main(String[] args) {

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
}
