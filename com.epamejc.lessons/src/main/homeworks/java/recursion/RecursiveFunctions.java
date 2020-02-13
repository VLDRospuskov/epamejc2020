package homeworks.java.recursion;

/**
 * The {@code RecursiveFunctions class} represents a set of recursive math utils.
 *
 * @author Vladimir Ivanov
 */
public class RecursiveFunctions {

    /**
     * Method recursively finds the number in the Fibonacci sequence by index. For example:
     * <blockquote><pre>
     *
     * The index is 7, the Fibonacci sequence to 7th term looks like: 0, 1, 1, 2, 3, 5, 8, 13;
     * so the output will be 13.
     *
     * </pre></blockquote>
     *
     * @param index This is the index of the number in the Fibonacci sequence starting from {@code 0}. So the first
     *              element of the sequence has an index {@code 0}, the second one - {@code 1} and so on.
     * @return a member of the Fibonacci sequence at the <b>index</b> position.
     */
    public static int fibonacci(int index) {

        if (index == 0) {
            return 0;
        }
        if (index == 1) return 1;

        return fibonacci(index - 1) + fibonacci(index - 2);

    }

    /**
     * Method recursively calculates the power of a number.
     *
     * @param base  The double value of number to be raised to a power.
     * @param power The integer value of power.
     * @return double result of the exponentiation
     */
    public static double pow(double base, int power) {

        if (power == 0)
            return 1;
        else if (power > 0)
            return base * pow(base, power - 1);
        else
            return 1 / base * pow(base, power + 1);

    }

    /**
     * Method recursively calculates the number of digits in number
     *
     * @param number Any integer number.
     * @return the number of digits in the original number
     */
    public static int numOfDigits(int number) {

        if (number <= 9) {
            return 1;
        } else {
            return 1 + numOfDigits(number / 10);
        }

    }

}
