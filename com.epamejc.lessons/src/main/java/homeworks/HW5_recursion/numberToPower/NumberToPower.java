package homeworks.HW5_recursion.numberToPower;

import java.util.Scanner;

public class NumberToPower {
    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                long base = enterNumber(scan, "BASE");
                if (!isExitNeeded) {
                    long power = enterNumber(scan, "POWER");
                    if (!isExitNeeded) {
                        System.out.println(base + "^" + power + " is: " + powerNumber(base, power));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println("Program ends. Goodbye.");
        }
    }

    /**
     * Method for initializing base and degree variables
     *
     * @param scan scanner object
     * @param type variable type
     * @return number of base or power
     */
    private long enterNumber(Scanner scan, String type) {
        boolean isInputCorrect = false;
        long inputNumber = 0;
        while (!isInputCorrect) {
            System.out.print("Type -1 to exit or enter integer number for "
                    + type + " to calculate power of base (in range 1 - 15): ");
            String inputString = scan.nextLine();
            try {
                inputNumber = Integer.parseInt(inputString);
                if (inputNumber == -1) {
                    isExitNeeded = true;
                    break;
                } else if (inputNumber > 0 && inputNumber <= 15) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println("Wrong input. Enter a correct number.");
            }
        }
        return inputNumber;
    }

    /**
     * Method for recursively calculating the power of a number
     *
     * @param number number
     * @param power  power
     * @return calculated number
     */
    public static long powerNumber(long number, long power) {
        if (power == 1)
            return number;
        return number * powerNumber(number, power - 1);
    }
}


