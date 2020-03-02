package main.homeworks.homework5.fibonaccinumbers;

import java.util.Scanner;

public class Fibonacci {

    private int number;

    public void run() {
        System.out.print("Enter number: ");
        input();
        System.out.println(fibonacciSearch(number));
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Enter integer.");
            input();
        }
        scanner.close();
    }

    public long fibonacciSearch(long n) {
        if (n <= 2) {
            int i = 1;
            return i;
        }
        return fibonacciSearch(n-1) + fibonacciSearch(n-2);
    }

}
