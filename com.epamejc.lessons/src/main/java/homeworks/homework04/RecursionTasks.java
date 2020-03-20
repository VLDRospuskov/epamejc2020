package homeworks.homework04;

public class RecursionTasks {

    /**
     * Task 4.1
     * Return n-th fibonacci number.
     * Values begin with 1, 1, 2, ...
     * Counting begins with 1
     * For example, if you want 4th fibonacci number, function gives you 3
     */
    public int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Task 4.2
     * Returns b-th power of a.
     */
    public int power(int value, int power) {
        if (power == 0) return 1;
        if (power == 1) return value;
        return value * power(value, power - 1);
    }

    /**
     * Task 4.3
     * Return number of digits in value.
     */
    public int numberOfDigits(int value) {
        if (value / 10 < 1) return 1;
        return numberOfDigits(value / 10) + 1;
    }

}

