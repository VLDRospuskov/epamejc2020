package homeworks.java.hw5.recursion_1;

import java.util.Scanner;

public class FibonacciGenerator {

    public void run() {
        int count = scanCountOfNumbers();

        if (count < 1 || count > 44) {
            System.out.println("Wrong enter!");
        } else {
            System.out.println("Fibonacci numbers: " + generateFibonacciNumbers(0, 1, count));
        }
    }

    private int scanCountOfNumbers() {
        Scanner scan = new Scanner(System.in);
        int count = 0;

        try {
            System.out.print("Please enter count of fibonacci numbers to gen(1 - 44): ");
            count = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong enter! " + e);
        }

        return count;
    }

    public String generateFibonacciNumbers(int num1, int num2, int count) {
        int num3 = num1 + num2;

        if (count < 2) {
            return num3 + " ";
        }

        count--;

        return num3 + " " + generateFibonacciNumbers(num2, num3, count);
    }

}
