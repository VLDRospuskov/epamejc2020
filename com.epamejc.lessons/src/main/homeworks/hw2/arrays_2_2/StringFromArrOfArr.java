package main.homeworks.hw2.arrays_2_2;

import java.util.*;

public class StringFromArrOfArr {
    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 0;

        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Enter the number of lines: ");
            n1 = scan.nextInt();
            System.out.print("Enter the number of characters: ");
            n2 = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong enter! " + e);
            System.exit(0);
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
        System.out.print("Enter strategy(A or B): ");
        String strategy = scan2.nextLine();
        scan2.close();

        String output = "";

        if (strategy.equals("A") || strategy.equals("a")) {
            for (int i = 0; i < n1; i += 2) {
                for (int j = 0; j < n2; j += 2) {
                    output += arr[i][j];
                }
            }
        } else if (strategy.equals("B") || strategy.equals("b")) {
            for (int i = 0; i < n1; i += 2) {
                for (int j = 1; j < n2; j += 2) {
                    output += arr[i][j];
                }
            }
        } else {
            System.out.println("Wrong enter!");
        }

        System.out.println(output);
    }
}
