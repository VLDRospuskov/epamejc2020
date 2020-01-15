package homeworks.hw2.arrays_2_3;

import java.util.Scanner;

public class PyramidGen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        int n2 = 0;
        try {
            n = scan.nextInt();
            n2 = n;
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n2; j++) {
                arr[i][j] = 'X';
                System.out.print(arr[i][j]);
            }
            n2--;
            System.out.println("");
        }
    }
}
