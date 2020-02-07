package main.homeworks.homework5.fibonaccinumbers;

import java.util.Scanner;

public class Fibonacci {
    public void run() {
        System.out.print("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacciSearch(n));
        scanner.close();
    }

    private long fibonacciSearch(long n) {
        if (n <= 2) {
            int i = 1;
            return i;
        }
        return fibonacciSearch(n-1) + fibonacciSearch(n-2);
    }
}
