package main.homeworks.hw3.arrays_3;

import java.util.Scanner;

public class PyramidGenerator {

    public void run() {
        printPyramid(scanNumber());
    }

    public int scanNumber() {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        int nCopy = 0;

        try {
            System.out.print("Enter number: ");
            n = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            scan.close();
        }

        return n;
    }

    public void printPyramid(int n) {
        int nCopy = n;
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nCopy; j++) {
                arr[i][j] = 'X';
                System.out.print(arr[i][j]);
            }
            nCopy--;
            System.out.println("");
        }
    }

}
