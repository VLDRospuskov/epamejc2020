package main.homeworks.hw5.recursion.power;

class Power {

    static long power(int x, int n) {
        if (x == 0 && n == 0) {
            throw new ArithmeticException("Invalid input");
        }
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        long result = 1;
        if (x == 1) {
            return result;
        }
        result = x * power(x, n - 1);
        return result;


    }

}
