package lesson2;

import java.util.Random;
import java.util.Scanner;

public class Task22 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter width ");
        int width = Integer.parseInt(in.nextLine());
        System.out.print("Enter height ");
        int height = Integer.parseInt(in.nextLine());
        char[][] arr = enterRandArr(width, height);

        System.out.print("Enter strategy(A or B) ");
        String typeOfStrategy = (in.nextLine());
        applyStrategy(arr, typeOfStrategy, width, height);
    }

    private static boolean IsEven(int num) {
        return num % 2 == 0;
    }

    private static char[][] enterRandArr(int w, int h) {
        Random r = new Random();
        char[][] arr = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = (char) (r.nextInt(94) + 33);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return arr;

    }

    private static void applyStrategy(char arr[][], String strategy, int w, int h) {
        int strategyNum = 0;
        if ((strategy.equals("B")) || (strategy.equals("b"))) {
            strategyNum = 1;
        }
        for (int i = 0; i < h; i++) {
            if (IsEven(i + strategyNum)) {
                for (int j = 0; j < w; j++) {
                    if (IsEven(j + strategyNum)) {
                        System.out.print((arr[i][j]));
                    }
                }
            }
        }
    }
}