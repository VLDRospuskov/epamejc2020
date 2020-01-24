package main.homeworks.hw2.arrays_2_1;

import java.util.*;

public class ArrOfArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;
        try {
            System.out.print("Enter the number of lines: ");
            n1 = sc.nextInt();
            System.out.print("Enter the number of characters: ");
            n2 = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            sc.close();
        }
        char[][] arr = new char[n1][n2];
        Random r = new Random();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[i][j] = (char) (r.nextInt(26) + 'a');
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
