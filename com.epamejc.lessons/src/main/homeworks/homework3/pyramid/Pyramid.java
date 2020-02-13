package main.homeworks.homework3.pyramid;

import java.util.Scanner;

public class Pyramid {

    private int n;

    public void run() {
        System.out.print("Please, enter the pyramid height: ");
        do {
            n = inputInt();
        } while (!isPositive());
        generation();
    }

    private int inputInt() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Enter an integer value.");
            scanner.next();
        }
        int value = scanner.nextInt();
        return value;
    }

    private boolean isPositive() {
        if (n > 0) {
            return true;
        } else {
            System.out.println("Enter a positive number.");
            return false;
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

