package main.homeworks.recursion.task4_1;

public class Fibonacci {

    public int calculate(int n) {
        if ((n == 1) ||(n == 2)) {
            return 1;
        }
        return calculate(n-2) + calculate(n-1);
    }
}
