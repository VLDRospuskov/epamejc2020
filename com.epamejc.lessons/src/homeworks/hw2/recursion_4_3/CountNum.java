package homeworks.hw2.recursion_4_3;

import java.util.Scanner;

public class CountNum {
    public static void main(String[] args) {
        int n = 0;
        boolean error = false;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Please enter number: ");
            n = scan.nextInt();
        } catch (Exception e) {
            error = true;
            System.out.println("Wrong enter! " + e);
        } finally {
            scan.close();
        }

        if (!error) {
            System.out.println("Amount of numbers: " + numOfNum(n, 0));
        }
    }

    private static int numOfNum(int n, int count) {
        if(Math.abs(n) < 10) {
            return ++count;
        }

        n /= 10;
        count++;
        return numOfNum(n, count);
    }
}
