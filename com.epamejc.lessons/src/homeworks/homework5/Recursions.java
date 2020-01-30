package homeworks.homework5;

public class Recursions {

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public int exponent(int n, int pow) {
        if (pow == 1) {
            return n;
        } else {
            return n * exponent(n, pow - 1);
        }
    }

    public int numbersQty(int n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + numbersQty(n / 10);
        }
    }

}
