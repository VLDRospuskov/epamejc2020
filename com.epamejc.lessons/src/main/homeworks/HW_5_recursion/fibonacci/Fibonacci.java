package homeworks.HW_5_recursion.fibonacci;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

/**
 * The program counts the time, that it takes to calculate Fibonacci.
 * Input is limited from 0 to 50.
 */

class Fibonacci {

    public void run() {
        try {
            System.out.println(Helper.GREETING);

            while (true) {
                int input = Helper.getIntInLoop("Write down the ordinal Fibonacci number: ");
                int n1 = Math.max(0, input);
                int n2 = Math.min(50, n1);
                printFibonacci(n2);
            }
        } catch (CancellationException ignored) {}
    }

    private void printFibonacci(int input) {
        long startCount = System.currentTimeMillis();
        int fibonacci = getFibonacci(input);
        long finishCount = System.currentTimeMillis();

        System.out.println("The " + input + " Fibonacci number is: " + fibonacci +
                ". It took " + (finishCount - startCount) + " millisecond to count it.");
        System.out.println("------------------------------------------------");
    }

    public int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }
}
