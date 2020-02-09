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

    public int scanCountOfNumbers() {
        Scanner scan = new Scanner(System.in);
        int count = 0;

        try {
            System.out.print("Please enter count of fibonacci numbers to gen(1 - 44): ");
            count = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong enter! " + e);
        } finally {
            scan.close();
        }

        return count;
    }

    public String generateFibonacciNumbers(int n1, int n2, int count) {
        int n3 = n1 + n2;

        if (count < 2) {
            return n3 + " ";
        }

        count--;

        return n3 + " " + generateFibonacciNumbers(n2, n3, count);
    }

}
