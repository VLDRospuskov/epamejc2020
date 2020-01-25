package homeworks.holidaysHW.arrays;

import java.util.Scanner;

public class Pyramid {

    public static void buildPyramid(int size) {
        char[] pyrArray = new char[size];
        for (int i = 0; i < size; i++) {
            pyrArray[i] = 'X';
        }
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(pyrArray[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pyramid height: ");
        int height = in.nextInt();
        buildPyramid(height);
    }
}
