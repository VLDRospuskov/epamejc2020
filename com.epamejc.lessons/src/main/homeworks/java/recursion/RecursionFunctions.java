package homeworks.java.recursion;

public class RecursionFunctions {

    //finds a (num) element of Fibonacci sequence
    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) return 1;

        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static double pow(double num, int pow) {
        if (pow == 0)
            return 1;
        else if (pow > 0)
            return num * pow(num, pow - 1);
        else
            return 1 / num * pow(num, pow + 1);
    }

    public static int numOfDigits(int num) {

        if (num <= 9) {
            return 1;
        } else {
            return 1 + numOfDigits(num / 10);
        }
    }
}
