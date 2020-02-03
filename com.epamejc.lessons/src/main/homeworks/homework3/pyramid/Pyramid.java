package main.homeworks.homework3.pyramid;

import java.util.Scanner;

public class Pyramid {
    private int n;

    public void run() {
        System.out.print("Please, enter the pyramid height: ");
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            n = in.nextInt();
            if (n <= 0) {
                throw new ArithmeticException();
            }
            generation();
        } catch (Exception e) {
            System.out.println("Enter an integer value.");
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private void generation() {
        char[][] pyrArr = new char[n][n];
        for (int i = 0, max = n; i < n; i++, max--) {
            for (int j = 0; j < max; j++) {
                pyrArr[i][j] = '\u25bc';
                System.out.print(pyrArr[i][j]);
            }
            System.out.println();
        }
    }
}

