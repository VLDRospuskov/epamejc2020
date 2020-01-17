package main.homeworks.hw2.recursion_4_1;

import java.util.Scanner;

public class FibonacciGen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        System.out.print("Please enter count of fibonacci numbers to gen(1 - 44): ");

        try {
            count = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            scan.close();
        }

        if (count < 1 || count > 44) {
            System.out.println("Wrong enter!");
        } else {
            System.out.println(fGen(0, 1, count));
        }
    }

    private static String fGen(int n1, int n2, int count) {
        int n3 = n1 + n2;
        if (count < 2) {
            return n3 + " ";
        }
        count--;
        return n3 + " " + fGen(n2, n3, count);
    }
}
