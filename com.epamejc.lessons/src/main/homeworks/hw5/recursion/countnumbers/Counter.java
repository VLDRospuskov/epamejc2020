package main.homeworks.hw3.recursion.countnumbers;

class Counter {

    static int counterOfNumbers(long n) {

        if (n < 0) {
            throw new ArithmeticException("Invalid input");
        }

        int result = 1;

        if (n / 10 == 0) {
            return result;
        }

        result = result + counterOfNumbers(n / 10);
        return result;
    }

}
