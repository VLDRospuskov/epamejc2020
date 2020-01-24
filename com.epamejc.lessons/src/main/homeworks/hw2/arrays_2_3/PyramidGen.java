package main.homeworks.hw2.arrays_2_3;

import java.util.Scanner;

public class PyramidGen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        int nCopy = 0;
        try {
            System.out.print("Enter number: ");
            n = scan.nextInt();
            nCopy = n;
        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            scan.close();
        }

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
