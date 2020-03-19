package homeworks.java.hw5.recursion_3;

import java.util.Scanner;

public class NumberOfDigitsCounter {

    public void run() {
        int number = scanNumber();
        System.out.println("Amount of digits: " + countNumberOfDigits(number, 0));
    }

    /**
     * I did not close the Scanner because:
     * https://coderanch.com/wiki/678613/Don-close-Scanner-tied-System
     * https://www.omnijava.com/2018/08/23/if-you-are-using-javas-scanner-class-for-keyboard-input-then-you-might-be-doing-it-wrong/
     * https://stackoverflow.com/questions/52040576/scanner-close-method-closes-all-scanners-why
     */
    private int scanNumber() {
        int number = 0;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Please enter number: ");
            number = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong enter! " + e);
            System.exit(0);
        }
        return number;
    }

    public int countNumberOfDigits(int number, int count) {
        if(Math.abs(number) < 10) {
            return ++count;
        }

        number /= 10;
        count++;

        return countNumberOfDigits(number, count);
    }

}
