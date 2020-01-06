package main.homeworks.hw3.arrays.secondarraytask;

import java.util.Random;

class RandomCharsArray {

    static char[][] getCharsArray(int n) {

        char[][] charArray = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Random r = new Random();
                charArray[i][j] = (char) (r.nextInt(26) + 'a');
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        return charArray;
    }

    static void strategyAoutput(char[][] arrayA) {
        System.out.println("Strategy A output");
        for (int i = 0; i < arrayA.length; ) {
            for (int j = 0; j < arrayA[0].length; ) {
                System.out.print(arrayA[i][j]);
                j = j + 2;
            }
            i = i + 2;
        }
        System.out.println("\n");
    }

    static void strategyBoutput(char[][] arrayB) {
        System.out.println("Strategy B output");
        for (int i = 1; i < arrayB.length; ) {
            for (int j = 1; j < arrayB.length; ) {
                System.out.print(arrayB[i][j]);
                j = j + 2;
            }
            i = i + 2;
        }
        System.out.println("\n");
    }
}
