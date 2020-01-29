package main.homeworks.hw5.recursion_3;

import java.util.Scanner;

public class CountNumberOfDigitsInNumber {

    public void run() {
        int n = scanNumber();
        System.out.println("Amount of digits: " + countNumberOfDigits(n, 0));
    }

    public int scanNumber() {
        int n = 0;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Please enter number: ");
            n = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong enter! " + e);
            System.exit(0);
        } finally {
            scan.close();
        }

        return n;
    }

    private static int countNumberOfDigits(int n, int count) {
        if(Math.abs(n) < 10) {
            return ++count;
        }

        n /= 10;
        count++;

        return countNumberOfDigits(n, count);
    }

}
