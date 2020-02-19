package homeworks.recursion_hw2_4.task4_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

    public void run() {
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

    private static int calculateFibonacci(int n) {
        if ((n == 1) || (n == 2)) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        return calculateFibonacci(n - 2) + calculateFibonacci(n - 1);
    }
}
