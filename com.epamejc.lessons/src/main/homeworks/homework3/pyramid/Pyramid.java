package main.homeworks.homework3.pyramid;

import java.util.Scanner;

public class Pyramid {

    private int n;

    public void run() {
        Scanner in = new Scanner(System.in);
        String input;
        boolean valueOk = false;
        System.out.print("Please, enter the pyramid height: ");
        while (!valueOk) {
            try {
                input = in.nextLine();
                n = Integer.parseInt(input);
                if (n < 0 || n > 100) {
                    throw new ArithmeticException();
                }
                valueOk = true;
                generation();
            } catch (Exception e) {
                System.out.println("Enter a positive number less than 100!");
            }
        }
        in.close();
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

