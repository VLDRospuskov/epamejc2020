package homeworks.HW5_recursion.fibonacciNumber;

import java.util.Scanner;

public class FibonacciNumber {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (!isExitNeeded) {
            int inputNumber = enterNumber(scan);
            if (!isExitNeeded) {
                System.out.println("Fibonacci number is: " + fibonacciCalc(inputNumber));
            }
        }
        scan.close();
        System.out.println("Program ends. Goodbye.");
    }

    /**
     * Method for recursive Fibonacci calculation
     *
     * @param n input number
     * @return Fibonacci number
     */
    private static int fibonacciCalc(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciCalc(n - 1) + fibonacciCalc(n - 2);
        }
    }

    /**
     * Method for entering a new number
     *
     * @param scan scanner object
     * @return entered number
     */
    private int enterNumber(Scanner scan) {
        boolean isInputCorrect = false;
        int inputNumber = 0;
        while (!isInputCorrect) {
            System.out.print("Type -1 to exit or enter integer number " +
                    "to calculate fibonacci number (in range 1 - 30): ");
            String inputString = scan.nextLine();
            try {
                inputNumber = Integer.parseInt(inputString);
                if (inputNumber == -1) {
                    isExitNeeded = true;
                    break;
                } else if (inputNumber > 0 && inputNumber <= 30) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println("Wrong input. Enter correct number");
            }
        }
        return inputNumber;
    }
}


