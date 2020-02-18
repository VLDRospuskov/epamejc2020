package homeworks.java.hw5.recursion_3;

import java.util.Scanner;

public class NumberOfDigitsCounter {

    public void run() {
        int number = scanNumber();
        System.out.println("Amount of digits: " + countNumberOfDigits(number, 0));
    }

    public int scanNumber() {
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
