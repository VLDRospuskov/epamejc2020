package homeworks.homework3;

import java.util.Random;

public class MultipleArrayBuilder {

    public static char[][] createArray(int line, int column) {
        char[][] arr = new char[line][column];
        Random rnd = new Random();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (char) (97 + rnd.nextInt(122 - 97));
            }
        }

        return arr;
    }

    public static void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void printEven(char[][] arr) {
        System.out.print("even chars: ");

        for (int i = 1; i < arr.length; i += 2) {
            for (int j = 1; j < arr[i].length; j += 2) {
                System.out.print(arr[i][j]);
            }
        }

        System.out.println();
    }

    public static void printOdd(char[][] arr) {
        System.out.print("odd chars: ");

        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < arr[i].length; j += 2) {
                System.out.print(arr[i][j]);
            }
        }

        System.out.println();
    }

    public static void pyramid(int n) {
        int[][] twoDimArray = new int[n][];

        for (int i = 0; i < n; i++) {
            twoDimArray[i] = new int[n - i];
        }

        System.out.println("Behold a pyramid!");

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                System.out.print(twoDimArray[i][j]);
            }
            System.out.println();
        }
    }

}
