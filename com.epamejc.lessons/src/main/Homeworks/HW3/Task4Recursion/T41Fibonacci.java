package main.Homeworks.HW3.Task4Recursion;

import java.util.Scanner;

public class T41Fibonacci {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int nth = scanner.nextInt();
        System.out.println(fibonacci(nth));
    }

    private int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
