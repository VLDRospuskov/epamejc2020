package main.homeworks.hw2.arrays_2_2;

import java.util.*;

public class StringFromArr {
    public void run() {
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

        char[][] arr = fillArray(n1,n2);

        Scanner scan2 = new Scanner(System.in);
        String strategy = "";
        try {
            System.out.print("Enter strategy(A or B): ");
            strategy = scan2.nextLine();
        } catch (Exception e) {
            System.out.println("Wrong enter! " + e);
            System.exit(0);
        } finally {
            scan2.close();
        }

        System.out.println(getStrategy(n1, n2, arr, strategy));
    }

    public char[][] fillArray(int n1, int n2) {
        char[][] arr = new char[n1][n2];
        Random r = new Random();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[i][j] = (char) (r.nextInt(26) + 'a');
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        return arr;
    }

    public String getStrategy(int n1, int n2, char[][] arr, String strategy) {
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

        return output;
    }
}
