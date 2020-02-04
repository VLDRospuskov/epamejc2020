package homework.homework2.recursion;

public class Fibonacci {
    public static int getFibonacci(int index) {

        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index == 0 || index == 1) {
            return 1;
        }

        final int FIRST_CALCULATED_INDEX = 2;

        return getNextFibonacci(1, 1, index, FIRST_CALCULATED_INDEX);
    }

    private static int getNextFibonacci(int prev, int curr, int requiredIndex, int currentIndex) {

        int value = prev + curr;
        if (currentIndex < requiredIndex) {
            value = getNextFibonacci(curr, value, requiredIndex, currentIndex + 1);
        }

        return value;
    }
}
