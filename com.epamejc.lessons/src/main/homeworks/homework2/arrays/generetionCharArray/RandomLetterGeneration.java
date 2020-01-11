package main.homeworks.homework2.arrays.generetionCharArray;

import java.util.Scanner;

public class RandomLetterGeneration {
    private char[][] array;
    private int n;
    private int m;

    public void run() {
        System.out.print("Please, enter the dimension of the array: ");
        Scanner in = new Scanner(System.in);
        try {
            n = in.nextInt();
            m = in.nextInt();
        } catch (Exception e) {
            System.out.println("You entered invalid value :(");
        }
        setN(n);
        setM(m);
        createArray();
        fillArray();
        outputArray();
    }

    public void setN(int n) {
        if (n > 0) {
            this.n = n;
        } else {
            System.out.println("You entered the negative dimension or zero!");
        }
    }

    public void setM(int m) {
        if (m > 0) {
            this.m = m;
        } else {
            System.out.println("You entered the negative dimension or zero!");
        }
    }

    public void createArray() {
        if (n != 0 && m != 0) {
            array = new char[n][m];
        }
    }

    public void fillArray() {
        if (n != 0 && m != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = (char) (Math.random() * 26 + 97);
                }
            }
        }
    }

    public void outputArray() {
        if (n != 0 && m != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
