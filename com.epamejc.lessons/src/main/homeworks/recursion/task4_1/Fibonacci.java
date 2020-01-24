package main.homeworks.recursion.task4_1;

public class Fibonacci {

    public int calculateFibonacci(int n) {
        if ((n == 1) || (n == 2)) {
            return 1;
        }
        return calculateFibonacci(n - 2) + calculateFibonacci(n - 1);
    }
}
