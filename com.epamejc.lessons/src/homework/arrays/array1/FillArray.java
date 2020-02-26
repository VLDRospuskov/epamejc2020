package homework.arrays.array1;

import java.util.Scanner;

public class FillArray {

    private double rand_num;
    private char[][] charArray;
    private int m;
    private int n;

    public void run() {
        input();
        fillTheArray();
    }

    private void input() {
        Scanner in = new Scanner(System.in);

        System.out.print("Input height: ");
        m = in.nextInt();
        System.out.print("Input length: ");
        n = in.nextInt();
    }

    private void fillTheArray() {
        charArray = new char[m][n];

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                do {
                    rand_num = Math.random();
                    rand_num = rand_num * 1000;
                } while (rand_num < 97 || rand_num > 122);

                char random = (char) rand_num;
                charArray[i][j] = random;
                System.out.printf("%c ", charArray[i][j]);
            }
            System.out.println();
        }

    }
}