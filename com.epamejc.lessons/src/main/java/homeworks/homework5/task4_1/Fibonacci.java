package homeworks.homework5.task4_1;

public class Fibonacci {
    
    public static int calculateFibonacci(int n) {
        if ((n == 1) || (n == 2)) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        return calculateFibonacci(n - 2) + calculateFibonacci(n - 1);
    }
    
}
