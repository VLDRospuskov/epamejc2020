package main.homeworks.recursion.task4_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4_1 {
    public static void main(String[] args) {
        System.out.println("Input n to get N-th number in fibonacci");
        int number = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
            e.printStackTrace();
        }
        System.out.println(Fibonacci.calculateFibonacci(number));
    }
}
