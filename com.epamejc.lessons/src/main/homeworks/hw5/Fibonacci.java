package main.homeworks.hw5;

public class Fibonacci {

    public static Integer fibonacciSeries(Integer numberPlace) {
        if (numberPlace == 0 || numberPlace == 1) {
            return 1;
        }
        return fibonacciSeries(numberPlace - 1) + fibonacciSeries(numberPlace - 2);
    }

}
