package main.homeworks.hw5.recursion.fibbonachi;

class Fibbonachi {

    static long fibbonachi(long n) {

        if (n < 0) {
            throw new ArithmeticException("Invalid input");
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibbonachi(n - 2) + fibbonachi(n - 1);
    }
}
