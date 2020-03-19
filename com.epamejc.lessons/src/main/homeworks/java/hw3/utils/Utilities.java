package homeworks.java.hw3.utils;

import java.util.Random;
import java.util.Scanner;

public class Utilities {

    /**
     * I did not close the Scanner because:
     * https://coderanch.com/wiki/678613/Don-close-Scanner-tied-System
     * https://www.omnijava.com/2018/08/23/if-you-are-using-javas-scanner-class-for-keyboard-input-then-you-might-be-doing-it-wrong/
     * https://stackoverflow.com/questions/52040576/scanner-close-method-closes-all-scanners-why
     */
    public static int scanNumber() {
        Scanner sc;
        int n = 0;

        boolean isError = true;
        while(isError) {
            sc = new Scanner(System.in);
            try {
                isError = false;
                System.out.print("Enter number: ");
                n = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong enter! ");
                isError = true;
            }
        }

        return n;
    }

    public static int[] scanNumbers() {
        Scanner sc;
        int numOfLines = 0;
        int numOfChars = 0;
        boolean isError = true;
        while(isError) {
            sc = new Scanner(System.in);
            try {
                isError = false;
                System.out.print("Enter the number of lines: ");
                numOfLines = sc.nextInt();
                System.out.print("Enter the number of characters: ");
                numOfChars = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong enter! ");
                isError = true;
            }
        }
        int[] numbers  = new int[] {numOfLines, numOfChars};
        return numbers;
    }

    public static char[][] buildArray(int[] numbers) {
        int numOfLines = numbers[0];
        int numOfChars = numbers[1];
        char[][] arr = new char[numOfLines][numOfChars];
        Random r = new Random();

        for (int i = 0; i < numOfLines; i++) {
            for (int j = 0; j < numOfChars; j++) {
                arr[i][j] = (char) (r.nextInt(26) + 'a');
            }
        }

        return arr;
    }

    public static void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
