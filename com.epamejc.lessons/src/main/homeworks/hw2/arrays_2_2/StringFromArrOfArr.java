package main.homeworks.hw2.arrays_2_2;

import java.util.*;

public class StringFromArrOfArr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;
        try {
            n1 = scan.nextInt();
            n2 = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error!");
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
        Scanner scan2 = new Scanner(System.in);
        String strategy = scan2.nextLine();
        scan2.close();
        String output = "";
        if (strategy.equals("A")) {
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n2; j += 2) {
                    output += arr[i][j];
                }
            }
        } else if (strategy.equals("B")) {
            for (int i = 0; i < n1; i++) {
                for (int j = 1; j < n2; j += 2) {
                    output += arr[i][j];
                }
            }
        }
        System.out.println(output);
    }
}
