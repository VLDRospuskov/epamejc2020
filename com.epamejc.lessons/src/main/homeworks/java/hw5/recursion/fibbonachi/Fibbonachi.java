package homeworks.java.hw5.recursion.fibbonachi;

public class Fibbonachi {

    public static long findInFibbonachiRow(long n) {

        if (n < 0) {
            throw new ArithmeticException("Invalid input");
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return findInFibbonachiRow(n - 2) + findInFibbonachiRow(n - 1);
    }
}
