package main.homeworks.homework2.arrays.charArraygenerationmain;

import java.util.Scanner;

public class RandomLetterGeneration {
    private char[][] array;
    private int n;
    private int m;

    public void run() {
        inputDimension();
        createArray();
        fillArray();
        outputArray();
    }

    private void inputDimension() {
        System.out.print("Please, enter the dimension of the array: ");
        boolean valueOk = false;
        while (!valueOk) {
            try {
                Scanner inInt = new Scanner(System.in);
                n = inInt.nextInt();
                m = inInt.nextInt();
                if (n <= 0 || m <= 0) {
                    throw new ArithmeticException();
                }
                valueOk = true;
                inInt.close();
            } catch (ArithmeticException e) {
                System.out.println("Enter a positive value.");
            } catch (Exception e) {
                System.out.println("You entered the invalid value :(");
            }
        }
    }

    private void createArray() {
        array = new char[n][m];
    }

    private void fillArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = (char) (Math.random() * 26 + 97);
            }
        }
    }

    public void outputArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
