package main.homeworks.homework2.arrays.pyramid;

import java.util.Scanner;

public class Pyramid {
    private int n;

    public void run() {
        System.out.print("Please, enter the pyramid height: ");
        Scanner in = new Scanner(System.in);
        try {
            n = in.nextInt();
            if (n <= 0) {
                throw new ArithmeticException();
            }
            generation();
        } catch (ArithmeticException e) {
            System.out.println("You input invalid value!");
        } catch (Exception e) {
            System.out.println("Enter an integer value.");
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

